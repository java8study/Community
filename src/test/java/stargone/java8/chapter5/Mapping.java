package stargone.java8.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Before;

import gaia012.java8.chapter4.Dish;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;

public class Mapping {
	private static List<Dish> menu;

	public static void main(String[] args) {
		menu = Arrays.asList(new Dish("work", false, 800, Dish.Type.MEAT), new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT), new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish(" rice", true, 350, Dish.Type.OTHER), new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish(" pizza", true, 550, Dish.Type.OTHER), new Dish(" prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH));
		
		List<String> dishNames = menu.stream()
									.map(Dish::getName)
									.collect(toList());
		
		System.out.println(dishNames);
		
		List<String> words = new ArrayList<String>();
		words.add("hello");
		words.add("word");
		
		List<String[]> result2 = words.stream()
				.map(word -> word.split(""))
				 .distinct()
				 .collect(toList());
		
		System.out.println(result2.size());
		for (int i = 0; i < result2.size(); i++) {
			for (int j = 0; j < result2.get(i).length; j++) {
				System.out.println("i: "  + i + ", j: "  + j + " => " + result2.get(i)[j]);
			}
		}
		
//		List<Test> dish = new ArrayList<Test>();
//		Test ts = new Test();
//		Test ts2 = new Test();
//		
//		dish.add(ts);
//		dish.add(ts);
//
//		List<Test> result2 = dish.stream()
//				 .distinct()
//				 .collect(toList());
//		
//		System.out.println(result2.size());
//		for (int i = 0; i < result2.size(); i++) {
//			System.out.println(result2.get(i));
//		}
//		
		
	}

}