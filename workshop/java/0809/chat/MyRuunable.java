package chat;

public class MyRuunable implements Runnable{
	private int i = 0;
	private boolean isRunning = true;
	
	public void stopRun() {
		isRunning = false;
	}
	public void run() {
		while(isRunning) {
			System.out.println(Thread.currentThread() + " " + i);
			if(i >= 100) break;
			i++;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread() + "start");
//		MyRuunable t = new MyRuunable();
//		Thread d = new Thread(t);
//		d.start();
//		
//		try {
//			Thread.sleep(1);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		new Thread() {
			private int i = 0;
			private boolean isRunning = true;
			
			public void stopRun() {
				isRunning = false;
			}
			
			public void run() {
				while(isRunning) {
					System.out.println(Thread.currentThread() + " " + i);
					if(i >= 100) break;
					i++;
				}
			}
		}.start();
	
		System.out.println(Thread.currentThread() + "end");
	}

}
