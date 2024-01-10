import java.awt.*;
import java.awt.event.ActionEvent;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

import Components.CustomTextArea;

public class NotepadGUI extends JFrame {
    static Dimension screensizeDimension = Toolkit.getDefaultToolkit().getScreenSize();
    static CustomTextArea textArea = new CustomTextArea();
    static String clipBoard;
    public NotepadGUI() {
        initialize();
    }

    private void initialize() {

        setTitle("NotePad");
        getContentPane().setBackground(Color.GRAY);
        setSize(screensizeDimension.width, screensizeDimension.height);
        setResizable(true);
        setLayout(new BorderLayout());
    }

    public static void main(String[] args) {
        NotepadGUI new_ui = new NotepadGUI();
        new_ui.add(getMenuPanel(), BorderLayout.NORTH);
        JScrollPane textAreaScrollPane = new JScrollPane(textArea.getTextArea());
        textAreaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        textAreaScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        textAreaScrollPane.setBounds(0, 30, screensizeDimension.width,
                screensizeDimension.height);
        new_ui.add(textAreaScrollPane, BorderLayout.CENTER);
        new_ui.setVisible(true);

    }

    private static JPanel getMenuPanel() {
        // Creating the menu panel
        JPanel menuJPanel = new JPanel();
        LayoutManager layoutManager = new FlowLayout(FlowLayout.LEFT);
        // Setting the panel properties
        menuJPanel.setBounds(0, 0, screensizeDimension.width, 30);
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

    // private static JTextArea getTextPanel() {

    //     // Creating text area
    //     JTextArea textArea = new JTextArea();
    //     // setting properties for textArea
    //     textArea.setFont(new Font("serif", Font.BOLD, 16));
    //     textArea.setBounds(0, 30, screensizeDimension.width,
    //             screensizeDimension.height - 30);
    //     textArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

    //     return textArea;
    // }

    private static void saveTheFile() {
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                FileWriter fileWriter = new FileWriter(file);
                String writeData = textArea.getTextArea().getText();
                System.out.println(writeData);
                fileWriter.write(writeData);
                fileWriter.close();
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Error"+e);
            }
        }
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
                textArea.getTextArea().setText("");
            }
        };
        // setting keyboard shortcut to perform necessary action
        createAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        createFile.setAction(createAction);

        JMenuItem openFile = new JMenuItem("Open");
        Action openAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile("Open");
            }
        };
        openAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
        openFile.setAction(openAction);
        openFile.setText("Open");
        JMenuItem saveFile = new JMenuItem("Save");
        Action saveAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveTheFile();
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

    private static void openFile(String string) {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files only", "txt");
        chooser.setFileFilter(filter);
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            System.out.println("file choosen correctly");
            File file = chooser.getSelectedFile();
            String fileData = "";
            try {
                Scanner fileReader = new Scanner(file);
                while (fileReader.hasNextLine()) {
                    fileData = fileReader.nextLine() + "\n";
                    textArea.getTextArea().append(fileData);
                }
                fileReader.close();
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(e);
            }
        } else {
            System.out.println("error");
        }
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
                clipBoard = textArea.getTextArea().getSelectedText();
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
                textArea.getTextArea().insert(clipBoard, textArea.getTextArea().getCaretPosition());
            }
        };
        pasteAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK));
        pasteItem.setAction(pasteAction);
        pasteItem.setText("Paste");

        JMenuItem cutItem = new JMenuItem();
        Action cutAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clipBoard = textArea.getTextArea().getSelectedText();
                textArea.getTextArea().replaceSelection(null);
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
            public void actionPerformed(ActionEvent e) {
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