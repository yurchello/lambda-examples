package patterns_with_lambda.strategy;

import java.io.File;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created by Mezentsev.Y on 5/16/2016.
 */
public class AppLambda {
    public static void main(String[] args) throws IOException {


        Compressor gzipCompressor = new Compressor(GZIPOutputStream::new);
        gzipCompressor.compress(new File("").toPath(), new File(""));

        Compressor zipCompressor = new Compressor(ZipOutputStream::new);
        zipCompressor.compress(new File("").toPath(), new File(""));

        Compressor gzipCompressor2 = new Compressor(GZIPOutputStream::new);
        gzipCompressor.compress(new File("").toPath(), new File(""));
    }
}
