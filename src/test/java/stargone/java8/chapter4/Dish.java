package stargone.java8.chapter4;

public class Dish {
	private int calories;
	private String name;
	private boolean vegtarian;

	public boolean isVegtarian() {
		return vegtarian;
	}

	public void setVegtarian(boolean vegtarian) {
		this.vegtarian = vegtarian;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
