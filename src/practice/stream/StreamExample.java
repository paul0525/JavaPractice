package practice.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

/**
 * 流的学习
 * @author 126727
 *
 */
public class StreamExample {





	public static void main(String[] args) {

		int [] arrays = {1,2,4,3};

		IntStream intStream = Arrays.stream(arrays);

		intStream.sorted().forEach(b->System.out.println(b));


		List<String> list = new ArrayList<String>() {{
				add("wdong");
				add("paul");
		}};

		list.stream().sorted().forEach(b->System.out.println(b));



		List<UserInfo> listUsers = new ArrayList<UserInfo>() {{
			add(new UserInfo("paul",22));
			add(new UserInfo("dong",23));
			add(new UserInfo("dzg",24));
		}};

		List<UserInfo> listUsers2 = new ArrayList<UserInfo>() {{
			add(new UserInfo("paul",22));
			add(new UserInfo("dong",23));
		}};


		List<UserInfo> tmpList = listUsers.stream().sorted(comparing(UserInfo::getUserName)).collect(toList());

		System.out.println("========\n\n");
		tmpList.forEach(b->System.out.println(b.getUserName()));


		listUsers.stream().map(UserInfo::getAge).reduce(Integer::max).ifPresent(b->System.out.println("最大值:"+b));

		System.out.println(listUsers.stream().reduce((b,c)->b.getAge()>c.getAge()?b:c).get().getUserName());


		System.out.println( listUsers2.stream().allMatch(b->listUsers.contains(b)));

		System.out.println( listUsers.stream().allMatch(b->listUsers2.contains(b)));

		System.out.println( "Max:"+ tmpList.stream().max(comparing(UserInfo::getAge)).get().getUserName() ) ;

		listUsers.stream().mapToInt(UserInfo::getAge).boxed();


	}



	static class UserInfo{

		public UserInfo(String userName, int age) {
			super();
			this.userName = userName;
			this.age = age;
		}

		String userName;

		int age;

		public String getUserName() {
			return userName;
		}
		public int getAge() {
			return age;
		}

		@Override
		public int hashCode() {
			return Objects.hash(this.userName)^Objects.hash(this.age);
		}
		@Override
		public boolean equals(Object obj) {

			if(!(obj instanceof UserInfo)) return false;

			if(this == obj) return true;

			UserInfo tmp = (UserInfo)obj;

			if(this.getUserName().equals(tmp.getUserName()) && this.getAge()== tmp.getAge()) {
				return true;
			} else {
				return false;
			}

		}
	}


}
