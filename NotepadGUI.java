import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class NotepadGUI extends JFrame {
    Dimension screensizeDimension = Toolkit.getDefaultToolkit().getScreenSize();

    public NotepadGUI() {
        initialize();
    }

    private void initialize() {
        setAlwaysOnTop(true);
        setTitle("NotePad");
        setBackground(Color.WHITE);
        setSize(screensizeDimension.width, screensizeDimension.height);
        setResizable(true);

    }

    public static void main(String[] args) {
        NotepadGUI new_ui = new NotepadGUI();
        new_ui.add(getMenuPanel());
        new_ui.add(getTextPanel());
        // new_ui.setJMenuBar(getFileOptionsPanel());
        new_ui.setVisible(true);

    }

    private static void removeButton(Container optionsBox) {
        Component[] c = optionsBox.getComponents();
        for (Component component : c) {
            if (component instanceof AbstractButton) {
                optionsBox.remove(component);
            }
        }
    }

    private static JPanel getMenuPanel() {
        // Creating the menu panel
        JPanel menuJPanel = new JPanel();
        LayoutManager layoutManager = new FlowLayout(FlowLayout.LEFT);
        // Setting the panel properties
        menuJPanel.setBounds(0, 0, Toolkit.getDefaultToolkit().getScreenSize().width, 30);
        menuJPanel.setLayout(layoutManager);
        menuJPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        menuJPanel.setBackground(Color.WHITE);

        // creating menu buttons

        JMenuBar filMenuBar = new JMenuBar();
        filMenuBar.add(getFileOptionsMenu());
        filMenuBar.setBackground(Color.WHITE);

        JMenuBar editMenuBar = new JMenuBar();
        editMenuBar.add(getEditOptionsMenu());
        editMenuBar.setBackground(Color.WHITE);
        
        JMenuBar helpMenuBar = new JMenuBar();
        helpMenuBar.add(getHelpOptionsMenu());
        helpMenuBar.setBackground(Color.WHITE);
        // Adding components to menu panel
        menuJPanel.add(filMenuBar);
        menuJPanel.add(editMenuBar);
        menuJPanel.add(helpMenuBar);
        return menuJPanel;
    }

    private static JPanel getTextPanel() {
        // Creating text panel
        JPanel textJPanel = new JPanel();
        textJPanel.setBounds(0, 20, Toolkit.getDefaultToolkit().getScreenSize().width,
                Toolkit.getDefaultToolkit().getScreenSize().height - 20);
        textJPanel.setBackground(Color.white);
        return textJPanel;
    }

    private static JMenu getFileOptionsMenu() {
        // Creating the file Menu
        JMenu fileMenu = new JMenu("File");
        //Creating menu items
        JMenuItem createFile = new JMenuItem("New");
        fileMenu.add(createFile);
        JMenuItem createFile1 = new JMenuItem("Open");
        fileMenu.add(createFile1);
        JMenuItem createFile2 = new JMenuItem("Save");
        fileMenu.add(createFile2);

        return fileMenu;

    }

    private static JMenu getEditOptionsMenu() {
        // Creating the edit Menu
        JMenu editMenu = new JMenu("Edit");

        editMenu.add(new JMenuItem("Copy"));
        editMenu.add(new JMenuItem("Paste"));
        editMenu.add(new JMenuItem("Cut"));

        return editMenu;

    }

    private static JMenu getHelpOptionsMenu() {
        // Creating the edit Menu
        JMenu helpMenu = new JMenu("Help");

        helpMenu.add(new JMenuItem("About"));

        return helpMenu;

    }

}