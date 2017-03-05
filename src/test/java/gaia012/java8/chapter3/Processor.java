package gaia012.java8.chapter3;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by LeeJongRyul on 2017-03-04.
 */
public class Processor {

    //    Before
    public String processFile() throws IOException {
        String filePath = new File(".").getAbsolutePath().replace(".", "");
        try (BufferedReader br = new BufferedReader(new FileReader(filePath + "src/test/java/gaia012/java8/chapter3/data.txt"))) {
            return br.readLine();
        }
    }

    public String processFile(BufferedReaderProcessor p) throws IOException {
        String filePath = new File(".").getAbsolutePath().replace(".", "");
        try (BufferedReader br = new BufferedReader(new FileReader(filePath + "src/test/java/gaia012/java8/chapter3/data.txt"))) {
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

    @Test
    public void execute2() {
//      람다 안에서 사용되는 지역변수는 final(상수)처럼 사용되어야 한다.

        final int portNumber = 1337;
        Runnable r = () -> System.out.println(portNumber);
//        portNumber = 31337;
        assertThat(portNumber, is(1337));
    }

    @Test
    public void execute3() {
        String str = "3";
        Function<String, Integer> stringToInteger =
                (String s) -> Integer.parseInt(s);
        Function<String, Integer> stringToInteger2 = Integer::parseInt;
        assertThat(stringToInteger.apply(str), is(stringToInteger2.apply(str)));

        List<String> param = Lists.newArrayList();
        param.add("1");
        param.add("2");
        param.add("3");

        BiPredicate<List<String>, String> contain = (list, element) -> list.contains(element);
        BiPredicate<List<String>, String> contain2 = List::contains;

        assertThat(contain.test(param, "3"), is(contain2.test(param, "3")));
    }

    private int paramToStrings(String... str) {
//        str : 배열
        for (String s : str) {
            System.out.println(s);
        }
        return str.length;
    }

    @Test
    public void paramToStringTest() {
        assertThat(paramToStrings("11", "22", "33", "44", "55"), is(5));
    }
}
