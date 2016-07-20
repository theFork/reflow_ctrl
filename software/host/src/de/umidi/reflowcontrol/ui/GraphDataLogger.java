package de.umidi.reflowcontrol.ui;

import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * This class handles the collection and preparation of data to be plotted.
 * 
 * @author simon
 */
public class GraphDataLogger {

    private XYSeries temperature;
    private XYSeries temperatureSetpoint;

    public GraphDataLogger() {
        temperature = new XYSeries("Current Temperature");
        temperatureSetpoint = new XYSeries("Desired Temperature");
    }

    public void addValue() {
        // TODO: This function should be called by the backend to add values
        // to be plottet
    }

    public XYDataset getDataset() {
        // TODO: This is a stub
        temperature.add(1.0, 35.0);
        temperature.add(2.0, 36.0);
        temperature.add(3.0, 45.0);
        temperature.add(4.0, 90.0);
        temperature.add(5.0, 190.0);
        temperature.add(6.0, 290.0);
        temperature.add(7.0, 330.0);
        temperature.add(8.0, 300.0);

        temperatureSetpoint.add(1.0, 33.0);
        temperatureSetpoint.add(2.0, 34.0);
        temperatureSetpoint.add(3.0, 41.0);
        temperatureSetpoint.add(4.0, 80.0);
        temperatureSetpoint.add(5.0, 10.0);
        temperatureSetpoint.add(6.0, 390.0);
        temperatureSetpoint.add(7.0, 310.0);
        temperatureSetpoint.add(8.0, 302.0);

        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(temperature);
        dataset.addSeries(temperatureSetpoint);

        return dataset;
    }
}