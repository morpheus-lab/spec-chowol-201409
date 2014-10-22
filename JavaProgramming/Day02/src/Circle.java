
public class Circle {
	
	private double radius = 0;
	
	public Circle setRadius(double r /*double r*/) {
//		radius = r;
		
		radius = 3;
		
		getArea();
		
//		this.radius = 3;
		
//		this.radius = radius;
		return this;
	}
	
	public double getArea() {
		return Math.PI * radius * radius;
	}
	
	public Circle display() {
		System.out.println("Areas of circle with radius "
				+ radius + " = " + getArea());
		return this;
	}
	
}
