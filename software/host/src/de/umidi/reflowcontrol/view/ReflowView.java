package de.umidi.reflowcontrol.view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
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

    public void loadChartPanel(Dataset dataset) {
        this.chart = ChartFactory.createXYLineChart(PLOT_TITLE, PLOT_XLABEL, PLOT_YLABEL, (XYDataset) dataset);
        this.chartPanel = new ChartPanel(chart);
        this.add(chartPanel, BorderLayout.CENTER);
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
