
public class DogTest {

	public static void main(String[] args) {
		
		Dog dog = new Dog();
		
		System.out.println("이름: " + dog.name);
		
		dog.name = "백구";
		dog.type = "진돗개";
		dog.color = "흰색";
		
		System.out.println("이름: " + dog.name);
		System.out.println("품종: " + dog.type);
		System.out.println("다리: "
				+ dog.numberOfLegs + " 개");
		
		dog.bark();
		
		System.out.println(dog);
	}
	
}
