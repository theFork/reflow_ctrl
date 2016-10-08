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

    private XYSeriesCollection plotDataset;

    public ReflowModel() {

        // Init communicator
        this.communicator = new Communicator();

        // Init data series
        setpointSeries = TemperatureProfileReader.loadFile(DEFAULT_PROFILE_PATH);
        setpointSeries.setKey("Setpoint");
        temperatureSeries = new XYSeries("Measured");

        // Init plot dataset
        plotDataset = new XYSeriesCollection();
        plotDataset.addSeries(setpointSeries);
        plotDataset.addSeries(temperatureSeries);
    }

    public Dataset getPlotDataset() {
        return plotDataset;
    }

    public float getCurrentTemperature() {
        return communicator.getTemperature();
    }

    public void addMeasuredValue(int time, float temperature) {
        temperatureSeries.add(time, temperature);
    }
}
