package exceptions;

public class ExceptionTest {

	public void m(int i) {
		int j =  99 / i;
		System.out.println("99�� " + i + "�� ���� ���� " + j + "�Դϴ�.");
	}
	
	public static void main(String[] args) {
		
		int i = 0;
		
		try {
			i = Integer.parseInt(args[0]);
			ExceptionTest t = new ExceptionTest();
			t.m(i);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("���α׷� ���ڰ� �������մϴ�.");
		}
		finally {
			System.out.println("FINALLY");
		}
//		catch (ArithmeticException e) {
//			System.out.println("���� ������ �߻��߽��ϴ�.");
//		}
//		catch (Exception e) {
//			System.out.println("���ܰ� �߻��߽��ϴ�.");
//			e.printStackTrace();
//		}
		
		
		System.out.println("end of main!");
		
	}
	
}
