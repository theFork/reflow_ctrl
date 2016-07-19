package de.umidi.reflowcontrol.ui;

import java.awt.BorderLayout;
import java.text.NumberFormat;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;

/**
 * So far, just a proof of concept...
 * 
 * @author simon
 */
public final class MainWindow {

	private static final String title = "Reflow Control";
	private ChartPanel chartPanel = createChart();

	public MainWindow() {
		// Prepare JFrame
		JFrame f = new JFrame(title);
		f.setTitle(title);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new BorderLayout(0, 5));

		// Add temperature graph panel
		f.add(chartPanel, BorderLayout.CENTER);
		chartPanel.setMouseWheelEnabled(true);
		chartPanel.setHorizontalAxisTrace(true);
		chartPanel.setVerticalAxisTrace(true);

		// Display window
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

	private ChartPanel createChart() {
		XYDataset roiData = new GraphDataLogger().getDataset();
		JFreeChart chart = ChartFactory.createTimeSeriesChart(title, "Date", "Value", roiData, true, true, false);
		XYPlot plot = chart.getXYPlot();
		XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
		renderer.setBaseShapesVisible(true);
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		currency.setMaximumFractionDigits(0);
		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setNumberFormatOverride(currency);
		return new ChartPanel(chart);
	}
}
