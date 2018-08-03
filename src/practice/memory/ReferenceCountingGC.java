package practice.memory;


/**
 *  testGC()方法后，objA和objB会不会被GC呢？
 * @author paul
 * @version 2018年8月1日 上午10:48:43
 *
 *
 */
public class ReferenceCountingGC {

	
	public Object instance = null;
	
	private static final int _1MB = 1024 * 1024;
	
	private byte[] bigSize = new byte[2*_1MB];
	
	public static void testGC(){
		
		ReferenceCountingGC objA = new ReferenceCountingGC();
		ReferenceCountingGC objB = new ReferenceCountingGC();
		
		objA.instance = objB;
		objB.instance = objA;
		
		objA = null;
		objB = null;
		
		//假设在这里发生GC，哪么objA和objB是否被收回？
		System.gc();
	}
	
	
	public static void main(String[] args) {
		
		testGC();
	}
}
