package car;

public class Car {

	String color;
	String grade;
	
	public Car() {
		this("몰라요", "몰라요");
	}
	
	public Car(String c, String g) {
		color = c; grade = g;
	}
	
	public void print() {
		System.out.println(color + ", " + grade);
	}
	
}
