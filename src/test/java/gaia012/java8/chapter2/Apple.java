package gaia012.java8.chapter2;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by LeeJongRyul on 2017-02-26.
 */
@Getter
@Setter
public class Apple {
    private String color;
    private int weight;


    public Apple() {

    }
    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }
}
