package practice.exception;

/**
 * 学习断言
 * 在Arguments页面中的 "VM Arguments" 中填入-ea选项
 */
public class TestAssert {


    public static void main(String args[]){

        String name = "abner chai";
//        String name = null;
        assert (name!=null):"变量name为空null";
        System.out.println(name);
    }
}
