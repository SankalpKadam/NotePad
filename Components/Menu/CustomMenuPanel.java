package Components.Menu;

import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.*;

public class CustomMenuPanel {
    public JPanel menuJPanel;

    public CustomMenuPanel(JTextArea textArea) {
        // Creating the menu panel
        this.menuJPanel = new JPanel();
        LayoutManager layoutManager = new FlowLayout(FlowLayout.LEFT);
        // Setting the panel properties
        this.menuJPanel.setBounds(0, 0, Toolkit.getDefaultToolkit().getScreenSize().width, 30);
        this.menuJPanel.setLayout(layoutManager);
        this.menuJPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        this.menuJPanel.setBackground(Color.WHITE);
        
        // Adding components to menu panel
        this.menuJPanel.add(getFileMenu(textArea));
        this.menuJPanel.add(getEditMenu(textArea));
        this.menuJPanel.add(getHelpMenu(textArea));

    }

    public JPanel getMenuPanel() {
        return this.menuJPanel;
    }

    // Creating the individual menu bars
    private JMenuBar getFileMenu(JTextArea textArea) {
        JMenuBar MenuBar = new FileMenu(textArea).getFileMenuBar();
        return MenuBar;
    }

    private JMenuBar getEditMenu(JTextArea textArea) {
        JMenuBar MenuBar = new EditMenu(textArea).getEditMenuBar();
        return MenuBar;
    }

    private JMenuBar getHelpMenu(JTextArea textArea) {
        JMenuBar MenuBar = new HelpMenu(textArea).getHelpMenuBar();
        return MenuBar;
    }
}
