import java.awt.*;
import java.awt.event.ActionEvent;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
import Components.Menu.CustomMenuPanel;

public class NotepadGUI extends JFrame {
    private static Dimension screensizeDimension = Toolkit.getDefaultToolkit().getScreenSize();
    private static JTextArea textArea = new CustomTextArea().getTextArea();
    private static JPanel menuPanel = new CustomMenuPanel(textArea).getMenuPanel();
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
        new_ui.add(menuPanel, BorderLayout.NORTH);
        JScrollPane textAreaScrollPane = new JScrollPane(textArea);
        textAreaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        textAreaScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        textAreaScrollPane.setBounds(0, 30, screensizeDimension.width,
                screensizeDimension.height);
        new_ui.add(textAreaScrollPane, BorderLayout.CENTER);
        new_ui.setVisible(true);

    }

}