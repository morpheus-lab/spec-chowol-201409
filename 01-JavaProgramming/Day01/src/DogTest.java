
public class DogTest {

	public static void main(String[] args) {
		
		Dog dog = new Dog();
		
		System.out.println("�̸�: " + dog.name);
		
		dog.name = "�鱸";
		dog.type = "������";
		dog.color = "���";
		
		System.out.println("�̸�: " + dog.name);
		System.out.println("ǰ��: " + dog.type);
		System.out.println("�ٸ�: "
				+ dog.numberOfLegs + " ��");
		
		dog.bark();
		
		System.out.println(dog);
	}
	
}
