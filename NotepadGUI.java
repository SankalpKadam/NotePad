import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
    private static void removeButton(Container optionsBox){
        Component[] c = optionsBox.getComponents();
        for (Component component : c) {
            if (component instanceof AbstractButton) {
                optionsBox.remove(component);
            }
        }
    }
    private static JPanel getMenuPanel(){
        //Creating the menu panel
        JPanel menuJPanel = new JPanel();
        LayoutManager layoutManager = new GridLayout(1, 3);
        //Setting the panel properties
        menuJPanel.setBounds(0, 0, Toolkit.getDefaultToolkit().getScreenSize().width, 20);
        menuJPanel.setLayout(layoutManager);
        menuJPanel.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.GRAY));
        
        //creating menu buttons
        JButton fileButton = new JButton();
        fileButton.setText("File");
        fileButton.setBackground(Color.WHITE);
        fileButton.setBorder(null);
        
        JButton editButton = new JButton();
        editButton.setText("Edit");
        editButton.setBackground(Color.WHITE);
        editButton.setBorder(null);

        JButton helpButton = new JButton();
        helpButton.setText("Help");
        helpButton.setBackground(Color.WHITE);
        helpButton.setBorder(null);        
        
        //Creating on click listener for buttons
        fileButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //shows the file options panel on click
               menuJPanel.add(getFileOptionsPanel());
            }
            
        });


        //Adding components to menu panel
        menuJPanel.add(fileButton);        
        menuJPanel.add(editButton);
        menuJPanel.add(helpButton);
        
        return menuJPanel;
    }
    private static JPanel getTextPanel(){
        //Creating text panel
        JPanel textJPanel = new JPanel();
        textJPanel.setBounds(0, 20, Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height-20);
        textJPanel.setBackground(Color.white);
        return textJPanel;
    }

    private static JPanel getFileOptionsPanel(){
        JPanel fileOptionPanel = new JPanel();
        fileOptionPanel.setBounds(0, 20, 40, 40);
        fileOptionPanel.setBackground(Color.BLACK);
        return fileOptionPanel;
    }

    
}