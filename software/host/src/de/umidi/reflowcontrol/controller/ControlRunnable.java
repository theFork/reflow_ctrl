package de.umidi.reflowcontrol.controller;

public class ControlRunnable implements Runnable {

    private ReflowController controller;

    /**
     * Executed by the controller in fixed intervals (1s)
     */
    @Override
    public void run() {
        float tmp = controller.model.communicator.getTemperature();

        controller.model.addMeasuredValue(controller.getProfilePositionSeconds(), tmp);
        controller.incrementProfilePosition();
    }

    public void setController(ReflowController reflowController) {
        this.controller = reflowController;
    }
}
