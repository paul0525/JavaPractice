package practice.lang;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestInnerClass {

	
	
		public  void main(String[] args) {

			System.out.println("begin");
			
		    ExecutorService executorService  = Executors.newFixedThreadPool(10);
		  
		    executorService.submit( new TestInnerClass.User() );    //如果是私有方法不会报错
			
			System.out.println("end");
		}
		
		
		class User implements Runnable{

			@Override
			public void run() {
				System.out.println("------ user running -----");
			}
		}
}
