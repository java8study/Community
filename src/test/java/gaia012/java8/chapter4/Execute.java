package gaia012.java8.chapter4;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by LeeJongRyul on 2017-03-11.
 */
public class Execute {
    private List<Dish> menu;

    @Before
    public void before() {
        menu = Arrays.asList(
                new Dish("work", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish(" rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish(" pizza", true, 550, Dish.Type.OTHER),
                new Dish(" prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));
    }

    @Test
    public void execute1() {
        List<Dish> result = menu.stream().filter(dish -> dish.getType().equals(Dish.Type.MEAT)).limit(2).collect(Collectors.toList());

        assertThat(result.get(0).getName(), is("work"));
        assertThat(result.get(1).getName(), is("beef"));
    }

    @Test
    public void execute2() {
        List<Dish> result = menu.stream().filter(d -> d.getCalories() > 300).skip(2).collect(Collectors.toList());
        assertThat(result.get(0).getName(), is("chicken"));
        assertThat(result.get(1).getName(), is("french fries"));
    }

    @Test
    public void execute3() {
        String str = "banana";
        Map<String, Integer> map = new HashMap<>();

        /**
         * 모든 경우의 수를 찾기.
         */
        for (int i = 0; i <= str.length(); i++) {
            for (int j = i + 2; j <= str.length(); j++) {
                String tmp = str.substring(i, j);
                if (!map.containsKey(tmp)) {
                    map.put(tmp, 1);
                } else {
                    map.put(tmp, map.get(tmp) + 1);
                }
            }
        }


        /**
         * Max값 구하기.
         */
        int maxValue = map.values().stream().mapToInt(i -> i).max().getAsInt();

        /**
         * 최대값과 같은 걸 찾아서 출력
         *  일반 for문
         */
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxValue) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }

        System.out.println("--------------------------------");

        /**
         * 최대값과 같은 걸 찾아서 출력
         *  java8 Stream 이용
         */
        map.entrySet().stream().filter(item -> item.getValue() == maxValue).forEach(item ->
                System.out.println(item.getKey() + " : " + item.getValue())
        );


    }
}
