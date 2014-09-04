package exceptions;

public class ThrowTest {
	
	public void doDangerousTask(int i) throws Exception {
		
		// 일하다가
		
		// 위험 요소 발견 시, 또는 처리 불가할 때
		if (i < 0) {
			System.out.println("처리 불가~!!!");
			throw new Exception();
		}
		
		System.out.println("doDangerousTask(int) 끝~!!");
	}
	
	public static void main(String[] args) {
		
		ThrowTest test = new ThrowTest();
		
		try {
			test.doDangerousTask(-1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
