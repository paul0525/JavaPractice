package practice.concurrent;

/**
 * 学习并使用Thread.yield,
 * 使线程进入就绪状态
 * @author paul
 * @version 2018年7月23日 下午5:09:06
 *
 *
 */
public class TestThreadYield {

	
	public static void main(String[] args) {
		ThreadA thread = new ThreadA();
		thread.start();
		
		for(int i =0 ; i < 50; i++ ){
			System.out.println("main produce " + i);
		}
		
	}
	
	
	static class ThreadA extends Thread{
	
		public void run(){
			
			for( int i = 0 ; i < 50; i++ ){
				
				if(i%3==0){
					Thread.yield();
					System.out.println(">>> yield ");
				}else{
//					System.out.println("I am produce " + i);
				}
			}/*end loop for*/
		}
	}
	
}
