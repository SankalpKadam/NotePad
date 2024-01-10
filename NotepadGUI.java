import java.awt.*;
import java.awt.event.ActionEvent;

import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import javax.swing.KeyStroke;

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
        filMenuBar.setBorder(null);

        JMenuBar editMenuBar = new JMenuBar();
        editMenuBar.add(getEditOptionsMenu());
        editMenuBar.setBackground(Color.WHITE);
        editMenuBar.setBorder(null);

        JMenuBar helpMenuBar = new JMenuBar();
        helpMenuBar.add(getHelpOptionsMenu());
        helpMenuBar.setBackground(Color.WHITE);
        helpMenuBar.setBorder(null);

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

        // Creating menu items
        JMenuItem createFile = new JMenuItem("New");
        // Creatin menu item action
        Action createAction = new AbstractAction("New") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("New");
            }
        };
        // setting keyboard shortcut to perform necessary action
        createAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        createFile.setAction(createAction);

        JMenuItem openFile = new JMenuItem("Open");
        Action openAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Open");
            }
        };
        openAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
        openFile.setAction(openAction);
        openFile.setText("Open");
        JMenuItem saveFile = new JMenuItem("Save");
        Action saveAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Save");
            }
        };
        saveAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        saveFile.setAction(saveAction);
        saveFile.setText("Save");
        fileMenu.add(createFile);
        fileMenu.add(openFile);
        fileMenu.add(saveFile);

        return fileMenu;

    }

    private static JMenu getEditOptionsMenu() {
        // Creating the edit Menu
        JMenu editMenu = new JMenu("Edit");
        editMenu.setBackground(Color.WHITE);

        // Creating menu items
        JMenuItem copyItem = new JMenuItem();
        // Creating action for the menu item
        Action copyAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("copy");
            }
        };
        // Setting keyboard shortcut for the menu item
        copyAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
        copyItem.setAction(copyAction);
        copyItem.setText("Copy");

        JMenuItem pasteItem = new JMenuItem();
        Action pasteAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("paste");
            }
        };
        pasteAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK));
        pasteItem.setAction(pasteAction);
        pasteItem.setText("Paste");

        JMenuItem cutItem = new JMenuItem();
        Action cutAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("cut");
            }
        };
        cutAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));
        cutItem.setAction(cutAction);
        cutItem.setText("Cut");

        editMenu.add(copyItem);
        editMenu.add(pasteItem);
        editMenu.add(cutItem);

        return editMenu;

    }

    private static JMenu getHelpOptionsMenu() {
        // Creating the edit Menu
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setBackground(Color.WHITE);
        JMenuItem helpItem = new JMenuItem();
        Action helpaction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("about");
            }
        };
        helpaction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_DOWN_MASK));
        helpItem.setAction(helpaction);
        helpItem.setText("About");

        helpMenu.add(helpItem);
        return helpMenu;

    }

}