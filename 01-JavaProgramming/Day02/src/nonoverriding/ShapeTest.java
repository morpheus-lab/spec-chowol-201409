package nonoverriding;

public class ShapeTest {
	
	public void m(Shape s) {
		/*
		// s�� Circle Ÿ���� ��ü���
		if (s instanceof Circle) {
			Circle c = (Circle) s;
			c.makeAC();
		}
		// s�� Rectangle Ÿ���� ��ü���
		else if (s instanceof Rectangle) {
			Rectangle r = (Rectangle) s;
			r.makeAR();
		}
		*/
		s.makeArea();
		s.display();
	}
	
	public static void main(String[] args) {
		ShapeTest t = new ShapeTest();
		t.m(new Shape());
		t.m(new Circle(6));
		t.m(new Rectangle(4, 5));
	}
	
}
