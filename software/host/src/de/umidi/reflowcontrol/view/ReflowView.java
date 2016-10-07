package de.umidi.reflowcontrol.view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
/**
 * Central view class. Represents the one and only window
 */
public class ReflowView extends JFrame {

    // TODO:
    // - status bar
    // - plot pane
    // - run and stop buttons

    private ButtonBar buttonBar = new ButtonBar();

    public ReflowView() {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(0, 5));

        this.add(buttonBar, BorderLayout.NORTH);
    }

    /* STATUS BAR SETTERS */

    public void displayStatusConnected(boolean connected) {

    }

    public void displayStatusMessage(String status) {

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
