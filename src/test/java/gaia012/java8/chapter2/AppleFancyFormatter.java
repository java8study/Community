package gaia012.java8.chapter2;

/**
 * Created by LeeJongRyul on 2017-02-26.
 */
public class AppleFancyFormatter implements AppleFormatter {

    public String accept(Apple apple) {
        String characteristic = apple.getWeight() > 150 ? "heavy" : "light";
        return "A " + characteristic + apple.getColor() + " apple";
    }
}
