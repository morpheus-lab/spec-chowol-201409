
public class Employee {

	String name;
	String no;
	String dept;
	
	public Employee() {
//		name = "이름없음"; no = "임시사번"; dept = "임시부서";
		this("이름없음", "임시사번", "임시부서");
		System.out.println("인자없는 생성자 호출됨!!!");
	}
	
	public Employee(String na, String n, String d) {
		name = na; no = n; dept = d;
		System.out.println("인자있는 생성자 호출됨!!!");
	}
	
	public void print() {
		System.out.println(name + ", " + no + ", " + dept);
	}
	
}
