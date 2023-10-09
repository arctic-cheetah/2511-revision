package fileeditor.editorFactory;

import javax.swing.JDesktopPane;

import fileeditor.ButtonListener;
import fileeditor.WindowCloser;
import fileeditor.editorFactory.elements.EditMenu;
import fileeditor.editorFactory.elements.Frame;
import fileeditor.editorFactory.elements.MenuBar;
import fileeditor.editorFactory.elements.ToolBar;

public class HTMLEditorFactory extends EditorFactory {
    public HTMLEditorFactory() {
        createFrame();
        createDeskTopPane();
        createActionListener();
        createMenuBar();
        createEditMenu();
        createToolBar();
        createWindowAdapter();
        addComponentsToFrame();
    }

    public void createFrame() {
        setFrame(Frame.createFrame());
    }

    public void createDeskTopPane() {
        setPane(new JDesktopPane());
    }

    public void createActionListener() {
        setListener(new ButtonListener(getPane()));
    }

    public void createMenuBar() {
        setMenuBar(MenuBar.createMenuBar(getListener()));
    }

    public void createEditMenu() {
        EditMenu.createHTMLEditMenu(getListener(), getMenuBar());
    }

    public void createToolBar() {
        setToolBar(ToolBar.createToolbar(getListener()));
    }

    public void createWindowAdapter() {
        setWindowAdapter(new WindowCloser(getPane()));
    }

}
