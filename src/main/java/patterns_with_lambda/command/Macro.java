package patterns_with_lambda.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mezentsev.Y on 5/11/2016.
 */
public class Macro {
    private final List<Action> actions;

    public Macro() {
        actions = new ArrayList<>();
    }

    public void record(Action action){
        actions.add(action);
    }

    public void run(){
        actions.forEach(Action::perform);
        //actions.forEach(a->a.perform());
    }
}
