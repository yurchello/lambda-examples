package patterns_with_lambda.strategy;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Mezentsev.Y on 5/16/2016.
 */
public interface CompressionStrategy {
    public OutputStream compress(OutputStream data) throws IOException;
}
