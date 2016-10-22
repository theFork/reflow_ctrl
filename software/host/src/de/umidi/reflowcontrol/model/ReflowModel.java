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

    private final String DEFAULT_PROFILE_PATH = "profiles/pb-free.csv";

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
        TemperatureProfile reader = new TemperatureProfile(DEFAULT_PROFILE_PATH);
        setpointSeries = reader.getSetpointSeries();
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
     * Determine the heating duration
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
        // Full power if we're too cold
        else {
            return 1000;
        }
    }

    /**
     * Clears temperature and duty cycle series
     */
    public void clearSeries() {
        temperatureSeries.clear();
        dutyCycleSeries.clear();
    }
}
