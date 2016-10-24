package de.umidi.reflowcontrol.controller;

import java.util.logging.Logger;

public class ControlRunnable implements Runnable {

    private boolean running = false;

    private ReflowController controller;
    private static final Logger LOGGER = Logger.getLogger(ControlRunnable.class.getName());

    /**
     * Executed by the controller in fixed intervals (1s)
     */
    @Override
    public void run() {

        // Get current time
        int currentTime = controller.getProfilePositionSeconds();
        LOGGER.fine("t=" + currentTime + " s");

        // Measure
        float currentTemperature = controller.model.communicator.getTemperature();
        LOGGER.fine("T_cur=" + currentTemperature + " °C");

        if (!running) {
            controller.view.showStatusTemperatures(0, currentTemperature);
            return;
        }

        // Add current temperature to plot
        controller.model.addMeasuredValue(currentTime, currentTemperature);

        // Determine shot duration / duty cycle
        float setpoint = controller.model.getSetpoint(currentTime);
        LOGGER.fine("T_set=" + setpoint + " °C");
        int nextShotMillis = controller.model.getNextShotMillis(setpoint, currentTemperature);
        LOGGER.fine("Next shot: " + nextShotMillis + " ms");
        controller.model.addDutyCycle(currentTime, (int) (nextShotMillis / 10));

        // Heat
        controller.model.communicator.shot(nextShotMillis);
        controller.incrementProfilePosition();

        // Update status bar
        controller.view.showStatusTemperatures(setpoint, currentTemperature);
    }

    public void setController(ReflowController reflowController) {
        this.controller = reflowController;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
