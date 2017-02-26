package gaia012.java8.chapter2;

/**
 * Created by LeeJongRyul on 2017-02-26.
 */
public class AppleSimpleFormatter implements AppleFormatter{
    public String accept(Apple apple) {

        return "An apple of " + apple.getWeight() + "g";
    }
}
