import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jssc.SerialPort;
import jssc.SerialPortException;

/**
 * This class handles communication with the uMidi board controlling the heater.
 *
 * @author haggl
 *
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

    public Boolean connect(String devicePath) {
        this.port = new SerialPort(devicePath);
        try {
            System.out.println("Opening port: " + this.port.openPort());
            System.out.println("Setting parameters`: " + this.port.setParams(9600, 8, 1, 0));
            this.port.writeByte((byte)'\r');
            Thread.sleep(1000);
            return true;
        } catch (final SerialPortException e) {
            System.out.println(e);
            return false;
        } catch (final InterruptedException u) {
            // TODO Auto-generated catch block
            u.printStackTrace();
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

    public String transceive(String command) throws InterruptedException {
        try {
            // Request
            System.out.println(">> " + command);
            Thread.sleep(100);
            this.port.writeBytes(command.getBytes());
            this.port.writeByte((byte)'\r');


            // Reply, strip reply line omitting local echo
            final String reply = this.port.readString();
            final Pattern pattern = Pattern.compile(".*\r\n(.*)\r\n*");
            final Matcher matcher = pattern.matcher(reply);
            if (matcher.find())
            {
                System.out.println(matcher.group(1));
            }
            return reply;

            // Remove echo from uMidi board
        } catch (final SerialPortException e) {
            e.printStackTrace();
            return null;
        }
    }
}
