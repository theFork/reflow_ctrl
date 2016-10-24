package de.umidi.reflowcontrol.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.general.Dataset;
import org.jfree.data.xy.XYDataset;

@SuppressWarnings("serial")
/**
 * Central view class. Represents the one and only window
 */
public class ReflowView extends JFrame {

    // This class handles:
    // - status bar
    // - plot pane (Chart and Chartpanel)
    // - run and stop buttons

    private final String PLOT_TITLE = "";
    private final String PLOT_XLABEL = "t [s]";
    private final String PLOT_YLABEL = "T [°C]";

    private ButtonBar buttonBar = new ButtonBar();
    private StatusBar statusBar = new StatusBar();
    private JFreeChart chart;
    private ChartPanel chartPanel;

    public ReflowView() {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(0, 5));

        // Add button and status bars
        this.add(buttonBar, BorderLayout.NORTH);
        this.add(statusBar, BorderLayout.SOUTH);
    }

    /**
     * Initialize and display chart panel
     * 
     * @param dataset
     *            the dataset to be linked to the chart panel
     */
    public void loadChartPanel(Dataset dataset) {
        this.chart = ChartFactory.createXYLineChart(PLOT_TITLE, PLOT_XLABEL, PLOT_YLABEL, (XYDataset) dataset);

        // Configure renderer
        final XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(false, true);

        styleRendererSeries(renderer, 0, true, false, Color.GREEN, 1, 1); // setpoint
        styleRendererSeries(renderer, 1, true, false, Color.RED, 5, 5); // current
                                                                        // temperature
        styleRendererSeries(renderer, 2, false, true, Color.DARK_GRAY, 3, 1); // duty
                                                                              // cycle
        plot.setRenderer(renderer);

        this.chartPanel = new ChartPanel(chart);
        this.add(chartPanel, BorderLayout.CENTER);
    }

    private void styleRendererSeries(XYLineAndShapeRenderer renderer, int seriesID, boolean lines, boolean shapes,
            Color color, int width, int height) {
        renderer.setSeriesPaint(seriesID, color);
        renderer.setSeriesShape(seriesID, new Rectangle((int) -(width / 2), (int) -(height / 2), width, height));

        renderer.setSeriesLinesVisible(seriesID, lines);
        renderer.setSeriesShapesVisible(seriesID, shapes);
    }

    /* STATUS BAR SETTERS */

    public void showStatusConnected(boolean connected) {
        this.statusBar.showConnected(connected);
    }

    public void showStatusMessage(String message) {
        this.statusBar.showMessage(message);
    }

    public void showStatusTemperatures(double setpoint, double currentTemperature) {
        this.statusBar.showTemperatures(setpoint, currentTemperature);
    }

    /* BUTTON ACTION LISTENER ADDERS */

    public void addRunButtonActionListener(ActionListener l) {
        this.buttonBar.runButton.addActionListener(l);
    }

    public void addStopButtonActionListener(ActionListener l) {
        this.buttonBar.stopButton.addActionListener(l);
    }

    public void addQuitButtonActionListener(ActionListener l) {
        this.buttonBar.quitButton.addActionListener(l);
    }

}
