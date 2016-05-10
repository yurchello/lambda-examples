package collectors;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import java.util.stream.Collector;

/**
 * Created by Mezentsev.Y on 5/5/2016.
 */
public class CollectorsExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("11", "3333", "555555", "23234eeeeeeeeeeeeeeeeeee34", "44", "0000000000");

        /*maxBy*/
        Stream<String> stream = list.stream();
        Optional<String> optional = stream.collect(Collectors.maxBy(Comparator.comparing(s -> s.length())));
        System.out.println(optional.get());
        /*minBy*/
        Stream<String> stream2 = list.stream();
        Optional<String> optional2 = stream2.collect(Collectors.minBy(Comparator.comparing(s -> s.length())));
        System.out.println(optional2.get());
         /*averagingInt*/
        Stream<String> stream3 = list.stream();
        Double d = stream3.collect(Collectors.averagingInt(s -> s.length()));
        System.out.println(d);
        /*partitioningBy*/
        partitioningByDemo();
        /*groupingBy*/
        groupingByDemo();
        /*joining*/
        joiningDemo();
        /*counting*/
        countingDemo();
        /*computeifAbsent*/
        computeifAbsentExample();

    }

    public static void partitioningByDemo(){
        List<String> list = Arrays.asList("11", "g", "555555", "aaaa", "bbb", "0000000000");
        Map<Boolean, List<String>> map = list.stream().collect(Collectors.partitioningBy(s -> Character.isDigit(s.charAt(0))));
        Map<Boolean, List<String>> map2 = list.stream().collect(Collectors.partitioningBy(s -> Character.isDigit(s.charAt(0))));
    }

    public static void groupingByDemo(){
        List<String> list = Arrays.asList("a11", "b44", "a555555", "aaaa", "bbb", "b0000000000", "c44", "c555555", "aaaa", "bbb", "d0000000000");
        Map<Character, List<String>> map = list.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));
    }

    public static void joiningDemo(){
        List<String> list = Arrays.asList("a0", "b", "c0", "d", "e0", "f", "b1", "c1", "d9", "e9", "f9");
        String str = list.stream().collect(Collectors.joining(", ", "[", "]"));
    }

    public static void countingDemo() {

        Person pa = new Person("pa");
        Person pb = new Person("pb");
        Person pc = new Person("pc");
        Person pd = new Person("pd");
        Person pg = new Person("pg");
        Person pr = new Person("pr");
        Person pf = new Person("pf");

        List<Album> albums = Arrays.asList(
            new Album(Arrays.asList(pa,pb,pc,pd),"1aaa"),
            new Album(Arrays.asList(pf,pb,pc,pr),"2aaa"),
            new Album(Arrays.asList(pf,pb,pg,pr),"3aaa"),
            new Album(Arrays.asList(pf,pb,pg,pd),"4aaa")
        );
        Map<Person,Long> map2 =
                albums.stream().collect(Collectors.groupingBy(album -> album.getPersons().get(0), Collectors.counting()));
    }

    public  static void computeifAbsentExample(){
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "weqweq");
        map.put(2,"ddfgdweqweq");
        map.put(3,"weqhvbweq");
        map.put(4,"weqwerezxcq");
        map.put(5,"weqweqdghhg");
        map.computeIfAbsent(10, s -> "some new val");
    }

}

class Album{
    List<Person> persons;
    String title;

    public Album(List<Person> persons, String title) {
        this.persons = persons;
        this.title = title;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public String getTitle() {
        return title;
    }
}

class Person{
    String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}