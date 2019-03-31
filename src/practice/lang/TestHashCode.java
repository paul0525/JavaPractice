package practice.lang;

import java.util.HashMap;
import java.util.Objects;

/**
 *   hashcode的比较
 * @author 126727
 *
 */
public class TestHashCode {
	
	
	static class UserInfo{
		
		
		public UserInfo(String userName, int age, String pwd) {
			super();
			this.userName = userName;
			this.age = age;
			this.pwd = pwd;
		}


		String userName;
		int age;
		String pwd;
		
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
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		
		public int hashCode() {
			return Objects.hashCode(userName)^Objects.hashCode(age);
		}
		
		
		public boolean equals(Object obj) {
		
			if( !(obj instanceof UserInfo )) return false;
			
			if( this == obj) return true;
			
			UserInfo userInfo = (UserInfo)obj;
			
			if(this.userName.equals(userInfo.getUserName()) && this.age == userInfo.getAge())
				return true;
			else {
				return false;
			}
			
		}
	}/* end class UserInfo*/
	
	
	public static void main(String[] args) {
		
		HashMap<String,UserInfo> map = new HashMap<>();
		
		UserInfo user1 = new UserInfo("paul",12,"123456");
		UserInfo user2 = new UserInfo("paul",12,"123456");
		
		if(user1 == user2) {
			System.out.println("it is equals");
		}
		
		if(user1.equals(user2)) {
			System.out.println("it is equals2");
		}
		
		map.put(user1.getUserName(), user1);
		map.put(user2.getUserName(), user2);
		
	}

}
