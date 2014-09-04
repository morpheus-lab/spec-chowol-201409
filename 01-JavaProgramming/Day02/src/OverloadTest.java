
public class OverloadTest {

	public static void main(String[] args) {
//		f('c');		// f(char) 호출
//		byte i = 2;
//		f(i);		// f(int) 호출
//		short j = 2;
//		f(j);		// f(int) 호출
//		f(2);		// f(int) 호출
//		f(2L);		// f(long) 호출
//		f(2.0);		// 오류
		f('c', 'v');
	}
	
	static void f(char c) {
		System.out.println("f(char)");
	}
	
	static void f(char c1, char c2) {
		System.out.println("f(char,char)");
	}
	
	static void f(int i) {
		System.out.println("f(int)");
	}
	
	static void f(long i) {
		System.out.println("f(long)");
	}
	
	
}
