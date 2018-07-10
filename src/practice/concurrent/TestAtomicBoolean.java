package practice.concurrent;

import java.util.concurrent.atomic.AtomicBoolean;

public class TestAtomicBoolean {

	/**
	 * 注意ABA问题
	 */
	
	private static final AtomicBoolean atomicBoolean = new AtomicBoolean(); 
	
	public static void main(String[] args) {
		
		for( int i = 0; i < 3; i++){
			new TestThread("test-thread-"+ i).start();
		}
	}
	
	
	private static class TestThread extends Thread{
		
		TestThread(String name){
			super(name);
		}

		@Override
		public void run() {

			boolean flag = atomicBoolean.get();
			
			System.out.println(flag);
			
			while( atomicBoolean.compareAndSet(flag, true)){
				
				System.out.println("hello:"+Thread.currentThread().getName());
				
				try {
					Thread.currentThread().sleep(5000l);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				atomicBoolean.set(false);
			}
			
			System.out.println(Thread.currentThread().getName()+" is end..");
			
		}/**end run method**/
	}

}
