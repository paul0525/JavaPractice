package practice.concurrent;

/**
 * 学习并使用threadLocal
 * @author paul
 *
 */
public class TestThreadLocal {

	
	
	private static final ThreadLocal<User> userLocal = new ThreadLocal<>();
	
	
	
	public static void main(String[] args) {
		
		
		for( int i =0; i < 3; i++) {
			new ThreadUser().start();
		};
		
	}
	
	
	
	public static User getUserThreadLocal() {
		
		User user = userLocal.get();
		
		if( null == user ) {
			System.out.println("create user");
			userLocal.set(new User());
		}
		
		return userLocal.get();
	}
	
	
	private static class ThreadUser extends Thread {

		@Override
		public void run() {
//			System.out.println( TestThreadLocal.getUser());
			System.out.println( TestThreadLocal.getUserThreadLocal());
		}
	} 
	
	
	private static class User{
		
		
		private String userName;
		private int age;
		
		
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		
	}
	
}
