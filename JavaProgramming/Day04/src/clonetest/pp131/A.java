package clonetest.pp131;

public class A {
	 
	public int i = 1;
	private int[] arr = {1, 2, 3};
	
	public A() {
		
		Object obj;
		
	}
	
	public A(int i) {
		set(i);
	}
	
	public void set(int i) {
		this.i = i;
		this.arr[0] = i;
	}
	
	public int getI() {
		return i;
	}
	
	public int[] getArr() {
		return arr;
	}
	
	public void print() {
		System.out.println("i = " + i + ", arr[0] = " + arr[0]);
	}
	
	// Shallow Copy
//	public A clone() {
//		return this;
//	}
	
	// Deep Copy
	public A clone() {
		/* 1. heap memory에 A 타입의 메모리 할당 및 인스턴스 생성
		 * 2. 변수 clone에 위 1번의 인스턴스 연결
		 * 3. 인스턴스 멤버 변수가 초기화
		 *    clone.i = 1
		 *    clone.arr = {1, 2, 3}
		 * 4. 생성자 호출
		 *    clone.i = this.i
		 * 5. 결과
		 *    clone.i = this.i
		 *    clone.arr = {this.i, 2, 3}
		 */
		A clone = new A(this.i);
		return clone;
	}
	
}
