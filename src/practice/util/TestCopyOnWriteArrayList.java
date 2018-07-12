package practice.util;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;

import practice.lang.UserInfo;

public class TestCopyOnWriteArrayList {

	
	public static void main(String[] args) {
	
		Semaphore semaphore = new Semaphore(0);
		
		CopyOnWriteArrayList<UserInfo> userInfoList = new CopyOnWriteArrayList<UserInfo>(){{
				 add(new UserInfo(1001, "paul_1", "123456"));
				 add(new UserInfo(1002, "paul_2", "123456"));
				 add(new UserInfo(1003, "paul_3", "123456"));
				 add(new UserInfo(1004, "paul_4", "123456"));
		}};
		
		
	   new Thread(){
		@Override
		public void run() {
			
			System.out.println(">>> add thread>>>>");
			
			try {
				Thread.currentThread().sleep(2000l);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			userInfoList.add( new UserInfo(1005, "paul_5", "123456"));
			semaphore.release();
			
			System.out.println(">>> out thread>>>>");
		}
	   }.start();
	 
	   
	 new Thread( new Runnable() {
		public void run() {
			System.out.println(">>> add thread>>>>");
			
			try {
				Thread.currentThread().sleep(2000l);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			userInfoList.add( new UserInfo(1005, "paul_6", "123456"));
			semaphore.release();
			
			System.out.println(">>> out thread>>>>");
		}
	}).start();
	 
	 try {
		semaphore.acquire(2);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 for( UserInfo user : userInfoList){
		 System.out.printf("userName:%s\n",user.getUserName());
	 }
	 
	}
}
