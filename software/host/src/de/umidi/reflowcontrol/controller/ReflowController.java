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

    private final int CONTROL_INTERVAL_MILLIS = 1000;

    ReflowView view = new ReflowView();
    ReflowModel model = new ReflowModel();
    ScheduledExecutorService executor;

    public static void main(String args[]) {

        ReflowController reflowController = new ReflowController();

        // Setup model

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

    private void startButtonAction() {
        this.executor = Executors.newSingleThreadScheduledExecutor();
        ControlRunnable r = new ControlRunnable();
        this.executor.scheduleAtFixedRate(r, 0, CONTROL_INTERVAL_MILLIS, TimeUnit.MILLISECONDS);
    }

    private void stopButtonAction() {
        this.executor.shutdown();
    }

    private void quitButtonAction() {
        // TODO: Tear down
        System.exit(0);
    }
}