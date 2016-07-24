package de.umidi.reflowcontrol;

import java.awt.EventQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import de.umidi.reflowcontrol.ui.GraphDataLogger;
import de.umidi.reflowcontrol.ui.MainWindow;

/**
 * Reflow control program entry and main method.
 */
public final class ReflowControl {
    /**
     * Control loop interval in [ms].
     */
    public static final int CONTROL_LOOP_INTERVAL = 1000;

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
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainWindow mainWindow = new MainWindow(logger.getDataset());
                mainWindow.setVisible(true);
            }
        });

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

            private int time = 0;

            @Override
            public void run() {
                // Get current setpoint from profile
                controller.updateSetpoint(profile.getSetpoint(time));
                time++;

                // TODO: Remove this block and fetch measured temperature
                // Fiddle with the output value to simulate some kind of system
                // behavior.
                this.temperature += (this.controllerOutput - this.temperature) * 0.123; // inertia
                this.temperature -= 7.238; // constant offset
                this.temperature *= 0.95; // dissipation

                // Invoke PID controller
                this.controllerOutput = controller.process(this.temperature);

                // Log data
                logger.addData(controller.getSetpoint(), this.temperature);
            }
        }, 0, CONTROL_LOOP_INTERVAL, TimeUnit.MILLISECONDS);

        // Tear down
        communicator.disconnect();
    }
}
