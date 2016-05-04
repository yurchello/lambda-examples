package internal_functional_java_interfaces;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by Mezentsev.Y on 4/8/2016.
 */
public class PredicateApp {
    public static void main(String[] args) {
        /*1*/
        Predicate<Integer> rez = x -> x > 5;
        System.out.println(rez.test(3));
        /*2*/
        BinaryOperator<Long> addLongs = (x, y) -> x + y;
        System.out.println(addLongs.apply(2l,3l));
        /*3 Functional interface Function <T, R> is the transition function of an object of type T to an object of type R*/
        Function<Integer, String> function = integer -> String.valueOf(integer);
        System.out.println(function.apply(3));
        /*4 Supplier <T> takes no arguments, but must return an object of type T*/
        Supplier<User> factory = () -> {
            return new User();
        };
        /*5*/


    }
    static class User{
        public void setName(String name) {
            this.name = name;
        }

        String name;
    }



}
