import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * So far, just a proof of concept...
 * @author simon
 */
@SuppressWarnings("serial")
public final class MainWindow extends ApplicationFrame {

	public MainWindow(String title) {
		super(title);

		final XYDataset dataset = createDataset();
		final JFreeChart chart = createChart(dataset);
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		setContentPane(chartPanel);
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
	
	/**
     * Creates a chart
     * 
     * @param dataset  the data for the chart.
     * 
     * @return a chart.
     */
    private JFreeChart createChart(final XYDataset dataset) {
        
        // create the chart...
        final JFreeChart chart = ChartFactory.createXYLineChart(
            "Chart Title",      	  // chart title
            "Time",                   // x axis label
            "Temperature",            // y axis label
            dataset,                  // data
            PlotOrientation.VERTICAL,
            true,                     // include legend
            true,                     // tooltips
            false                     // urls
        );

        // chart format
        chart.setBackgroundPaint(Color.white);

        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        
        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, true);
        plot.setRenderer(renderer);

        // change the auto tick unit selection to integer units only
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
                
        return chart;
    }
}
