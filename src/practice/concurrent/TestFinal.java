package practice.concurrent;

/**
 * final的属性必须在其初始化过程中完成赋值
 * @author paul
 * @version 2018年7月18日 下午12:40:57
 *
 *
 */
public class TestFinal {

	
	private final int num ;

	public TestFinal(int i ){
		this.num = i;
	}
	
	
	public int getNum() {
		return num;
	}
	
//	public void set(int i ){
//		this.num = i;
//	}
	
	
}
