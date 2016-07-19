package de.umidi.reflowcontrol.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * So far, just a proof of concept...
 * @author simon
 */
public final class MainWindow {
	
	private static final String title = "Reflow Control";
	private ChartPanel chartPanel = createChart();

	public MainWindow() {
		JFrame f = new JFrame(title);
        f.setTitle(title);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout(0, 5));
        f.add(chartPanel, BorderLayout.CENTER);
        chartPanel.setMouseWheelEnabled(true);
        chartPanel.setHorizontalAxisTrace(true);
        chartPanel.setVerticalAxisTrace(true);
        
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        f.add(panel, BorderLayout.SOUTH);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true); 
	}
		 
	/**
	 * Create a sample dataset
	 * 
	 * @return a sample dataset
	 */
	private XYDataset createDataset() {
		
		final XYSeries temperature = new XYSeries("Current Temperature");
		temperature.add(1.0, 35.0);
		temperature.add(2.0, 36.0);
		temperature.add(3.0, 45.0);
		temperature.add(4.0, 90.0);
		temperature.add(5.0, 190.0);
		temperature.add(6.0, 290.0);
		temperature.add(7.0, 330.0);
		temperature.add(8.0, 300.0);

		final XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(temperature);
				
		return dataset;
	}
	
    private ChartPanel createChart() {
    	XYDataset roiData = createDataset();
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
            title, "Date", "Value", roiData, true, true, false);
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer =
            (XYLineAndShapeRenderer) plot.getRenderer();
        renderer.setBaseShapesVisible(true);
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        currency.setMaximumFractionDigits(0);
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setNumberFormatOverride(currency);
        return new ChartPanel(chart);
    }
}
