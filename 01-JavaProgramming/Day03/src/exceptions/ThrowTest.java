package exceptions;

public class ThrowTest {
	
	public void doDangerousTask(int i) throws Exception {
		
		// ���ϴٰ�
		
		// ���� ��� �߰� ��, �Ǵ� ó�� �Ұ��� ��
		if (i < 0) {
			System.out.println("ó�� �Ұ�~!!!");
			throw new Exception();
		}
		
		System.out.println("doDangerousTask(int) ��~!!");
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
