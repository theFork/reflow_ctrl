/**
 * Reflow control program entry and main method.
 * @author haggl
 *
 */
public final class ReflowControl {

    /**
     * Program entry point.
     * @param args TODO
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        final Communicator communicator = Communicator.getInstance();
        if (!communicator.connect("/dev/umidi")) {
            System.exit(-1);
        }
        for (int i=0; i<3; ++i) {
            communicator.transceive("temp");
            Thread.sleep(100);
        }
        communicator.disconnect();
    }
}
