package gaia012.java8.chapter3;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by LeeJongRyul on 2017-03-04.
 */
public interface BufferedReaderProcessor {
    String process(BufferedReader b) throws IOException;
}
