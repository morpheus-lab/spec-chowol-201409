
public class B {

	String name;
	String age;
	String address;
	
	public B() {
//		this(null);
//		this(null, null);
		this(null, null, null);
		System.out.println("���� ���� ������");
	}
	
	public B(String n) {
//		name = n;
//		this(n, null);
		this(n, null, null);
		System.out.println("���� 1��¥�� ������");
	}
	
	public B(String n, String a) {
//		name = n; age = a;
		this(n, a, null);
		System.out.println("���� 2��¥�� ������");
	}
	
	public B(String n, String a, String addr) {
		name = n; age = a; address = addr;
		System.out.println("���� 3��¥�� ������");
	}

	public static void main(String[] args) {
		B b0, b1, b2, b3;
//		b0 = new B();
		b1 = new B("ȫ�浿");
//		b2 = new B("��浿", "53");
//		b3 = new B("�Ѹ�", "11", "�ֹ���");
	}
	
}
