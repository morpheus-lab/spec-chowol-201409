
public class Circle {

	private double radius = 0;
	
	public void setRadius(double r) {
		radius = r;
	}
	
	public double getArea() {
		return Math.PI * radius * radius;
	}
	
	public void display() {
		System.out.println("Areas of circle with radius "
				+ radius + " = " + getArea());
	}
}
