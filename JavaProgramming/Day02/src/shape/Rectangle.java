package shape;

public class Rectangle extends Shape {
	// 멤버변수
	private double width;
	private double height;
//	private double area;
//	private double circum;
	
	// 생성자
	public Rectangle() {}
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	// 면적 계산
	public void makeArea() {
		area = width * height;
	}
	// 둘레 계산
	public void makeCircum() {
		System.out.println("Rectangle.makeCircum()");
		circum = (width * 2) + (height * 2);
	}
	// 정보 출력
	public void display() {
		super.display();	// 면적, 둘레 출력됨
		System.out.println(", width = " + width + ", "
				+ "height = " + height);
	}
//	// 면적 getter
//	public double getArea() {
//		return area;
//	}
//	// 둘레 getter
//	public double getCircum() {
//		return circum;
//	}
	// 너비 getter
	public double getWidth() {
		return width;
	}
	// 높이 getter
	public double getHeight() {
		return height;
	}
}
