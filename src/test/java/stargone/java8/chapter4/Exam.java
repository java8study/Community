package stargone.java8.chapter4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.lang.StringUtils;

public class Exam {
	public static void main(String[] args) {
		System.out.println("문자열 입력: ");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
		String tmp = str;
		Map<String, String> map = new HashMap<String, String>();
		int max = 0;
		
		// 마지막 3글자 까지만
		for (int i = 0; tmp.length() != 1; i++) { 					 
			tmp = str.substring(i, str.length());
			// 현재 문자열 중 반만. 내림
			int cnt = (int) Math.floor(tmp.length() / 2);			 
			// 2글자부터 문자열 생성
			for (int j = 2; j <= cnt; j++) { 						 
				String string = tmp.substring(0, j);
				// 생성된 문자열 포함 갯수 추출
				int count = StringUtils.countMatches(str, string);   
				if (count > max) {
					// max 기준 넘는 경우 새로 정의
					map = new HashMap<String, String>();			 
					map.put(string, string);
					max = count;
				} else if (count == max) {
					// max 동일한 경우 추가
					map.put(string, string);						 
				}
			}
		}

		Iterator<String> keys = map.keySet().iterator();
		while (keys.hasNext()) {
			System.out.println(keys.next() + ": " + max);
		}
	}
}