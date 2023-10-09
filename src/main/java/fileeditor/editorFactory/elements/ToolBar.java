package fileeditor.editorFactory.elements;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class ToolBar {
    public static JToolBar createToolbar(ActionListener listener) {
        JToolBar toolBar = new JToolBar();
        String[] buttons = new String[] {
                "New", "Open", "Save", "Copy", "Cut", "Paste"
        };

        for (int i = 0; i < buttons.length; i++) {
            JButton button = new JButton(buttons[i], new ImageIcon(buttons[i] + ".jpg"));
            button.setPreferredSize(new Dimension(500, 50));
            toolBar.add(button);
            button.addActionListener(listener);
            if (i == 2)
                toolBar.addSeparator(new Dimension(10, toolBar.getHeight()));
        }

        return toolBar;
    }

}
