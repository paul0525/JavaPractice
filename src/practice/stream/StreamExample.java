package practice.stream;

import java.util.Arrays;

public class StreamExample {

	
	
	public static void main(String[] args) {
		
		
		String str = "Hello";
		
		String [] arrStr = str.split("");   //这样可以分隔单词
		
//		for( String tmp : arrStr){
//			System.out.println(tmp);
//		}
		
		//利用stream迭代
		Arrays.stream(arrStr).forEach(s-> System.out.println(s));
		
		Arrays.stream(arrStr).map(s->{System.out.println(s); return s+"01";});
	
		
	}
}
