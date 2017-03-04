package gaia012.java8.chapter3;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by LeeJongRyul on 2017-03-04.
 */
public class Processor {

    //    Before
    public String processFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\development\\intellij\\workspace\\Community\\src\\test\\java\\gaia012\\java8\\chapter3\\data.txt"))) {
            return br.readLine();
        }
    }

    public String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\development\\intellij\\workspace\\Community\\src\\test\\java\\gaia012\\java8\\chapter3\\data.txt"))) {
            return p.process(br);
        }
    }

    @Test
    public void execute() throws IOException {
        String oneLine = processFile((BufferedReader br) -> br.readLine());
        String twoLines = processFile((BufferedReader br) -> br.readLine() + br.readLine());

        assertThat(oneLine, is("oneLine"));
        assertThat(twoLines, is("oneLinetwoLine"));
        assertEquals(oneLine, "oneLine");
        assertEquals(twoLines, "oneLinetwoLine");
    }
}
