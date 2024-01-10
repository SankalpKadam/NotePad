package Components.Menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class HelpMenu {
    public JMenuBar helpMenuBar;
    public JTextArea textArea;
    //Constructor creates the helpmenu
    public HelpMenu(JTextArea textArea){
        this.textArea = textArea;
        this.helpMenuBar = new JMenuBar();
        helpMenuBar.add(getHelpOptionsMenu());
        helpMenuBar.setBackground(Color.WHITE);
        helpMenuBar.setBorder(null);
    }
    public JMenuBar getHelpMenuBar(){
        return this.helpMenuBar;
    }
    private JMenu getHelpOptionsMenu() {
        // Creating the help Menu
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setBackground(Color.WHITE);
        JMenuItem helpItem = new JMenuItem();
        Action helpaction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                popUpBox();
            }
        };
        helpaction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_DOWN_MASK));
        helpItem.setAction(helpaction);
        helpItem.setText("About");

        helpMenu.add(helpItem);
        return helpMenu;

    }
    protected void popUpBox() {
        JFrame popUpFrame = new JFrame();
        popUpFrame.getContentPane().setBackground(Color.WHITE);
        popUpFrame.setSize(300, 250);
        popUpFrame.setResizable(true);

        JTextArea np = new JTextArea();
        np.setFont(new Font("sans-serif", Font.PLAIN, 16));
        np.setBounds(0, 0, 300,250);
        np.setEditable(false);
        np.setText("Hi, my name is Sankalp Kadam and you are using the simple notepad that I have created."+"\n"+" I am currently pursuing Master's in Computer Science at The University of Texas at Arlington."+"\n"+" You can reach out to me on https://www.linkedin.com/in/sankalp-kadam."+"\n\n"+"@SankalpKadam");
        np.setLineWrap(true);
        np.setAlignmentY(250);

        popUpFrame.setLayout(new BorderLayout());
        popUpFrame.add(np, BorderLayout.CENTER);
        popUpFrame.setAlwaysOnTop(true);
        popUpFrame.setVisible(true);
    }
}
