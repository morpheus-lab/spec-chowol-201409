package systemapis;

public class ObjectClassTest {

	public Object cloneTest() throws CloneNotSupportedException {
		return this.clone();
	}
	
	public static void main(String[] args) {
		
		Object obj1 = new Object();
		
		Object obj2 = new Object();
		
		// Object.equals()
//		System.out.println(obj1.equals(obj2));
		
		
		// Object.toString() => "Ŭ���� �̸�@�ؽ��ڵ�"
		String str = obj1.toString();
		System.out.println(str);

		System.out.println(obj1);
		
//		str = obj2.toString();
//		System.out.println(str);
		
		// Object.clone() => protected �޼���� �ν��Ͻ��� �����Ͽ� ȣ�� �Ұ�
		
		// Object.finalize()
		
		
	}
	
}
