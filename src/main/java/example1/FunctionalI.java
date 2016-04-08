package example1;

/**
 * Created by Mezentsev.Y on 3/29/2016.
 */
@FunctionalInterface
public interface FunctionalI {
    void doSome();
    default void doS(){};
    static void doF(){};
}
