package practice.regex;

public class TestRegex {

	
	
	public static void main(String args[]){
		
		String testStr = "广东省深圳市宝安区";
		
		System.out.println( testStr.replaceAll("省|市",""));
		System.out.println( testStr.replaceAll("(省|市|区)$","a"));
		System.out.println( testStr.replaceAll("省|市|区$","a"));
	}
}
