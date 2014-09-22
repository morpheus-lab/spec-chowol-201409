package thread;

public class ThreadB extends Thread {
	
	public void run() {
		
		try {
			Thread.sleep((long) (Math.random() * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		synchronized (ThreadTest.MUTEX) {
			ThreadTest.deposit += 1000;
		}
		
	}
	
}
