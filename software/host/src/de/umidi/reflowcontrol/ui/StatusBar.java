package de.umidi.reflowcontrol.ui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public final class StatusBar extends JPanel {

    private JLabel connectionStatusLabel;
    private JLabel messageLabel;
    private JLabel setPointLabel;
    private JLabel currentTemperatureLabel;

    private final int LABEL_HEIGHT = 20;
    private final int CONNECTION_STATUS_LABEL_WIDTH = 100;
    private final int TEMPERATURE_LABEL_WIDTH = 75;

    private final Color RED = new Color(255, 0, 0);
    private final Color GREEN = new Color(0, 180, 0);
    private final Color BLUE = new Color(0, 0, 180);

    /**
     * The bar at the bottom of the main window
     */
    public StatusBar() {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setBorder(new BevelBorder(BevelBorder.LOWERED));

        // Prepare labels
        connectionStatusLabel = new JLabel();
        messageLabel = new JLabel();
        setPointLabel = new JLabel();
        currentTemperatureLabel = new JLabel();

        // Set preferred sizes
        connectionStatusLabel.setPreferredSize(new Dimension(CONNECTION_STATUS_LABEL_WIDTH, LABEL_HEIGHT));
        setPointLabel.setPreferredSize(new Dimension(TEMPERATURE_LABEL_WIDTH, LABEL_HEIGHT));
        currentTemperatureLabel.setPreferredSize(new Dimension(TEMPERATURE_LABEL_WIDTH, LABEL_HEIGHT));

        // Set colors
        setPointLabel.setForeground(GREEN);
        currentTemperatureLabel.setForeground(BLUE);

        // Add elements
        this.add(connectionStatusLabel);
        this.add(createSeparator());
        this.add(messageLabel);
        this.add(Box.createHorizontalGlue());
        this.add(createSeparator());
        this.add(setPointLabel);
        this.add(createSeparator());
        this.add(currentTemperatureLabel);
    }

    /**
     * Display connection status of the attached uMIDI board
     * 
     * @param connected
     */
    public void showConnected(Boolean connected) {
        if (connected.booleanValue()) {
            connectionStatusLabel.setText("Connected");
            connectionStatusLabel.setForeground(GREEN);
        } else {
            connectionStatusLabel.setText("Disconnected");
            connectionStatusLabel.setForeground(RED);
        }
    }

    /**
     * Display an informative message
     * 
     * @param message
     */
    public void showMessage(String message) {
        messageLabel.setText(message);
    }

    /**
     * Display temperatures at the bottom right
     * 
     * @param setpoint
     *            Current setpoint temperature
     * @param currentTemperature
     *            Current temperature
     */
    public void showTemperatures(double setpoint, double currentTemperature) {
        setPointLabel.setText(formatTemperature(setpoint));
        currentTemperatureLabel.setText(formatTemperature(currentTemperature));

    }

    private String formatTemperature(double temperature) {
        StringBuilder sb = new StringBuilder();
        sb.append(temperature);
        sb.append(" °C");
        return sb.toString();
    }

    private JSeparator createSeparator() {
        JSeparator sep = new JSeparator(JSeparator.VERTICAL);
        sep.setMaximumSize(new Dimension(1, Integer.MAX_VALUE));
        return sep;
    }
}
