package practice.concurrent;

/**
 * 
 * 让父线程等待子线程结束之后才能继续运行
 * @author paul
 * @version 2018年7月23日 下午5:20:35
 *
 *
 */
public class TestThreadJoin {

	
	public static void main(String[] args) {
	
		ThreadA thread = new ThreadA();
		thread.start();   //进入runnable状态，并不代表立即执行
		
		for( int i = 0 ; i < 10; i++ ){
			System.out.println("main");
			if( i ==5){
				try {
					thread.join(); //待子线程执行完再执行主线程
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	static class ThreadA extends Thread{
		
		public void run(){
			
			for( int i = 0 ; i < 50; i++ ){
					
				   if( i % 5 == 0 ){
						try {
							Thread.sleep(800);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					System.out.println("I am produce " + i);
			}/*end loop for*/
		}
	}
}
