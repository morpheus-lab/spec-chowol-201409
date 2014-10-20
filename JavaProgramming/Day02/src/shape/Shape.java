package shape;

public class Shape {

	protected double area;
	protected double circum;
	
	public Shape() {}
	
	private void makeArea() {
		System.out.println("Shape.makeArea()");
	}
	
//	public void makeCircum() {
//		
//	}
	
	public void display() {
		System.out.print("area = " + area + ", "
				+ "circum = " + circum
				+ "(Shape에서 출력)");
	}
	
	public double getArea() {
		return area;
	}
	
	public double getCircum() {
		return circum;
	}
	
}
