package de.umidi.reflowcontrol.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import de.umidi.reflowcontrol.model.ReflowModel;
import de.umidi.reflowcontrol.view.ReflowView;

/**
 * Main controller class
 */
public class ReflowController {
    // This class handles:
    // - Main function and setup
    // - Runnable for fixed-interval execution
    // - Tear down

    private final static int CONTROL_INTERVAL_MILLIS = 1000;
    private final static String DEFAULT_DEVICE_PATH = "/dev/umidi";

    ReflowView view = new ReflowView();
    ReflowModel model = new ReflowModel();
    ScheduledExecutorService executor;

    /**
     * Time that has passed since playing a profile
     */
    private int profilePositionSeconds = -1;

    public static void main(String args[]) {

        ReflowController reflowController = new ReflowController();

        // Setup model
        reflowController.model.communicator.connect(DEFAULT_DEVICE_PATH);

        // Setup view
        reflowController.view.loadChartPanel(reflowController.model.getPlotDataset());
        reflowController.view.setVisible(true);
        reflowController.view.pack();

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
        // Hand the runnable a reference to this class
        ControlRunnable controlRunnable = new ControlRunnable();
        controlRunnable.setController(this);

        // Always create a new executer
        this.executor = Executors.newSingleThreadScheduledExecutor();
        this.executor.scheduleAtFixedRate(controlRunnable, 0, CONTROL_INTERVAL_MILLIS, TimeUnit.MILLISECONDS);

        this.profilePositionSeconds = 0;
    }

    private void stopButtonAction() {
        this.executor.shutdown();
        this.profilePositionSeconds = -1;
    }

    private void quitButtonAction() {
        this.model.communicator.disconnect();
        System.exit(0);
    }
}