package fileeditor;

import fileeditor.editorFactory.EditorFactory;
import fileeditor.editorFactory.HTMLEditorFactory;
import fileeditor.editorFactory.TextEditorFactory;

public class EditorApplication {
    private EditorFactory editorType;

    public EditorApplication(String type) {

        if (type.equals("HTML Editor")) {
            editorType = new HTMLEditorFactory();

        } else if (type.equals("Text Editor")) {
            editorType = new TextEditorFactory();
        }
    }

    public void setFrameVisible(boolean value) {
        editorType.getFrame().setVisible(value);
    }

    public static void main(String[] args) {
        String editorType = "HTML Editor";
        EditorApplication editor = new EditorApplication(editorType);
        editor.setFrameVisible(true);
    }

}
