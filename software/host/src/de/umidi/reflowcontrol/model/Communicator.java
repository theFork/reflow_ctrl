package de.umidi.reflowcontrol.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            System.out.println(">> " + command);
            this.port.writeBytes(command.getBytes());
            this.port.writeByte((byte) '\r');
            Thread.sleep(10);

            // Reply, strip reply line omitting local echo
            final String reply = this.port.readString();
            final Pattern pattern = Pattern.compile(".*\r\n(.*)\r\n*");
            final Matcher matcher = pattern.matcher(reply);
            if (matcher.find()) {
                System.out.println("<< " + matcher.group(1));
            }
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
        // TODO: Read three times; Compare; Warn if there is a large difference;
        // Else return the average
        String reply = transceive("temp");
        float temperature = Float.parseFloat(reply.substring(reply.indexOf(':') + 1));
        return temperature;
    }

    public void shot(int milliseconds) {
        int tenMillis = milliseconds / 10;
        if (tenMillis > 0) {
            transceive("shot " + tenMillis);
        }
    }
}
