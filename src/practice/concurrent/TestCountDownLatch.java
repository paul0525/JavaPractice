package practice.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCountDownLatch {
	
	
	static ExecutorService  executorService = Executors.newCachedThreadPool();
	
	
	public static void main(String args[]){
		
		int nThread = 10;
		CountDownLatch countDownLatch = new CountDownLatch(nThread);
		for(int i = 0; i < nThread; i++ ){
			final int temp = i;
			executorService.submit(()->{release(temp,countDownLatch);});
		}
		
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(".....end");
	}
	
	
	public static void release( final int i , CountDownLatch countDownLatch){
		System.out.println( ">>> "+ i);
		countDownLatch.countDown();
	}

}
