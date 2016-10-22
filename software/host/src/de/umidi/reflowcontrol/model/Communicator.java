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

    /**
     * Specifies the range in which measured value may scatter without a warning
     */
    private static final float MAX_SCATTERING_DEGREES = 1.0f;

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
            if (!port.openPort()) {
                LOGGER.severe("Failed to open port " + devicePath);
            }
        } catch (SerialPortException e1) {
            e1.printStackTrace();
        }

        try {
            this.port.writeByte((byte) '\r');
            Thread.sleep(50);
            this.isConnected = true;
            return true;
        } catch (Exception e) {
            LOGGER.warning("Failed to write byte");
            e.printStackTrace();
            return false;
        }
    }

    public void disconnect() {
        LOGGER.entering(getClass().getName(), "disconnect");
        if (!isConnected) {
            LOGGER.warning("Will not disconnect - already disconnected");
            return;
        }
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

        // Check and warn if there are major differences
        float min = Float.MAX_VALUE;
        float max = 0;
        for (float f : temperatures) {
            if (f > max) {
                max = f;
            }
            if (f < min) {
                min = f;
            }
        }
        if ((max - min) > MAX_SCATTERING_DEGREES) {
            LOGGER.warning("Major differences in measured temperatures: Min=" + min + ", Max=" + max);
        }

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