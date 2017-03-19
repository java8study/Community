package gaia012.java8.chapter5;

import gaia012.java8.chapter2.Apple;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by LeeJongRyul on 2017-03-19.
 */
public class Execute {

    @Test
    public void execute1() {
        String[] arrayOfWords = {"Goodbye", "World"};
        List<String> words = Arrays.asList(arrayOfWords);

        List<Stream<String>> list = words.stream()
                .map(item -> item.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        for (Stream<String> a : list) {
            a.forEach(b -> System.out.print(b)
            );
        }
        System.out.println();
        List<String> uniqueCharacters =
                words.stream().map(w -> w.split(""))
                        .flatMap(Arrays::stream)
                        .distinct()
                        .collect(Collectors.toList());
        uniqueCharacters.stream().forEach(
                item -> System.out.print(item)
        );
    }

    @Test
    public void execute2() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        List<Apple> apples = new ArrayList<>();
        Apple apple = new Apple(100, "yellow");
        apples.add(new Apple(10, "red"));
        apples.add(new Apple(20, "green"));
        apples.add(new Apple(10, "red"));
        apples.add(apple);
        apples.add(apple);
        List<Integer> result = distinct(list);
        List<Apple> result2 = distinct(apples);
        result.stream().forEach(
                item -> System.out.println(item)
        );
        result2.stream().forEach(
                item -> System.out.println(item.getColor()+"--"+item.getWeight())
        );
    }

    private <T> List<T> distinct(List<T> list) {
        Set<T> collect = new HashSet<T>(list);
        return new ArrayList<T>(collect);
    }
}
