package exceptions;

public class MyExceptionTest {

	public void doDangerousTask(int i) throws OutOfRangeException {
		
		// ...
		if (i < 0) {
			throw new OutOfRangeException("�� �� ���� ���� �߻�!!!");
		}
		else if (i > 100) {
			throw new OutOfRangeException("ó�� ���� ���� ���");
		}
		
	}
	
	
	public static void main(String[] args) {
		
		MyExceptionTest test = new MyExceptionTest();
		
		try {
			test.doDangerousTask(102);
		} catch (OutOfRangeException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
	}
	
}
