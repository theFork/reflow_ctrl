package de.umidi.reflowcontrol.ui;

import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * This class handles the collection and preparation of data to be plotted.
 */
public class GraphDataLogger {

    private XYSeries temperature;
    private XYSeries temperatureSetpoint;

    private int sampleCount = 0;

    public GraphDataLogger() {
        temperature = new XYSeries("Current Temperature");
        temperatureSetpoint = new XYSeries("Desired Temperature");
    }

    public void addData(double setpoint, double measurement) {
        this.temperatureSetpoint.add(this.sampleCount, setpoint);
        this.temperature.add(this.sampleCount, measurement);
        ++this.sampleCount;
    }

    public XYDataset getDataset() {
        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(temperature);
        dataset.addSeries(temperatureSetpoint);
        return dataset;
    }
}