
public class Dog {

	// 멤버 변수
	// 필드 (fields)
	String name;
	String color;
	String type;
	static int numberOfLegs;
	
	// 생성자
	public Dog() {
//		System.out.println("다리는 4개");
		numberOfLegs = 4;
	}
	
	// 메소드
	public void bark() {
		System.out.println("멍멍!");
	}
	
	
	
	
}
