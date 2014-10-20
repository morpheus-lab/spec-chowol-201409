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
		/* 1. heap memory�� A Ÿ���� �޸� �Ҵ� �� �ν��Ͻ� ����
		 * 2. ���� clone�� �� 1���� �ν��Ͻ� ����
		 * 3. �ν��Ͻ� ��� ������ �ʱ�ȭ
		 *    clone.i = 1
		 *    clone.arr = {1, 2, 3}
		 * 4. ������ ȣ��
		 *    clone.i = this.i
		 * 5. ���
		 *    clone.i = this.i
		 *    clone.arr = {this.i, 2, 3}
		 */
		A clone = new A(this.i);
		return clone;
	}
	
}
