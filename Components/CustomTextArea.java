package Components;

import javax.swing.JTextArea;
import java.awt.*;

public class CustomTextArea {
    public JTextArea textArea;
    public CustomTextArea(){
        // Creating text area
        this.textArea = new JTextArea();
        // setting properties for textArea
        textArea.setFont(new Font("serif", Font.BOLD, 16));
        textArea.setBounds(0, 30, Toolkit.getDefaultToolkit().getScreenSize().width,
                Toolkit.getDefaultToolkit().getScreenSize().height - 30);

    }
    public JTextArea getTextArea(){
        return this.textArea;
    }
    
}
