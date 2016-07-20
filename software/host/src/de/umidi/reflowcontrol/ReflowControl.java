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

        // Start controller task
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(new Runnable() {
            private double temperature = 0;
            private double controllerOutput = 0;

            // TODO: Remove this block and implement "real" setpoint management
            private int setpointUpdateCounter = SETPOINT_UPDATE_PRESCALER;
            private static final int SETPOINT_UPDATE_PRESCALER = 10;
            private int setpointIndex = 0;
            private final double SETPOINTS[] = { 40, 80, 80, 80, 150, 150, 80, 60, 50, 40, 30, 20 };

            @Override
            public void run() {
                // TODO: Remove this block and implement "real" setpoint
                // management
                ++this.setpointUpdateCounter;
                if (this.setpointUpdateCounter >= SETPOINT_UPDATE_PRESCALER) {
                    this.setpointUpdateCounter = 0;

                    controller.updateSetpoint(SETPOINTS[this.setpointIndex]);

                    if (this.setpointIndex < SETPOINTS.length) {
                        ++this.setpointIndex;
                    }
                }

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
