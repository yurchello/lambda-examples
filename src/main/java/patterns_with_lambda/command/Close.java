package patterns_with_lambda.command;

/**
 * Created by Mezentsev.Y on 5/11/2016.
 */
public class Close implements  Action{

    private Editor editor;

    public Close(Editor editor) {
        this.editor = editor;
    }


    @Override
    public void perform() {
        editor.close();
    }
}
