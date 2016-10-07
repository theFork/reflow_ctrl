package de.umidi.reflowcontrol.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
/**
 * Central view class. Represents the one and only window
 */
public class ReflowView extends JFrame {

    // TODO:
    // - status bar
    // - plot pane
    // - start and stop buttons

    public ReflowView() {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(0, 5));
    }

    public void displayStatusConnected(boolean connected) {

    }

    public void displayStatusMessage(String status) {

    }

}
