package internal_functional_java_interfaces.functional_int_extends;

/**
 * Created by Mezentsev.Y on 5/4/2016.
 */
public interface Carriage {
    default String rock() {
        return"  ... from side to side";
    }
}
