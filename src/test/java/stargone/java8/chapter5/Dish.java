package stargone.java8.chapter5;

import lombok.Data;

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
