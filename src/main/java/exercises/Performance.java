package exercises;

import java.util.stream.Stream;

/**
 * Created by Mezentsev.Y on 5/4/2016.
 */
public interface Performance {
     String getName();
     Stream<Artist> getMusicians();
     Stream<Artist> getAllMusicians();
}
