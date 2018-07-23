package practice.lang;

public class TestProgram {

	
	public static void main(String[] args) {
		
		UserInfo user1 = new UserInfo("abc",18);
		UserInfo user2 = new UserInfo("abc",18);
		
		int user1Hash = System.identityHashCode(user1);
		int user2Hash = System.identityHashCode(user2);
		
		System.out.println( user1Hash == user2Hash );
		System.out.println( user1Hash );
		System.out.println( user2Hash );
		System.out.println( user1.hashCode() );
		System.out.println( user2.hashCode() );
	}
	
	static class UserInfo{
		
		private String userName;
		private int age;
		
		public UserInfo(String userName, int age) {
			super();
			this.userName = userName;
			this.age = age;
		}
		
	}
}
