package fileeditor.editorFactory.elements;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import fileeditor.ButtonListener;

public class EditMenu {
    public static void createHTMLEditMenu(ActionListener listener, JMenuBar menuBar) {
        JMenu editMenu = new JMenu("Edit");
        String[] editMenuItems = new String[] {
                "Copy", "Cut", "Paste", "Select All"
        };

        for (int i = 0; i < editMenuItems.length; i++) {
            JMenuItem menuItem = new JMenuItem(editMenuItems[i]);
            editMenu.add(menuItem);
            menuItem.addActionListener(listener); // Listens to button press
        }
        menuBar.add(editMenu);

        JTextField urlField = new JTextField();
        JButton goUrl = new JButton("Go");
        ButtonListener blistener = (ButtonListener) listener;
        blistener.setTextField(urlField);

        goUrl.addActionListener(listener);
        menuBar.add(urlField);
        menuBar.add(goUrl);
    }

    public static void createTextEditMenu(ActionListener listener, JMenuBar menuBar) {
        JMenu editMenu = new JMenu("Edit");
        String[] editMenuItems = new String[] {
                "Copy", "Cut", "Paste", "Select All"
        };

        for (int i = 0; i < editMenuItems.length; i++) {
            JMenuItem menuItem = new JMenuItem(editMenuItems[i]);
            editMenu.add(menuItem);
            menuItem.addActionListener(listener); // Listens to button press
        }
        menuBar.add(editMenu);

    }
}
