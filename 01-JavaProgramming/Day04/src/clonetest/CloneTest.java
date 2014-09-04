package clonetest;

public class CloneTest {
	
	public static void main(String[] args) {
		
		Route r1 = new Route();
//		Route r2 = r1;
		Route r2 = r1.clone();
		
		System.out.println(r1);
		System.out.println(r2);
		
		r1.routeName = "Route #1";
		
		System.out.println(r1.routeName);
		System.out.println(r2.routeName);
		
		r2.routeName = "Route #2";
		
		System.out.println(r1.routeName);
		System.out.println(r2.routeName);
		
	}
	
}
