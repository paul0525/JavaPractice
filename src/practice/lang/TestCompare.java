package practice.lang;

import java.util.Arrays;
import java.util.Comparator;

public class TestCompare {

	
	public static void main(String[] args) {
		
		UserInfo[] arrayUserInfo = new UserInfo[5];
		
		
		arrayUserInfo[0] = new UserInfo(2, "Paul", "123456");
		arrayUserInfo[1] = new UserInfo(1, "APaul", "123456");
		arrayUserInfo[2] = new UserInfo(5, "BPaul", "123456");
		arrayUserInfo[3] = new UserInfo(6, "DPaul", "123456");
		arrayUserInfo[4] = new UserInfo(4, "FPaul", "123456");
		
		
		Arrays.sort(arrayUserInfo, new Comparator<UserInfo>() {

			@Override
			public int compare(UserInfo o1, UserInfo o2) {
				
				if(o1.getUserId()<o2.getUserId()) return -1;
				if(o1.getUserId()>o2.getUserId()) return 1;
				return 0;
			}
		});
		
		showUserInfo(arrayUserInfo);
		
		System.out.println();
		
		Arrays.sort(arrayUserInfo, new Comparator<UserInfo>(){

			@Override
			public int compare(UserInfo o1, UserInfo o2) {
				// TODO Auto-generated method stub
				return o1.getUserName().compareTo(o2.getUserName());
			}
			
		});
		
		showUserInfo(arrayUserInfo);
	}

	private static void showUserInfo(UserInfo[] arrayUserInfo) {
		UserInfo user=null;
		for( int i =0; i < arrayUserInfo.length; i++ ){
			user =arrayUserInfo[i];
			System.out.printf("index:%d -- id:%d,userName:%s\n",i,user.getUserId(), user.getUserName());
		}
	}
}
