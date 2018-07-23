package practice.concurrent;

/**
 * 学习并使用thread 的wait及notity方法
 *  首先调用当前线程持有锁，当调用wait后释放锁， 而sleep方法则不会释放锁
 * @author paul
 * @version 2018年7月23日 下午4:29:33
 *
 *
 */
public class TestThreadWait {

	public static void main(String[] args) {
		
		ThreadA thread = new ThreadA();
		
		System.out.println("main Thread begin");
		
		thread.start();
		
		synchronized (thread) {
			
			try {
				thread.wait(); //不是thread被阻塞，而是当前线程被阻塞
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		System.out.println("main Thread end");
			
	}
	
	
	static class ThreadA extends Thread{

		@Override
		public void run() {
			System.out.println(">>>>>> this is threadA >>>>>>>> ");
			
			try {
				
				for(int i = 0 ; i < 10; i++ ){
					Thread.sleep(1000);
					System.out.println(i);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				synchronized(this){
					this.notify();
				}
			}
			
			System.out.println("<<<<<<<< this is threadA <<<<<<<<<<<");
		}
	}
}
