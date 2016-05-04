package internal_functional_java_interfaces.functional_int_extends;

/**
 * Created by Mezentsev.Y on 5/4/2016.
 */
public class MusicalCarriage implements Carriage, Jukebox {
    @Override
    public String rock() {
        return Carriage.super.rock();
    }
}
