package exceptions;

public class MyExceptionTest {

	public void doDangerousTask(int i) throws OutOfRangeException {
		
		// ...
		if (i < 0) {
			throw new OutOfRangeException("알 수 없는 오류 발생!!!");
		}
		else if (i > 100) {
			throw new OutOfRangeException("처리 가능 범위 벗어남");
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
