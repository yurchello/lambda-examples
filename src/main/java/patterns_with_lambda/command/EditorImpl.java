package patterns_with_lambda.command;

/**
 * Created by Mezentsev.Y on 5/11/2016.
 */
public class EditorImpl implements Editor {
    @Override
    public void save() {
        System.out.println("save");
    }

    @Override
    public void open() {
        System.out.println("open");
    }

    @Override
    public void close() {
        System.out.println("close");
    }
}
