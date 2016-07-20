package de.umidi.reflowcontrol;

/**
 * Generic PID controller.
 */
public class PIDController {
    /**
     * Control loop interval in [s].
     */
    private final double dt;

    /**
     * Proportional coefficient.
     */
    private final double Kp;

    /**
     * Integral coefficient.
     */
    private final double Ki;

    /**
     * Differential coefficient.
     */
    private final double Kd;

    /**
     * Internal buffer for the integrator.
     */
    private double integral = 0.0;

    /**
     * Internal buffer for the differentiator.
     */
    private double previous_error = 0.0;

    /**
     * Current setpoint of the controller.
     */
    private double setpoint = 0.0;

    /**
     * Standard constructor.
     *
     * @param dt
     *            the control loop interval in [ms].
     * @param Kp
     *            the proportional coefficient
     * @param Ki
     *            the integral coefficient
     * @param Kd
     *            the differential coefficient
     */
    public PIDController(double dt, double Kp, double Ki, double Kd) {
        // Convert dt: [ms] -> [s]
        this.dt = dt / 1000;
        this.Kp = Kp;
        this.Ki = Ki;
        this.Kd = Kd;
    }

    /**
     * @return the current setpoint of the controller
     */
    public double getSetpoint() {
        return this.setpoint;
    }

    /**
     * @param the
     *            new setpoint
     */
    public void updateSetpoint(double setpoint) {
        this.setpoint = setpoint;
    }

    /**
     * Main control routine.
     *
     * Computes the PID controller output based on the provided setpoint and
     * measured value.
     *
     * @param setpoint
     *            the desired setpoint
     * @param measured_value
     *            the last known actual state of the output
     * @return the next output value
     */
    public double process(double measured_value) {
        double error = this.setpoint - measured_value;
        this.integral += error * this.dt;
        double derivative = (error - this.previous_error) / this.dt;
        double output = this.Kp * error + this.Ki * this.integral + this.Kd * derivative;
        this.previous_error = error;
        return output;
    }
}
