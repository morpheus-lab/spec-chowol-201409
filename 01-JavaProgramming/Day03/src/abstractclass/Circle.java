package abstractclass;

public class Circle extends Shape {
	// �������
	private double radius;
//	private double area;
//	private double circum;
	
	// ������
	public Circle() {}
	public Circle(double radius) {
		this.radius = radius;
	}
	
	// ���� ���
	public void makeArea() {
		System.out.println("Circle.makeArea()");
		area = Math.PI * radius * radius;
	}
	// �ѷ� ���
	public void makeCircum() {
		circum = 2 * Math.PI * radius;
	}
	// ���� ���
	public void display() {
		super.display();
		System.out.println(", radius = " + radius);
	}
//	// ���� getter
//	public double getArea() {
//		return area;
//	}
//	// �ѷ� getter
//	public double getCircum() {
//		return circum;
//	}
	// ������ getter
	public double getRadius() {
		return radius;
	}
	
}
