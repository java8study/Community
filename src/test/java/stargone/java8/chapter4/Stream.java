package stargone.java8.chapter4;

import java.util.ArrayList;
import java.util.List;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class Stream {
	public static void main(String[] args) {
		List<Dish> menu = new ArrayList<Dish>();
		
		Dish dish = new Dish();
		dish.setCalories(500);
		dish.setName("사과");
		menu.add(dish);
		
		Dish dish2 = new Dish();
		dish2.setCalories(300);
		dish2.setName("바나나"); 
		menu.add(dish2);
		
		Dish dish3 = new Dish();
		dish3.setCalories(300);
		dish3.setName("레몬");
		menu.add(dish3);
		
		Dish dish4 = new Dish();
		dish4.setCalories(300);
		dish4.setName("나초");
		menu.add(dish4);

		List<String> lowCaloricDishesName = 
				menu.stream()
				.filter(d -> d.getCalories() < 400)
				.sorted(comparing(Dish::getName))
				.map(Dish::getName)
				.limit(2)
				.collect(toList());
		
		for (int i = 0; i < lowCaloricDishesName.size(); i++) {
			System.out.println(lowCaloricDishesName.get(i));
		}
	}
}
