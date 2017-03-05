package stargone.java8.chapter1;

import java.util.ArrayList;
import java.util.List;

public class AppleExam {

	public static void prettyPringApple(List<Apple> inventory, AppleFormatter formatter) {
		for (Apple a : inventory) {
			String output = formatter.accept(a);
			System.out.println(output);
		}
	}

	public static class AppleFancyFormatter implements AppleFormatter {
		@Override
		public String accept(Apple a) {
			String characteristic = a.getWeight() > 150 ? "heavy" : "light";
			return "A " + characteristic + " " + a.getColor() + " apple";
		}
	}

	public static class AppleSimpleFormattter implements AppleFormatter {
		@Override
		public String accept(Apple a) {
			return "An apple of " + a.getWeight() + "g";
		}
	}

	public static void main(String[] args) {
		List<Apple> inventory = new ArrayList<Apple>();
		Apple a1 = new Apple(200, "green");
		Apple a2 = new Apple(50, "red");
		inventory.add(a1);
		inventory.add(a2);

		prettyPringApple(inventory, new AppleFancyFormatter());
		prettyPringApple(inventory, new AppleSimpleFormattter());
	}

}
