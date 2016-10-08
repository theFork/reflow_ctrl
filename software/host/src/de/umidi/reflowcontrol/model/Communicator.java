package de.umidi.reflowcontrol.model;

import java.util.logging.Logger;

import jssc.SerialPort;
import jssc.SerialPortException;

/**
 * This class handles communication with the uMidi board controlling the heater.
 */
public final class Communicator {

    private boolean isConnected = false;
    private SerialPort port;

    private static final Logger LOGGER = Logger.getLogger(Communicator.class.getName());

    private String transceive(String command) {
        LOGGER.entering(getClass().getName(), "transceive");
        try {
            // Request
            LOGGER.finer("Request: " + command);
            this.port.writeBytes(command.getBytes());
            this.port.writeByte((byte) '\r');
            Thread.sleep(50);

            // Reply
            final String reply = this.port.readString();
            LOGGER.finer("Reply: " + reply);
            return reply;
        } catch (final Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public Boolean connect(String devicePath) {
        LOGGER.entering(getClass().getName(), "connect");
        this.port = new SerialPort(devicePath);
        try {
            LOGGER.info("Opening port " + devicePath);
            this.port.writeByte((byte) '\r');
            Thread.sleep(1000);
            this.isConnected = true;
            return true;
        } catch (Exception e) {
            LOGGER.warning("Failed to connect to " + devicePath);
            e.printStackTrace();
            return false;
        }
    }

    public void disconnect() {
        LOGGER.entering(getClass().getName(), "disconnect");
        try {
            LOGGER.info("Closing port: " + this.port.closePort());
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