import org.jfree.ui.RefineryUtilities;

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

    	// Display main window
		final MainWindow window = new MainWindow("Reflow Control");
        window.pack();
        RefineryUtilities.centerFrameOnScreen(window);
        window.setVisible(true);

        // Setup communicator
        final Communicator communicator = Communicator.getInstance();
        if (!communicator.connect("/dev/umidi")) {
            // TODO: Complain
        }
        
        // TODO: Start controller task
        
        // Tear down
        communicator.disconnect();
    }
}
