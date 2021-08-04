package practice.regex;

public class TestReplace {

    public static void main(String[] args) {

        String str = "那2号女巫在想什么呢？\n想好了点击话   筒告诉我吧！\r\n太棒了！\n2号女巫在想什么？\n小朋友你可以大点声再说多一点吗？";

        System.out.println(str.replaceAll("\r|\n|\\s",""));
    }
}
