
public class Car {

	String color;
	String grade;
	
	public Car() {
		this("�����", "�����");
	}
	
	public Car(String c, String g) {
		color = c; grade = g;
	}
	
	public void print() {
		System.out.println(color + ", " + grade);
	}
	
}
