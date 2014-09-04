package exceptions;

public class ExceptionTest {

	public void m(int i) {
		int j =  99 / i;
		System.out.println("99를 " + i + "로 나눈 몫은 " + j + "입니다.");
	}
	
	public static void main(String[] args) {
		
		int i = 0;
		
		try {
			i = Integer.parseInt(args[0]);
			ExceptionTest t = new ExceptionTest();
			t.m(i);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("프로그램 인자가 부적절합니다.");
		}
		finally {
			System.out.println("FINALLY");
		}
//		catch (ArithmeticException e) {
//			System.out.println("연산 오류가 발생했습니다.");
//		}
//		catch (Exception e) {
//			System.out.println("예외가 발생했습니다.");
//			e.printStackTrace();
//		}
		
		
		System.out.println("end of main!");
		
	}
	
}
