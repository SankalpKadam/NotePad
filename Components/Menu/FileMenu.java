package Components.Menu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileMenu {
    public JMenuBar fileMenuBar;
    public JTextArea textArea;

    // Constructor creates the filemenu
    public FileMenu(JTextArea textArea) {
        this.textArea = textArea;
        this.fileMenuBar = new JMenuBar();
        fileMenuBar.add(getFileOptionsMenu());
        fileMenuBar.setBackground(Color.WHITE);
        fileMenuBar.setBorder(null);
    }

    public JMenuBar getFileMenuBar() {
        return this.fileMenuBar;
    }

    public JMenu getFileOptionsMenu() {
        // Creating the file Menu
        JMenu fileMenu = new JMenu("File");

        // Creating menu items
        JMenuItem createFile = new JMenuItem("New");
        // Creatin menu item action
        Action createAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewFile();
            }
        };
        // setting keyboard shortcut to perform necessary action
        createAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        createFile.setAction(createAction);
        createFile.setText("New");

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
        JMenuItem printFile = new JMenuItem("Print");
        Action printAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printTheFile();
            }

        };
        printAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK));
        printFile.setAction(printAction);
        printFile.setText("Print");
        fileMenu.add(createFile);
        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        fileMenu.add(printFile);

        return fileMenu;

    }

    // Private method to save the file
    private void saveTheFile() {
        JFileChooser chooser = new JFileChooser();
        // stores result of the opening the file dialog
        int result = chooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {// if success then does this
            File file = chooser.getSelectedFile();// gets the selected file
            try {
                // Creates a filewriter and writes all the text in the textArea to the file
                FileWriter fileWriter = new FileWriter(file);
                String writeData = this.textArea.getText();
                System.out.println(writeData);
                fileWriter.write(writeData);
                fileWriter.close();
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Error" + e);
            }
        }
    }

    // private method to create new file by setting textArea to null
    private void createNewFile() {
        this.textArea.setText("");
    }

    // Private method to open and read the file and set the contents to the textArea
    private void openFile(String string) {
        JFileChooser chooser = new JFileChooser();
        // sets the type of file user can select
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files only", "txt");
        chooser.setFileFilter(filter);
        // stores result of the opening the file dialog
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {// if success then does this
            // gets the selected file
            File file = chooser.getSelectedFile();
            String fileData = "";
            try {
                // Reads each line and sets it to the textArea
                Scanner fileReader = new Scanner(file);
                while (fileReader.hasNextLine()) {
                    fileData = fileReader.nextLine() + "\n";
                    this.textArea.append(fileData);
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

    //Private method to print the file
    private void printTheFile(){
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        if (printerJob.printDialog()) {
            try {
                printerJob.print();
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Error in printing");
            }
        }
    }
}
