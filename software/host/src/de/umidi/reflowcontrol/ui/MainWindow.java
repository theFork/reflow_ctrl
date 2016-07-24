package de.umidi.reflowcontrol.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;

/**
 * So far, just a proof of concept...
 */
@SuppressWarnings("serial")
public final class MainWindow extends JFrame {

    private static final String title = "Reflow Control";
    private static final String xLabel = "Time [s]";
    private static final String yLabel = "Temperature [°C]";

    public StatusBar statusBar;

    public MainWindow(XYDataset data) {
        // Prepare JFrame
        super();
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(0, 5));

        // Add temperature graph panel
        ChartPanel chartPanel = new ChartPanel(ChartFactory.createXYLineChart(title, xLabel, yLabel, data,
                PlotOrientation.VERTICAL, true, true, false));
        this.add(chartPanel, BorderLayout.CENTER);
        chartPanel.setMouseWheelEnabled(true);
        chartPanel.setHorizontalAxisTrace(true);
        chartPanel.setVerticalAxisTrace(true);

        // Add menu bar
        MenuBar menuBar = new MenuBar();
        this.add(menuBar, BorderLayout.NORTH);

        // Add status bar
        statusBar = new StatusBar();
        this.add(statusBar, BorderLayout.SOUTH);

        // TODO: Call these methods somewhere else!
        statusBar.showConnected(false);
        statusBar.showMessage("Welcome!");
        statusBar.showTemperatures(50, 52.4);

        // Display window
        this.pack();
        this.setLocationRelativeTo(null);
    }
}
