package de.umidi.reflowcontrol;

import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import de.umidi.reflowcontrol.ui.GraphDataLogger;
import de.umidi.reflowcontrol.ui.MainWindow;

/**
 * Reflow control program entry and main method.
 */
public final class ReflowControl {
    /**
     * When set, the graph contains details about the PID controller output for
     * debugging purposes.
     */
    public static final boolean DEBUG_CONTROLLER = false;

    /**
     * Control loop interval in [ms].
     */
    public static final int CONTROL_LOOP_INTERVAL = 1000;

    public static MainWindow mainWindow = null;

    /**
     * Global PID controller instance.
     */
    private static final PIDController controller = new PIDController(CONTROL_LOOP_INTERVAL, 5.0, 5.0, 1.0);

    /**
     * Global data logger instance.
     */
    private static final GraphDataLogger logger = new GraphDataLogger();

    /**
     * Current temperature profile.
     */
    private static TemperatureProfile profile;

    /**
     * Program entry point.
     * 
     * @param args
     *            TODO
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // Display main window
        try {
            EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    ReflowControl.mainWindow = new MainWindow(logger.getDataset(DEBUG_CONTROLLER));
                    ReflowControl.mainWindow.setVisible(true);
                }
            });
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // Setup communicator
        final Communicator communicator = Communicator.getInstance();
        if (!communicator.connect("/dev/umidi")) {
            // TODO: Complain
        }

        // Load temperature profile
        profile = new TemperatureProfile();
        profile.loadFile("profiles/test.csv");

        // Start controller task
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(new Runnable() {
            private double temperature = 0;
            private double controllerOutput = 0;
            private double setpoint = 0;

            private int time = 0;

            @Override
            public void run() {
                // Get current setpoint from profile]
                setpoint = profile.getSetpoint(time);
                controller.updateSetpoint(setpoint);
                ReflowControl.mainWindow.statusBar.showTemperatures(setpoint, this.temperature);
                time++;

                // Fetch measured temperature from controller board
                this.temperature = communicator.getTemperature();

                // Invoke PID controller
                this.controllerOutput = controller.process(this.temperature);

                // Convert controller output to duty cycle and send shot command
                double duty = CONTROL_LOOP_INTERVAL < this.controllerOutput ? CONTROL_LOOP_INTERVAL
                        : this.controllerOutput;
                communicator.shot((int) duty);

                // Log data
                logger.addData(controller.getSetpoint(), this.temperature, this.controllerOutput,
                        controller.getLastProportionalTerm(), controller.getLastIntegralTerm(),
                        controller.getLastDifferentialTerm());
            }
        }, 0, CONTROL_LOOP_INTERVAL, TimeUnit.MILLISECONDS);

        // Tear down
        // TODO: This must be done in some kind of SWT teardown callback
        // communicator.disconnect();
    }
}
