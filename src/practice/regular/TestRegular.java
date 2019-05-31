package practice.regular;

public class TestRegular {

	public static void main(String[] args) {

		System.out.println("湖南省岳阳市华容县万庾镇杨家村null,null".replaceAll("([\\u4e00-\\u9fa5]+)(null)", "$2")); // null

		System.out.println("湖南省岳阳市华容县万庾镇杨家村null".replaceAll("([\\u4e00-\\u9fa5]+)(null)", "$1")); // 湖南省岳阳市华容县万庾镇杨家村

		
		//正则表达式的断言
		String name = "中国人民";
		String name1 = "中人民";
		String name2 = "人民";
		String name3 = "人AB民";
		System.out. println(name.replaceAll("(?<=.{1}).(?=.{1})", "*"));
		System.out.println(name1.replaceAll("(?<=.{1}).(?=.{1})", "*"));
		System.out.println(name2.replaceAll("(?<=.{1}).(?=.{1})", "*"));
		System.out.println(name3.replaceAll("(?<=.{1}).(?=.{1})", "*"));

		String mobile = "13123456789";
		String outMobile = mobile.replaceAll("(?<=\\d{3})\\d(?=\\d{3})", "*");
		System.out.println(outMobile);
		
		
		System.out.println("12,13".contains(""));
		System.out.println("".length());

	}

}
