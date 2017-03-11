package gaia012.java8.chapter4;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by LeeJongRyul on 2017-03-11.
 */
@Data
public class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public enum Type {
        MEAT, FISH, OTHER
    }
}
