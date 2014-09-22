package thread;

public class ThreadA extends Thread {
	
	@Override
	public void run() {
		
		try {
			Thread.sleep((long) (Math.random() * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		synchronized (ThreadTest.MUTEX) {
			ThreadTest.deposit = 1000;
		}
		
	}
	
	public synchronized void foo() {
		
	}
	
	public void foo2() {
		synchronized (this) {
			
		}
	}
	
}
