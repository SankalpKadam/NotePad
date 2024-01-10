package Components.Menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class ViewMenu {
    public JMenuBar MenuBar;
    public JTextArea textArea;
    private int fontsize = 16;
    private boolean wrapText = false;

    // Constructor creates the Menu
    public ViewMenu(JTextArea textArea) {
        this.textArea = textArea;
        this.MenuBar = new JMenuBar();
        MenuBar.add(getOptionsMenu());
        MenuBar.setBackground(Color.WHITE);
        MenuBar.setBorder(null);
    }

    public JMenuBar getViewMenuBar() {
        return this.MenuBar;
    }

    private JMenu getOptionsMenu() {
        // Creating the view Menu
        JMenu Menu = new JMenu("View");

        // Creating menu items
        JMenuItem zoomIn = new JMenuItem("Zoom In");
        // Creatin menu item action
        Action ziAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zoomPlus();
            }
        };
        // setting keyboard shortcut to perform necessary action
        ziAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, KeyEvent.CTRL_DOWN_MASK));
        zoomIn.setAction(ziAction);
        zoomIn.setText("Zoom In");

        JMenuItem zoomOut = new JMenuItem("Zoom Out");
        Action zoAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zoomMinus();
            }
        };
        zoAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, KeyEvent.CTRL_DOWN_MASK));
        zoomOut.setAction(zoAction);
        zoomOut.setText("Zoom Out");
        JMenuItem wordWrap = new JMenuItem("Word Wrap");
        Action wrapAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wrapText();
            }

        };
        wrapAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK));
        wordWrap.setAction(wrapAction);
        wordWrap.setText("Word Wrap");
        JMenuItem resetZoom = new JMenuItem("Restore Default Zoom");
        Action restoreAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restoreZoom();
            }

        };
        restoreAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK));
        resetZoom.setAction(restoreAction);
        resetZoom.setText("Restore Default Zoom");
        Menu.add(zoomIn);
        Menu.add(zoomOut);
        Menu.add(wordWrap);
        Menu.add(resetZoom);

        return Menu;

    }

    protected void zoomPlus() {
        System.out.println("zp");
        if (this.fontsize < 40) {
            this.fontsize += 2;
            this.textArea.setFont(new Font("sans-serif", Font.PLAIN, this.fontsize));
        }
    }

    protected void zoomMinus() {
                System.out.println("zm");

        if (!(this.fontsize > 15)) {
            this.fontsize -= 2;
            this.textArea.setFont(new Font("sans-serif", Font.PLAIN, this.fontsize));
        }
    }

    protected void wrapText() {
                System.out.println("wt");

        if (!wrapText) {
            this.wrapText = true;
        } else {
            this.wrapText = false;
        }
        this.textArea.setLineWrap(wrapText);
    }

    protected void restoreZoom() {
                System.out.println("rz");

        this.fontsize = 16;
        this.textArea.setFont(new Font("sans-serif", Font.PLAIN, this.fontsize));

    }
}
