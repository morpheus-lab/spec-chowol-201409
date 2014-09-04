
public class A {

	int i;
	static int si;
	
	void m() {
		System.out.println(si);
		System.out.println(i);
		System.out.println(A.si);
		System.out.println(this.i);
	}
	
	static void sm() {
		System.out.println(si);
//		System.out.println(i);
		System.out.println(A.si);
//		System.out.println(this.i);
//		m();
	}
	
}
