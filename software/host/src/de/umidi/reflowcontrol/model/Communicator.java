package de.umidi.reflowcontrol.model;

import jssc.SerialPort;
import jssc.SerialPortException;

/**
 * This class handles communication with the uMidi board controlling the heater.
 */
public final class Communicator {

    private boolean isConnected = false;
    private SerialPort port;

    private String transceive(String command) {
        try {
            // Request
            this.port.writeBytes(command.getBytes());
            this.port.writeByte((byte) '\r');
            Thread.sleep(10);

            // Reply
            final String reply = this.port.readString();
            return reply;
        } catch (final Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public Boolean connect(String devicePath) {
        this.port = new SerialPort(devicePath);
        try {
            System.out.println("Opening port: " + this.port.openPort());
            this.port.writeByte((byte) '\r');
            Thread.sleep(1000);
            this.isConnected = true;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void disconnect() {
        try {
            System.out.println("Closing port: " + this.port.closePort());
            this.isConnected = false;
        } catch (final SerialPortException e) {
            e.printStackTrace();
        }
    }

    public boolean isConnected() {
        return this.isConnected;
    }

    public float getTemperature() {
        final int sampleCount = 5;

        // Read N values
        float temperatures[] = new float[sampleCount];
        for (int i = 0; i < sampleCount; i++) {
            String reply = transceive("temp");
            temperatures[i] = Float.parseFloat(reply.substring(reply.indexOf(':') + 1));
        }

        // TODO: Warn if there are major differences

        // Return the average
        float temperature = 0;
        for (int i = 0; i < sampleCount; i++) {
            temperature += temperatures[i];
        }
        temperature = temperature / sampleCount;
        return temperature;
    }

    public void shot(int milliseconds) {
        int tenMillis = milliseconds / 10;
        if (tenMillis > 0) {
            transceive("shot " + tenMillis);
        }
    }
}
