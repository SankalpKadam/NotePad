package Components.Menu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
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
