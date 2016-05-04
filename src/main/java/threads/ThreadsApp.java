package threads;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Mezentsev.Y on 4/8/2016.
 */
public class ThreadsApp {
    public static void main(String[] args) {
        /*1*/
        List<Artist> allArtist = new ArrayList<>();
        allArtist.add(new Artist("www"));
        allArtist.add(new Artist("London"));
        allArtist.add(new Artist("London"));
        allArtist.add(new Artist("ttt"));
        int count = 0;
        for (Artist artist: allArtist){
            if (artist.isFrom("London")){
                count++;
            }
        }
        /*filter*/
        long counter = allArtist.stream()
                .filter(artist ->{
                    System.out.println("sfdv");
                    return artist.isFrom("London");
                }).count();
        System.out.println(count);
        /*collect*/
        List<String> collected = Stream.of("a", "b", "?")
                .collect(Collectors.toList());
        /*map*/
        List<String> coll = new ArrayList<>();
        for (String string : Arrays.asList("a", "b", "hello")) {
            String uppercaseString = string.toUpperCase();
            coll.add(uppercaseString);
        }

        List<String> coll2 = Stream.of("a", "b", "hello")
                .map(string -> string.toUpperCase())
                        .collect(Collectors.toList());
        /*flat map*/
        List<Integer> together = Stream.of(Arrays.asList (1, 2), Arrays.asList(3, 4))
                .flatMap(numbers -> numbers.stream())
                        .collect(Collectors.toList());
        printList(together);
        /*max min*/
        class Track{
            private int len;
            private String name;
            Track(String name, int len){
                this.len = len;
                this.name = name;
            }
            int getLength(){
                return this.len;
            }
        }
        List<Track> tracks = Arrays.asList(
                new Track("Bakai", 524),
                new Track("Violets for Your Furs", 378),
        new Track("Time Was", 451));
        Track shortestTrack = tracks.stream()
                .min(Comparator.comparing(track -> track.getLength()))
                .get();
        /*reduce*/
        int sum = Stream.of(1, 2, 3).reduce(0, (acc, element) -> acc + element);

        BinaryOperator<Integer> accumulator = (acc, element) -> acc + element;
        int sum2 = accumulator.apply(
                accumulator.apply(
                        accumulator.apply(0, 1),
                    2),
                3);

        System.out.println();

        int acc = 0;
        for (Integer element : Arrays.asList(1, 2, 3)) {
            acc = acc + element;
        }
        /*for each*/
        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
        }

        items.forEach((key,val)->{
            System.out.println(key + " " +val);
        });

    }

    static <T> void printList(List<T> list){
        for (T t: list){
            System.out.println(t.toString());
        }
    }

    static class Artist{
        Artist(){}
        Artist(String city){this.city = city;}
        private String city;
        public boolean isFrom(String city){
            return this.city.equals(city);
        }
        public void setCity(String city){
            this.city = city;
        }
    }
}
