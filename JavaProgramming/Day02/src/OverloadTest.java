
public class OverloadTest {

	public static void main(String[] args) {
//		f('c');		// f(char) ȣ��
//		byte i = 2;
//		f(i);		// f(int) ȣ��
//		short j = 2;
//		f(j);		// f(int) ȣ��
//		f(2);		// f(int) ȣ��
//		f(2L);		// f(long) ȣ��
//		f(2.0);		// ����
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
