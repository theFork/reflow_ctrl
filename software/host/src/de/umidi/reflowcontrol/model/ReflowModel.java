package de.umidi.reflowcontrol.model;

import org.jfree.data.general.Dataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public final class ReflowModel {

    // This class handles:
    // - Reflow profile
    // - Communicator
    // - Plot Dataset
    // - Duty cylce calculation

    private final String DEFAULT_PROFILE_PATH = "profiles/test.csv";

    private final static float FULL_POWER_UNTIL_ERROR_DEG_CELSIUS = 10;
    private final int LINEAR_RANGE_POWER_MAX_MILLIS = 500;

    /**
     * The communicator is made public in order to allow the controller to
     * access its method.
     */
    public Communicator communicator;

    /**
     * Series containing temperature setpoints
     */
    private XYSeries setpointSeries;

    /**
     * Series containing measured temperatures.
     */
    private XYSeries temperatureSeries;

    private XYSeries dutyCycleSeries;

    private XYSeriesCollection plotDataset;

    public ReflowModel() {

        // Init communicator
        this.communicator = new Communicator();

        // Init data series
        setpointSeries = TemperatureProfileReader.loadFile(DEFAULT_PROFILE_PATH);
        setpointSeries.setKey("Setpoint");
        temperatureSeries = new XYSeries("Measured");
        dutyCycleSeries = new XYSeries("DutyCycle");

        // Init plot dataset
        plotDataset = new XYSeriesCollection();
        plotDataset.addSeries(setpointSeries);
        plotDataset.addSeries(temperatureSeries);
        plotDataset.addSeries(dutyCycleSeries);
    }

    public Dataset getPlotDataset() {
        return plotDataset;
    }

    public void addMeasuredValue(int time, float temperature) {
        temperatureSeries.add(time, temperature);
    }

    public void addDutyCycle(int time, int dutyCycle) {
        dutyCycleSeries.add(time, dutyCycle);
    }

    public float getSetpoint(int time) {
        return setpointSeries.getY(time).floatValue();
    }

    /**
     * Uses a piecewise linear approach to determine the heating duration
     * 
     * @param temperatureSetpoint
     * @param currentTemperature
     * @return
     */
    public int getNextShotMillis(float temperatureSetpoint, float currentTemperature) {

        float error = temperatureSetpoint - currentTemperature;

        // Don't heat if we're too hot
        if (error <= 0) {
            return 0;
        }
        // Linear range
        else if (error <= FULL_POWER_UNTIL_ERROR_DEG_CELSIUS) {
            float slope = LINEAR_RANGE_POWER_MAX_MILLIS / FULL_POWER_UNTIL_ERROR_DEG_CELSIUS;
            return (int) (slope * error);
        }
        // Full power when we're outside the linear area
        else {
            return 1000;
        }
    }
}
