package stargone.java8.chapter5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Exam {
	
	public static <T> List<T> distinct(List<T> list) {
		List<T> result = list.stream()
							.distinct()
							.collect(Collectors.toList());
		return result;
	}

	public static void main(String[] args) {
		List<String> strList = new ArrayList<String>();
		strList.add("abcd");
		strList.add("abcd");
		strList.add("efgh");
		strList.add("aijkl");
		strList.add("emnop");
		
		System.out.println(distinct(strList));
		
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(1);
		intList.add(2);
		intList.add(3);
		intList.add(4);
		intList.add(44);
		intList.add(44);
		
		System.out.println(distinct(intList));
	}
}