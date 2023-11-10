package chat;


class MyThread extends Thread{
	private int i = 0;
	private boolean isRunning = true;
	
	public void run() {
		while(isRunning) {
			System.out.println(Thread.currentThread());
			if(i >= 1000) break;
			i++;
		}
	}

}
public class ThreadTest{ 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(Thread.currentThread());
//		MyThread t = new MyThread();
//		t.start();
//		
//		try {
//			Thread.sleep(1);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
//		System.out.println(Thread.currentThread());
		
		new MyThread() {
			private int i = 0;
			private boolean isRunning = true;
			
			public void run() {
				while(isRunning) {
					System.out.println(Thread.currentThread() + " " +i);
					if(i >= 1000) break;
					i++;
				}
			}
		}.start();
	}

	
}
