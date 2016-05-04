package threads;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Mezentsev.Y on 4/28/2016.
 */
public class ExampleRefactoring {
    public static void main(String[] args) {

        List<Track> list1 = Arrays.asList(new Track("111", 10),new Track("222", 20),new Track("333", 30),new Track("444", 50));
        List<Track> list2 = Arrays.asList(new Track("111aaa", 10),new Track("222aaa", 20),new Track("333aaa", 30),new Track("444aaa", 50));
        List<Track> list3 = Arrays.asList(new Track("111sss", 10),new Track("222sss", 20),new Track("333sss", 30),new Track("444sss", 50));
        List<Album> albums = Arrays.asList(new Album(list1),new Album(list2),new Album(list3));
        Set<String> set = findLongTracks(albums);
        printList(set);
        /*1 step*/
        set.clear();
        albums.stream().forEach(album -> {
            album.getTrackList().forEach(track -> {
                if (track.getLength() > 20) {
                    String name = track.getName();
                    set.add(name);
                }
            });
        });
        printList(set);
        /*2 step*/
        set.clear();
        albums.stream().forEach(album -> {
            album.getTrackList().stream().filter(track -> {
                return track.getLength() > 20;
            }).map(track -> track.getName()).forEach(name -> set.add(name));
        });
        printList(set);
        /*3 step*/
        set.clear();
        albums.stream()
                .flatMap(album -> album.getTrackList().stream())
                .filter(track -> track.getLength() > 20)
                .map(track -> track.getName())
                .forEach(name -> set.add(name));
        printList(set);
         /*4 step*/
        set.clear();

        Set<String> set2 = albums.stream()
                .flatMap(album -> album.getTrackList().stream())
                .filter(track -> track.getLength() > 20)
                .map(track -> track.getName())
                .collect(Collectors.toSet());
        printList(set2);


    }

    public static Set<String> findLongTracksStream(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();

        return trackNames;
    }

    public static Set<String> findLongTracks(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        for (Album album : albums) {
            for (Track track : album.getTrackList()) {
                if (track.getLength() > 20) {
                    String name = track.getName();
                    trackNames.add(name);
                }
            }
        }
        return trackNames;
    }

    static <T> void printList(Set<T> set){
        for (T t: set){
            System.out.println(t.toString());
        }
    }
}

class Album{
    List<Track> trackList;
    Album(List<Track> trackList){
        this.trackList = trackList;
    }

    List<Track> getTrackList(){
        return this.trackList;
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
