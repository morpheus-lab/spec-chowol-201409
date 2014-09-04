
public class StaticTest {

	public static void main(String[] args) {
		
		A a1, a2;
		a1 = new A();
		a2 = new A();
		A.sm();
//		A.m();
		a1.sm();
		a1.m();
		a2.m();
		
	}
	
}
