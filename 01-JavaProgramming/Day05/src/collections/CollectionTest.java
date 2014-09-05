package collections;

import java.util.ArrayList;

public class CollectionTest {
	
	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("Java");
		list.add("공부가");
		list.add("재미있나요?");
		
		System.out.println(list);
		
		ArrayList<String> list2 = new ArrayList<String>();
		
		list2.addAll(list);
		list2.add("정말?");
		
		System.out.println(list2);
		
		
	}
	
}
