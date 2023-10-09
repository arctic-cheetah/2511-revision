package fileeditor.editorFactory.elements;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Frame {
    public static JFrame createFrame() {
        JFrame frame = new JFrame("Basic Editor");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenSize.height = screenSize.height - (25 * screenSize.height / 768);
        frame.setSize(screenSize);
        return frame;
    }

}
