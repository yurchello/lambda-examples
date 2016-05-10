package internal_functional_java_interfaces.functional_int_extends;

/**
 * Created by Mezentsev.Y on 5/4/2016.
 */
public class Run {
    public static void main(String[] args) {
        Parent parent = new ParentImpl();
        parent.welcome();

        Child child = new ChildImpl();
        child.welcome();

        Parent parent1 = new ChildImpl();
        parent1.welcome();

        Parent parent2 = new OverridingParent();
        parent2.welcome();

        Child child1 = new OverridingChild();
        child1.welcome();



    }
}
