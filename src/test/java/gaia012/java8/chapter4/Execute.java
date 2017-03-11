package gaia012.java8.chapter4;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
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
    public void execute2(){
        List<Dish> result = menu.stream().filter(d -> d.getCalories() > 300).skip(2).collect(Collectors.toList());
        assertThat(result.get(0).getName(), is("chicken"));
        assertThat(result.get(1).getName(), is("french fries"));
    }
}
