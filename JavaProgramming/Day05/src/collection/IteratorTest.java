package collection;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.StringTokenizer;

public class IteratorTest {
	
	public static void main(String[] args) {
		
//		ArrayList a = null;
//		ArrayList<Object> a = null;
		
		ArrayList<String> coffees = new ArrayList<String>();
		
		coffees.add("자바 칩 프라푸치노");
		coffees.add("아메리카노");
		coffees.add("에스프레소");
		coffees.add("카페 라떼");
		
		Iterator<String> coffeesIter = coffees.iterator();
//		while (coffeesIter.hasNext()) {
//			String coffee = coffeesIter.next();
//			System.out.println(coffee);
//		}
		
		String text = "a b c d efg h i j kl";
		StringTokenizer st = new StringTokenizer(text);
		
		Enumeration<Object> en = (Enumeration<Object>) st;
		while (en.hasMoreElements()) {
			String s = (String) en.nextElement();
			System.out.println(s);
		}
		
//		String coffee = coffeesIter.next();
//		System.out.println(coffee);
//		
//		coffee = coffeesIter.next();
//		System.out.println(coffee);
//		
//		coffee = coffeesIter.next();
//		System.out.println(coffee);
//		
//		coffee = coffeesIter.next();
//		System.out.println(coffee);
//		
//		coffee = coffeesIter.next();
//		System.out.println(coffee);
		
//		String coffee = coffeesIter.next();
//		System.out.println(coffee + " 노드 탐색");
//		coffee = coffeesIter.next();
//		System.out.println(coffee + " 노드 탐색");
//		
//		coffeesIter.remove();
//		
//		System.out.println(coffees);
	}
	
}
