import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;;
public class NotepadGUI extends JFrame{
    Dimension screensizeDimension = Toolkit.getDefaultToolkit().getScreenSize();
    public NotepadGUI(){
        initialize();
    }
    private void initialize(){
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

        new_ui.setVisible(true);

        
    }

    private static JPanel getMenuPanel(){
        JPanel menuJPanel = new JPanel();
        LayoutManager layoutManager = new GridLayout(1, 3);
        menuJPanel.setBounds(0, 0, Toolkit.getDefaultToolkit().getScreenSize().width, 20);
        menuJPanel.setLayout(layoutManager);
        JButton fileButton = new JButton();
        fileButton.setText("File");
        fileButton.setBackground(Color.WHITE);
        fileButton.setBorder(null);
        JButton editButton = new JButton();
        editButton.setText("Edit");
        editButton.setBackground(Color.WHITE);
        JButton helpButton = new JButton();
        helpButton.setText("Help");
        helpButton.setBackground(Color.WHITE);
        menuJPanel.add(fileButton);        
        menuJPanel.add(editButton);
        menuJPanel.add(helpButton);
        
        return menuJPanel;
    }
    private static JPanel getTextPanel(){
        JPanel menuJPanel = new JPanel();
        menuJPanel.setBounds(0, 20, Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height-20);
        menuJPanel.setBackground(Color.white);
        return menuJPanel;
    }

    
}