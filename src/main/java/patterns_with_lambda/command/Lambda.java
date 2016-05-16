package patterns_with_lambda.command;

/**
 * Created by Mezentsev.Y on 5/12/2016.
 */
public class Lambda {
    public static void main(String[] args) {
        Editor editor = new EditorImpl();
        Macro macro = new Macro();

        macro.record(editor::open);
        macro.record(editor::save);
        macro.record(editor::close);

//        macro.record(()->editor.open());
//        macro.record(()->editor.save());
//        macro.record(()->editor.close());
//
        macro.run();
    }
}
