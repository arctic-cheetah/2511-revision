package fileeditor.editorFactory;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;

public abstract class EditorFactory {
    private JFrame frame;
    private JMenuBar menuBar;
    private JToolBar toolBar;
    private WindowAdapter windowAdapter;
    private JDesktopPane pane;
    private ActionListener listener;

    public abstract void createFrame();

    public abstract void createDeskTopPane();

    public abstract void createActionListener();

    public abstract void createMenuBar();

    public abstract void createEditMenu();

    public abstract void createToolBar();

    public abstract void createWindowAdapter();

    public void addComponentsToFrame() {
        getFrame().setJMenuBar(menuBar);
        getFrame().addWindowListener(windowAdapter);
        getFrame().getContentPane().add(toolBar, "North");
        getFrame().getContentPane().add(pane);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public void setMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public JToolBar getToolBar() {
        return toolBar;
    }

    public void setToolBar(JToolBar toolBar) {
        this.toolBar = toolBar;
    }

    public WindowAdapter getWindowAdapter() {
        return windowAdapter;
    }

    public void setWindowAdapter(WindowAdapter windowAdapter) {
        this.windowAdapter = windowAdapter;
    }

    public JDesktopPane getPane() {
        return pane;
    }

    public void setPane(JDesktopPane pane) {
        this.pane = pane;
    }

    public ActionListener getListener() {
        return listener;
    }

    public void setListener(ActionListener listener) {
        this.listener = listener;
    }

}
