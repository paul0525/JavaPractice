package practice.util;

import java.util.HashMap;
import java.util.Map;


/**
 *  Eclipse快速删除未使用的 import
 *   Ctrl + shift + O
 * @param args
 */
public class TestLoopFor {

	
	public static void main(String[] args) {
		
		Map<Integer,String> map = new HashMap<Integer,String>();
	  
	  map.put(11, "11");
	  map.put(22, "22");
	  map.put(33, "33");
	  
	  //这里边有个自动拆箱？ 实际中还是不要写这么花哨的代码
	  for( int i : map.keySet()){
		  
		  System.out.println(i);
	  }
	  
	}
}
