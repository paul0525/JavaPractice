package practice.util;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeMap;

/**
 * 
 * @author paul
 * @version 2018年7月15日 上午9:24:16
 * 
 *  最近在看算法和数据结构
 *  这个类主要展示二叉树
 *  没找到java对图的实现
 */
public class TestMap {

	public static void main(String[] args) {
		
		//实现了 red-black tree.  key一定要实现comparator接口
		TreeMap<String,String> treeMap = new TreeMap<String,String>();
		
		treeMap.put("bc", "bc");
		treeMap.put("dbc", "dbc");
		treeMap.put("abc", "abc");
		treeMap.put("fbc", "fbc");
		treeMap.put("zbc", "zbc");
		
		//打印(注意treeMap本身就是有充序的)
		show(treeMap);
		
		//基于链表的形式实现
		HashMap<String,String> hashMap = new HashMap<String,String>();
		
		//里边有个entry数组，Thread-safe
		Hashtable<String,String> hashTable = new Hashtable<String,String>();
		
		
	}

	private static void show(TreeMap<String, String> treeMap) {
		for( String key :  treeMap.keySet()){
			System.out.println(treeMap.get(key));
		}
	}
}
