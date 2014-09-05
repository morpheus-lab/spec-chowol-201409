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
		
		list2.addAll(list);	// list의 요소를 한꺼번에 추가
		list2.add("정말?");
		
		System.out.println(list2);
		
		// "Java"가 list2에 있는지 검사
		System.out.println("***** contains() ******");
		boolean contains = list2.contains("java");
		System.out.println(contains);
		
		// list2에 모든 list 요소가 포함되어 있는지 검사
		System.out.println("***** containsAll() ******");
		contains = list2.containsAll(list);
		System.out.println(contains);
		
		// list에 모든 list2 요소가 포함되어 있는지 검사
		contains = list.containsAll(list2);
		System.out.println(contains);
		
		// isEmpty()
		System.out.println("***** isEmpty() ******");
		boolean isEmpty = list2.isEmpty();
		if (isEmpty) {
			System.out.println("컬렉션이 비어 있습니다.");
		} else {
			System.out.println("컬렉션이 비어있지 않습니다.");
		}
		
		// size()
		System.out.println("***** size() ******");
		System.out.println("list는 " + list.size() + "개의 자료를 갖고 있습니다.");
		
		// clear()
//		System.out.println("***** clear() ******");
//		System.out.println("list2 : " + list2);
//		list2.clear();
//		System.out.println("list2 : " + list2);
		
		// remove()
//		System.out.println("***** remove() ******");
//		list.remove("Java");
//		System.out.println(list);
//		
//		list.remove(0);
//		System.out.println(list);
		
		// removeAll()
//		System.out.println("***** removeAll() ******");
//		System.out.println("list : " + list);
//		System.out.println("list2: " + list2);
//		list.removeAll(list2);
//		list2.removeAll(list);
//		System.out.println("list : " + list);
//		System.out.println("list2: " + list2);
		
		// retainAll()
		list.add("와우~!!");
		System.out.println("***** retainAll() ******");
		System.out.println("list : " + list);
		System.out.println("list2: " + list2);
		list2.retainAll(list);
		System.out.println("list : " + list);
		System.out.println("list2: " + list2);
		
		// toArray()
		Object[] arr = list.toArray();
//		if (arr != null) {
//			for (int i = 0; i < arr.length; i++) {
//				if (arr[i] instanceof String) {
//					System.out.println("String 인스턴스입니다.");
//				}
//			}
//		}
//		String[] sArr = (String[]) arr;	// Cast 에러
		String firstNode = (String) arr[0];
		
		String[] bag = new String[list.size()];
		
		list.toArray(bag);
		
		System.out.println(bag);
		
		if (bag != null) {
			for (int i = 0; i < bag.length; i++) {
				System.out.println(bag[i]);
			}
		}
		
	}
	
}
