package nonoverriding;

public class Shape {
	
	protected static String s;
	protected double area;
	
	public static void display() {
		System.out.println(s);
	}
	
	public void makeArea() {}
	
	public double getArea() {
		return area;
	}
	
}
