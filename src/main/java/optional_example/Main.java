package optional_example;

import java.util.Optional;

/**
 * Created by Mezentsev.Y on 5/4/2016.
 */
public class Main {
    public static void main(String[] args) {
        Optional<String> a = Optional.of("a");
        System.out.println(a.get());
        System.out.println(a.orElse("aaa"));

        Optional<String> b = Optional.empty();
        System.out.println(b.isPresent());
        b.orElse("bbb");
        System.out.println(b.orElse("bbb"));
    }

}
