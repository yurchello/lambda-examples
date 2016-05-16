package patterns_with_lambda.command;

/**
 * Created by Mezentsev.Y on 5/11/2016.
 */
public class Simple {

    public static void main(String[] args) {
        Editor editor = new EditorImpl();
        Macro macro = new Macro();
        macro.record(new Open(editor));
        macro.record(new Save(editor));
        macro.record(new Close(editor));
        macro.run();
    }
}
