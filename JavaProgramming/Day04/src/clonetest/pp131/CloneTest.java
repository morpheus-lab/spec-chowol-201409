package clonetest.pp131;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class CloneTest {
	
	public static void main(String[] args) {
		
		A a = new A(10);
		
		// Object Copy
		A aCopy = a.clone();
		// i, arr[0] 출력 비교
		a.print();		// i = 10, arr[0] = 10
		aCopy.print();	// i = 10, arr[0] = 10
		
		// i, arr[0] 값 변경
		a.set(20);
		// i, arr[0] 출력 비교
		a.print();		// i = 20, arr[0] = 20
		aCopy.print();	// i = 10, arr[0] = 10
		
	}
	
}
