package de.umidi.reflowcontrol.controller;

public class ControlRunnable implements Runnable {

    private ReflowController controller;

    /**
     * Executed by the controller in fixed intervals (1s)
     */
    @Override
    public void run() {
        // Get current time
        int currentTime = controller.getProfilePositionSeconds();
        System.out.println("t=" + currentTime + " s");

        // Measure
        float currentTemperature = controller.model.communicator.getTemperature();
        controller.model.addMeasuredValue(currentTime, currentTemperature);
        System.out.println("T_cur=" + currentTemperature + " °C");

        // Determine shot duration / duty cycle
        float setpoint = controller.model.getSetpoint(currentTime);
        System.out.println("T_set=" + setpoint + " °C");
        int nextShotMillis = controller.model.getNextShotMillis(setpoint, currentTemperature);
        System.out.println("Next shot: " + nextShotMillis + " ms");
        controller.model.addDutyCycle(currentTime, (int) (nextShotMillis / 10));

        // Heat
        controller.model.communicator.shot(nextShotMillis);
        controller.incrementProfilePosition();
    }

    public void setController(ReflowController reflowController) {
        this.controller = reflowController;
    }
}
