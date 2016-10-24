package de.umidi.reflowcontrol.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import de.umidi.reflowcontrol.model.ReflowModel;
import de.umidi.reflowcontrol.model.TemperatureProfile;
import de.umidi.reflowcontrol.view.ReflowView;

/**
 * Main controller class
 */
public class ReflowController {
    // This class handles:
    // - Main function and setup
    // - Runnable for fixed-interval execution
    // - Tear down

    private static final Logger LOGGER = Logger.getLogger(TemperatureProfile.class.getName());

    private final static int CONTROL_INTERVAL_MILLIS = 1000;
    private final static String DEFAULT_DEVICE_PATH = "/dev/umidi";

    ReflowView view = new ReflowView();
    ReflowModel model = new ReflowModel();
    ScheduledExecutorService executor;

    ControlRunnable controlRunnable;

    /**
     * Time that has passed since playing a profile
     */
    private int profilePositionSeconds = -1;

    public static void main(String args[]) {

        ReflowController reflowController = new ReflowController();

        // Connect
        Boolean connected = reflowController.model.communicator.connect(DEFAULT_DEVICE_PATH);
        if (!connected) {
            LOGGER.warning("Connect method returned false.");
        }
        reflowController.view.showStatusConnected(connected);

        // Setup view
        reflowController.view.loadChartPanel(reflowController.model.getPlotDataset());
        reflowController.view.setVisible(true);
        reflowController.view.pack();
        reflowController.view.showStatusMessage("Welcome");

        // Start per-second-runnable
        reflowController.setupRunnable();

        // Run button
        reflowController.view.addRunButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reflowController.startButtonAction();
            }
        });

        // Stop button
        reflowController.view.addStopButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reflowController.stopButtonAction();
            }
        });

        // Quit button
        reflowController.view.addQuitButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reflowController.quitButtonAction();
            }
        });
    }

    public void setupRunnable() {
        // Hand the runnable a reference to this class
        controlRunnable = new ControlRunnable();
        controlRunnable.setController(this);

        // Create a new executer
        this.executor = Executors.newSingleThreadScheduledExecutor();
        this.executor.scheduleAtFixedRate(controlRunnable, 0, CONTROL_INTERVAL_MILLIS, TimeUnit.MILLISECONDS);
    }

    /**
     * Get the current position in the profile
     * 
     * @return The time that has passed since the profile was started in seconds
     *         or -1 when currently stopped.
     */
    public int getProfilePositionSeconds() {
        return this.profilePositionSeconds;
    }

    public void incrementProfilePosition() {
        this.profilePositionSeconds++;
    }

    private void startButtonAction() {

        // Clean up previously recorded data
        this.model.clearSeries();

        // Start
        this.controlRunnable.setRunning(true);
        this.profilePositionSeconds = 0;

        // Display message
        this.view.showStatusMessage("Running...");
    }

    private void stopButtonAction() {
        this.controlRunnable.setRunning(false);
        this.profilePositionSeconds = -1;

        // Display message
        this.view.showStatusMessage("Stopped.");
    }

    private void quitButtonAction() {
        this.model.communicator.disconnect();
        System.exit(0);
    }
}