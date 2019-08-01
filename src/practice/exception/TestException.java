package practice.exception;


import java.util.Objects;

public class TestException {


    public static void main(String args[]){

        System.out.println("begin");
        validate(args);
        System.out.println("end");

    }

    public static void validate(String[] args){

        if(Objects.isNull(args) || args.length <=0){
            throw  new NullPointerException("args");
//            throw  new Exception("xxx");
        }
    }

    public class User{

        protected  String name ;
        protected  String abc;

        public User() throws  Exception {
        }
    }
}
