
public class CallByTest {

	public static void m() {}
	public static void m(int i) {i = 99;}
	public static void m(int[] arr) {arr[0] = 99;}
	
	public static void main(String[] args) {
//		m();
//		int i = 10;
//		m(i);	// call by value
//		System.out.println(i);	// 결과예상
		
		int[] arr = {10,20,30};
		m(arr);	// call by reference
		System.out.println(arr[0]);	// 결과예상
	}
	
}
