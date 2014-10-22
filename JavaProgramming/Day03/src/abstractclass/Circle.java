package abstractclass;

public class Circle extends Shape {
	// 멤버변수
	private double radius;
//	private double area;
//	private double circum;
	
	// 생성자
	public Circle() {}
	public Circle(double radius) {
		this.radius = radius;
	}
	
	// 면적 계산
	public void makeArea() {
		System.out.println("Circle.makeArea()");
		area = Math.PI * radius * radius;
	}
	// 둘레 계산
	public void makeCircum() {
		circum = 2 * Math.PI * radius;
	}
	// 정보 출력
	public void display() {
		super.display();
		System.out.println(", radius = " + radius);
	}
//	// 면적 getter
//	public double getArea() {
//		return area;
//	}
//	// 둘레 getter
//	public double getCircum() {
//		return circum;
//	}
	// 반지름 getter
	public double getRadius() {
		return radius;
	}
	
}
