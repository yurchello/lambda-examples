package patterns_with_lambda.command;

/**
 * Created by Mezentsev.Y on 5/11/2016.
 */
public class Save implements Action {

    private Editor editor;

    public Save(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void perform() {
        editor.save();
    }
}
