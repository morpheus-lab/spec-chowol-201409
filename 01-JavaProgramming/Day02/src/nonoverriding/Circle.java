package nonoverriding;

public class Circle extends Shape {
	
	private double radius;
	public Circle(int radius) {
		this.radius = radius;
	}
	public void makeArea() {
		area = Math.PI * Math.pow(radius, 2);
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public static void display() {
		System.out.println("Circle " + s);
	}
}
