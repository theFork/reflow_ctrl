package de.umidi.reflowcontrol.ui;

import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * This class handles the collection and preparation of data to be plotted.
 */
public class GraphDataLogger {
    /**
     * Series containing temperature setpoints.
     */
    private XYSeries setpoint;

    /**
     * Series containing measured temperatures.
     */
    private XYSeries temperature;

    /**
     * Series containing PID controller output values.
     */
    private XYSeries pidOutput;

    /**
     * Series containing the P-term of the controller outputs.
     */
    private XYSeries pTerm;

    /**
     * Series containing the I-term of the controller outputs.
     */
    private XYSeries iTerm;

    /**
     * Series containing the D-term of the controller outputs.
     */
    private XYSeries dTerm;

    /**
     * Counter for data points added to the series.
     */
    private int sampleCount = 0;

    /**
     * Default constructor.
     *
     * Initializes all data series.
     */
    public GraphDataLogger() {
        this.temperature = new XYSeries("Current Temperature");
        this.setpoint = new XYSeries("Desired Temperature");
        this.pidOutput = new XYSeries("PID controller output");
        this.pTerm = new XYSeries("P-term");
        this.iTerm = new XYSeries("I-term");
        this.dTerm = new XYSeries("D-term");
    }

    /**
     * Adds data points to the series.
     *
     * @param setpoint
     *            current temperature setpoint
     * @param measurement
     *            current temperature measurement
     * @param pidOutput
     *            PID controller output
     * @param pTerm
     *            P-term of the PID controller output
     * @param iTerm
     *            I-term of the PID controller output
     * @param dTerm
     *            D-term of the PID controller output
     */
    public void addData(double setpoint, double measurement, double pidOutput, double pTerm, double iTerm,
            double dTerm) {
        this.setpoint.add(this.sampleCount, setpoint);
        this.temperature.add(this.sampleCount, measurement);
        this.pidOutput.add(this.sampleCount, pidOutput);
        this.pTerm.add(this.sampleCount, pTerm);
        this.iTerm.add(this.sampleCount, iTerm);
        this.dTerm.add(this.sampleCount, dTerm);
        ++this.sampleCount;
    }

    /**
     * Returns the data set for graph construction.
     *
     * @param debugController
     *            when set to `true`, PID controller debug data is included in
     *            the data set
     * @return the data set
     */
    public XYDataset getDataset(boolean debugController) {
        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(this.temperature);
        dataset.addSeries(this.setpoint);
        if (debugController) {
            dataset.addSeries(this.pidOutput);
            dataset.addSeries(this.pTerm);
            dataset.addSeries(this.iTerm);
            dataset.addSeries(this.dTerm);
        }
        return dataset;
    }
}