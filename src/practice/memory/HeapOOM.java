package practice.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * 
 * @author paul
 * @version 2018年8月1日 上午10:55:10
 *
 *
 */
public class HeapOOM {

	public static void main(String[] args) {
		
		List<OOMObject> list = new ArrayList<OOMObject>(); 
		
		while(true){
			list.add(new OOMObject());
		}
	}
	
	static class OOMObject{
		
	}
}
