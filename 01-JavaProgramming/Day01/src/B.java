
public class B {

	String name;
	String age;
	String address;
	
	public B() {
//		this(null);
//		this(null, null);
		this(null, null, null);
		System.out.println("인자 없는 생성자");
	}
	
	public B(String n) {
//		name = n;
//		this(n, null);
		this(n, null, null);
		System.out.println("인자 1개짜리 생성자");
	}
	
	public B(String n, String a) {
//		name = n; age = a;
		this(n, a, null);
		System.out.println("인자 2개짜리 생성자");
	}
	
	public B(String n, String a, String addr) {
		name = n; age = a; address = addr;
		System.out.println("인자 3개짜리 생성자");
	}

	public static void main(String[] args) {
		B b0, b1, b2, b3;
//		b0 = new B();
		b1 = new B("홍길동");
//		b2 = new B("고길동", "53");
//		b3 = new B("둘리", "11", "쌍문동");
	}
	
}
