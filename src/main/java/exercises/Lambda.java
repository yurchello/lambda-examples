package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * Created by Mezentsev.Y on 4/8/2016.
 */
public class Lambda {
    public static void main(String[] args) {
        /*chapter 3*/
        /*1*/
        System.out.println(addUp(Stream.of(1, 2, 3)));
        List<Artist> artists = Arrays.asList(

                new Artist("111", "UK", Arrays.asList(new Artist("q","qq"),new Artist("h","gg"),new Artist("f","ff"))),
                new Artist("111", "UK", Arrays.asList(new Artist("q","qq"),new Artist("h","gg"),new Artist("f","ff"))),
                new Artist("111", "UK", Arrays.asList(new Artist("q","qq"),new Artist("h","gg"),new Artist("f","ff"))),
                new Artist("111", "UK", Arrays.asList(new Artist("q","qq"),new Artist("h","gg"),new Artist("f","ff"))));
        printList(getNamesAndOrigins(artists));
        List<Album> input = asList(
                new Album("Album_1",
                        Arrays.asList(new Track("1", 10), new Track("2", 30)),
                        Arrays.asList(new Artist("jon", "uk"), new Artist("sten", "ua"), new Artist("ann", "usa"))),
                new Album("Album_2",
                        Arrays.asList(new Track("3", 40)),
                        Arrays.asList(new Artist("jon", "uk"), new Artist("sten", "ua"), new Artist("ann", "usa"))),
                new Album("Album_3",
                        Arrays.asList(new Track("1", 10), new Track("2", 30), new Track("3", 40), new Track("4", 50)),
                        Arrays.asList(new Artist("jon", "uk"), new Artist("sten", "ua"), new Artist("ann", "usa")))
        );
        List<Album> albums = getAlbumsWithAtMostThreeTracks(input);
        /*2*/
        System.out.println(countBandMembersInternal(artists));


    }

    static Long countBandMembersInternal(List<Artist> artists) {

        return artists.stream()
                .map(artist -> artist.getMembers().stream().count()).reduce(0L, (acc, b) -> acc + b);
    }

    static int addUp(Stream<Integer> numbers){
        return numbers.reduce(0,(acc, b)-> acc + b);
    }
    static List<String> getNamesAndOrigins(List<Artist> artists){
        return artists.stream().flatMap(artist -> Stream.of(artist.getName(), artist.getLocation())).collect(Collectors.toList());
    }

    static List<Album> getAlbumsWithAtMostThreeTracks(List<Album> albums){
        return albums.stream().filter(album -> album.getTracks().size()<3).collect(Collectors.toList());
    }

    static <T> void printList(Collection<T> list){
        for (T t: list){
            System.out.println(t.toString());
        }
    }
}

class Album{
    private String name;
    private List<Track> tracks;
    private List<Artist> musicians;

    public Album(String name, List<Track> tracks, List<Artist> musicians) {
        this.name = name;
        this.tracks = new ArrayList<>(tracks);
        this.musicians = new ArrayList<>(musicians);
    }

    public String getName() {
        return name;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public List<Artist> getMusicians() {
        return musicians;
    }
}

class Track{
    Track(String name, int length){
        this.length = length;
        this.name = name;
    }
    int length;
    String name;
    int getLength(){
        return this.length;
    }

    String getName(){
        return this.name;
    }

}



class Artist{
    public Artist(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Artist(String name, String location, List<Artist> members) {
        this.members = members;
        this.name = name;
        this.location = location;
    }
    String name;
    String location;
    private List<Artist> members;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Artist> getMembers() {
        return members;
    }
}
