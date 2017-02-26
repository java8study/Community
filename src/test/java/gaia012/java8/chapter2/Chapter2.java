package gaia012.java8.chapter2;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LeeJongRyul on 2017-02-26.
 */
public class Chapter2 {
    private List<Apple> inventory = new ArrayList<Apple>();
    private final int value = 4;

    @Before
    public void before() {

        Apple apple = new Apple();
        apple.setColor("red");
        apple.setWeight(150);
        inventory.add(apple);

        Apple apple2 = new Apple();
        apple2.setColor("green");
        apple2.setWeight(100);
        inventory.add(apple2);
    }

    public void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for (Apple apple : inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }

    @Test
    public void test2_1() {
        prettyPrintApple(inventory, new AppleFancyFormatter());
    }

    @Test
    public void test2_2(){
        Chapter2 chapter2 = new Chapter2();
        chapter2.doIt();
    }

    public void doIt() {
        int value = 6;
        Runnable r = new Runnable() {
            private final int value = 5;
            public void run() {
                int value = 10;
                System.out.println(this.value);
            }
        };
        r.run();
    }
}
