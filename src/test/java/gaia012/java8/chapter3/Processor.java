package gaia012.java8.chapter3;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
        String toLines = processFile((BufferedReader br) -> br.readLine() + br.readLine());

        Assert.assertEquals(oneLine, "oneLine");
        Assert.assertEquals(toLines, "oneLinetwoLine");
    }
}
