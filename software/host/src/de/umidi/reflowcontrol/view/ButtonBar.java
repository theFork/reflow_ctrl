package de.umidi.reflowcontrol.view;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ButtonBar extends JPanel {

    JButton runButton = new JButton("Run");
    JButton stopButton = new JButton("Stop");
    JButton quitButton = new JButton("Quit");

    public ButtonBar() {
        this.add(runButton);
        this.add(stopButton);
        this.add(quitButton);
    }
}
