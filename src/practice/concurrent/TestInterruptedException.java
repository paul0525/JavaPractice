package practice.concurrent;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * ArrayBlockingQueue的interruptedException由线程的退出而引发
 * @author paul
 * @version 2018年7月19日 下午4:11:58
 *
 *
 */
public class TestInterruptedException {

	
	public static void main(String[] args) {
		
		ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
		
		Thread t1 = new Thread(){
			
			int count = 0;
				
			@Override
			public void run() {
				while(!this.isInterrupted()){
					count++;
					try {
						System.out.println("1111");
						queue.put(count+"");
						System.out.println(count);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						break;
					}
				}
			}/*end the run method */
			
		};/*end  anonymous class */
		
		t1.start();
		System.out.println(System.currentTimeMillis());
		t1.interrupt();
		try {
			Thread.sleep(10000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis());
		
//		System.exit(0);
	}
}
