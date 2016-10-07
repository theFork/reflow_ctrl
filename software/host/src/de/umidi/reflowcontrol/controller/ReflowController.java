package de.umidi.reflowcontrol.controller;

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

    private final int CONTROL_INTERVAL_MILLIS = 1000;

    ReflowView view = new ReflowView();
    ReflowModel model = new ReflowModel();
    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    public static void main(String args[]) {

        ReflowController reflowController = new ReflowController();

        // Setup view
        reflowController.view.setVisible(true);

        // Setup model

        // Run button
        // TODO
        reflowController.startButtonAction();

        // Stop button

        // Quit button
    }

    private void startButtonAction() {
        ControlRunnable r = new ControlRunnable();
        executor.scheduleAtFixedRate(r, 0, CONTROL_INTERVAL_MILLIS, TimeUnit.MILLISECONDS);
    }

    private void stopButtonAction() {

    }

    private void quitButtonAction() {

        System.exit(0);
    }
}