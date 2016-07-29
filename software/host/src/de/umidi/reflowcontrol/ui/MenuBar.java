/**
 * 
 */
package de.umidi.reflowcontrol.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import de.umidi.reflowcontrol.ReflowControl;

/**
 * The menu bar
 */
@SuppressWarnings("serial")
public final class MenuBar extends JMenuBar {

    public MenuBar() {
        super();

        // File menu
        JMenu FileMenu = new JMenu("File");
        FileMenu.setMnemonic(KeyEvent.VK_F);
        JMenuItem FileQuitMenuItem = new JMenuItem("Quit");
        FileQuitMenuItem.setMnemonic(KeyEvent.VK_Q);
        FileQuitMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Save before exit?
                System.exit(0);
            }
        });
        FileMenu.add(FileQuitMenuItem);

        // Help menu
        JMenu HelpMenu = new JMenu("Help");
        JMenuItem HelpAboutMenuItem = new JMenuItem("About");
        HelpAboutMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                showHelpAbout();
            }
        });
        HelpMenu.add(HelpAboutMenuItem);

        // Assemble menu bar
        this.add(FileMenu);
        this.add(HelpMenu);
    }

    private void showHelpAbout() {
        // TODO
        System.out.println("Reflow Control " + ReflowControl.VERSION);
    }
}
