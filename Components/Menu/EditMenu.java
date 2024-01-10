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

public class EditMenu {
    public JMenuBar editMenuBar;
    public JTextArea textArea;
    public String clipboard;

    // Constructor creates the editMenu
    public EditMenu(JTextArea textArea) {
        this.textArea = textArea;
        this.editMenuBar = new JMenuBar();
        editMenuBar.add(getEditOptionsMenu());
        editMenuBar.setBackground(Color.WHITE);
        editMenuBar.setBorder(null);
    }

    public JMenuBar getEditMenuBar() {
        return this.editMenuBar;
    }

    public JMenu getEditOptionsMenu() {
        // Creating the edit Menu
        JMenu editMenu = new JMenu("Edit");
        editMenu.setBackground(Color.WHITE);

        // Creating menu items
        JMenuItem copyItem = new JMenuItem();
        // Creating action for the menu item
        Action copyAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                copyText();
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
                pasteText();
            }
        };
        pasteAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK));
        pasteItem.setAction(pasteAction);
        pasteItem.setText("Paste");

        JMenuItem cutItem = new JMenuItem();
        Action cutAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cutText();
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

    // Function to copy the selected text to clipboard
    private void copyText() {
        this.clipboard = this.textArea.getSelectedText();
    }

    // Function to paste the clipboard contents
    private void pasteText() {
        this.textArea.insert(this.clipboard, this.textArea.getCaretPosition());
    }

    // Function to cut the selected text
    private void cutText() {
        this.clipboard = this.textArea.getSelectedText();
        this.textArea.replaceSelection(null);
    }
}
