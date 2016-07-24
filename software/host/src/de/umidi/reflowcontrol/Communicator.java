package de.umidi.reflowcontrol;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jssc.SerialPort;
import jssc.SerialPortException;

/**
 * This class handles communication with the uMidi board controlling the heater.
 */
public final class Communicator {
    /**
     * Static singleton instance.
     */
    private static Communicator instance;

    /**
     * Factory method.
     *
     * @return an existing singleton instance or a new one if necessary
     */
    public static Communicator getInstance() {
        if (instance == null) {
            instance = new Communicator();
        }
        return instance;
    }

    private SerialPort port;

    /**
     * Private default Constructor to avoid instantiation.
     */
    private Communicator() {
    }

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
            System.out.println("Setting parameters`: " + this.port.setParams(9600, 8, 1, 0));
            this.port.writeByte((byte) '\r');
            Thread.sleep(1000);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void disconnect() {
        try {
            System.out.println("Closing port: " + this.port.closePort());
        } catch (final SerialPortException e) {
            e.printStackTrace();
        }
    }

    public float getTemperature() {
        String reply = transceive("temp");
        float temperature = Float.parseFloat(reply.substring(reply.indexOf(':') + 1));
        return temperature;
    }

    public void shot(int milliseconds) {
        transceive("shot " + milliseconds / 10);
    }
}
