/**
 * 
 */
package de.umidi.reflowcontrol.ui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * @author simon
 *
 */
public final class MenuBar extends JMenuBar {

    private static final long serialVersionUID = 1L;

    public MenuBar() {
        super();

        // File menu
        JMenu FileMenu = new JMenu("File");
        JMenuItem FileQuitMenuItem = new JMenuItem("Quit");
        FileMenu.add(FileQuitMenuItem);

        // Help menu
        JMenu HelpMenu = new JMenu("Help");
        JMenuItem HelpAboutMenuItem = new JMenuItem("About");
        HelpMenu.add(HelpAboutMenuItem);

        // Assemble menu bar
        this.add(FileMenu);
        this.add(HelpMenu);
    }
}