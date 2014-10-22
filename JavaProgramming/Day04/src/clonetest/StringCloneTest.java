package clonetest;

public class StringCloneTest {
	
	public static void main(String[] args) {
		
		String str1 = "Hello";
		
		String str2 = str1;
		
		System.out.println(str1);
		System.out.println(str2);
		
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		
		str1 = "a";
		
		System.out.println(str1);
		System.out.println(str2);
		
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		
	}
	
}
