package practice.util;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Collections;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import practice.lang.UserInfo;


public class TestCollections {

	public static void main(String[] args) {
		
		final UserInfo user = new UserInfo(123, "paul", "1024");

		System.out.println(user.toString());
		 
//		user =  new UserInfo(123, "paul", "1024");   这里也会报错，因为已经赋过值了
		
		Map<String,String> map = new HashMap<String,String>(){{
			put("aa", "aa");
			put("bb", "bb");
			put("cc", "cc");
		}};
		
		Map<String,String> tmpMap = Collections.unmodifiableMap(map);
		
		tmpMap.put("dd", "dd");   //这里会报
		
		System.out.println( tmpMap.size() );
		
		
		ConcurrentHashMap<String,String> map1 = new ConcurrentHashMap<String,String>();   //thread-safe 
		
		HashMap<String,String> map2 = new HashMap<String,String>();   //基于链表的实现，单向的next
		
		Hashtable<String,String> map3 = new Hashtable<String,String>();   //基于数组实现， 线程安全
		
		LinkedHashMap<String,String> map4;  //double link 双向链表 
		
		TreeMap<String,String> map5;       //基于二叉树实现 ，已排序
		
		
	}
}
