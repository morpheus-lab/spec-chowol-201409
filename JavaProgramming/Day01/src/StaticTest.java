
public class StaticTest {

	public static void main(String[] args) {
		
		A a1, a2;
		System.out.println("A.si = " + A.si);
//		System.out.println(A.i);
		a1 = new A();
		a1.si++;
		a1.i++;
		
		a2 = new A();
		System.out.println("a2.si = " + a2.si);
		System.out.println("a2.i = " + a2.i);
		
		System.out.println(Math.PI);
	}
	
}
