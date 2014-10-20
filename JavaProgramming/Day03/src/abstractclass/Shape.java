package abstractclass;

abstract public class Shape {

	protected double area;
	protected double circum;
	
	public Shape() {}
	
	abstract public void makeArea();
	
	abstract public void makeCircum();
	
	public void display() {
		System.out.print("area = " + area + ", "
				+ "circum = " + circum);
	}
	
	public double getArea() {
		return area;
	}
	
	public double getCircum() {
		return circum;
	}
	
}
