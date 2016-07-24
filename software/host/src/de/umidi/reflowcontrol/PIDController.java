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
     * Differential coefficient.
     */
    private final double Kd;

    /**
     * Integral coefficient.
     */
    private final double Ki;

    /**
     * Proportional coefficient.
     */
    private final double Kp;

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
     * Differential part of the last output value.
     */
    private double differentialTerm = 0.0;

    /**
     * Integral part of the last output value.
     */
    private double integralTerm = 0.0;

    /**
     * Proportional part of the last output value.
     */
    private double proportionalTerm = 0.0;

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

    public double getLastDifferentialTerm() {
        return differentialTerm;
    }

    public double getLastIntegralTerm() {
        return integralTerm;
    }

    public double getLastProportionalTerm() {
        return proportionalTerm;
    }

    /**
     * Main control routine.
     *
     * Computes the PID controller output based on the provided setpoint and
     * measured value.
     *
     * @param measured_value
     *            the last known actual state of the controlled variable
     * @return the regulating variable
     */
    public double process(double measured_value) {
        double error = this.setpoint - measured_value;
        this.integral += error * this.dt;
        double derivative = (error - this.previous_error) / this.dt;
        this.proportionalTerm = this.Kp * error;
        this.integralTerm = this.Ki * this.integral;
        this.differentialTerm = this.Kd * derivative;
        this.previous_error = error;
        return this.proportionalTerm + this.integralTerm + this.differentialTerm;
    }

    /**
     * Updates the PID controller's setpoint.
     * 
     * @param setpoint
     *            the new setpoint
     */
    public void updateSetpoint(double setpoint) {
        this.setpoint = setpoint;
    }
}
