import java.awt.*;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


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