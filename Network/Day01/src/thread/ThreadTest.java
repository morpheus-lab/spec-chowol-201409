package thread;

public class ThreadTest {
	
	public static final Object MUTEX = new Object();
	
	public static int deposit = 0;
	
	public static void main(String[] args) throws InterruptedException {
		
		ThreadA ta = new ThreadA();
		ThreadB tb = new ThreadB();
		ThreadC tc = new ThreadC();
		
		ta.start();
		tb.start();
		tc.start();
		
		ta.join();
		tb.join();
		tc.join();
		
		System.out.println("DEPOSIT: " + deposit);
	}
	
}
