package shape;

public class Rectangle extends Shape {
	// �������
	private double width;
	private double height;
//	private double area;
//	private double circum;
	
	// ������
	public Rectangle() {}
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	// ���� ���
	public void makeArea() {
		area = width * height;
	}
	// �ѷ� ���
	public void makeCircum() {
		System.out.println("Rectangle.makeCircum()");
		circum = (width * 2) + (height * 2);
	}
	// ���� ���
	public void display() {
		super.display();	// ����, �ѷ� ��µ�
		System.out.println(", width = " + width + ", "
				+ "height = " + height);
	}
//	// ���� getter
//	public double getArea() {
//		return area;
//	}
//	// �ѷ� getter
//	public double getCircum() {
//		return circum;
//	}
	// �ʺ� getter
	public double getWidth() {
		return width;
	}
	// ���� getter
	public double getHeight() {
		return height;
	}
}
