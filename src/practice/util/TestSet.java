package practice.util;

import java.util.HashSet;

/**
 * java SE 中关于集合的操作： 求交集、并集、差集
 * 
 * 不知道性能怎么样？
 * 
 */

public class TestSet {

	public static void main(String[] args) {
		
		testSet();
	}

	private static void testSet() {
		
		HashSet<String> set1 = new HashSet<String>(){{
			add("aa");
			add("bb");
			add("cc");
			add("dd");
		}};
		
		
		HashSet<String> set2 = new HashSet<String>(){{
			add("aa");
			add("bb");
			add("ee");
			add("ff");
		}};
		
		HashSet<String> result = new HashSet<String>();
		result.addAll(set1);
		result.addAll(set2);
		System.out.println("并集："+ result);
		
		result.clear();
		result.addAll(set1);
		result.retainAll(set2);
		System.out.println("交集：" + result );

		result.clear();
		result.addAll(set1);
		result.removeAll(set2);
		System.out.println("差集：" + result );
	}
	
}
