package practice.algorithm;

/**
 * 把二维数组转为一维数组，并获得某一个值
 *
 */
public class Test01 {


    public static void main(String[] args) {

        String[][] arrStr = {{"aaa","bbb","ccc"},{"aaa01","bbb01","ccc01"},{"aaa02","bbb02","ccc02"},{"aaa03","bbb03","ccc03"}};


        int total = arrStr.length * arrStr[0].length;

        int myTotal = 3;

        int row = myTotal / arrStr[0].length;

        int column = (myTotal + arrStr[0].length)%arrStr[0].length;

        //注意 index 从00开始
        System.out.println(arrStr[row][column]);

    }
}
