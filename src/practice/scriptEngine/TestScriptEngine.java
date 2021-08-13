package practice.scriptEngine;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * 测试脚本引擎
 */
public class TestScriptEngine {


    public static void main(String[] args) {

        expressResult(" 3==3");
        expressResult(" (1+3)==3");
        expressResult("'a'=='a'");
        expressResult("'a'+'a'");
        expressResult("i=3;i<=3");
        expressResult("a='abc'; a.length==3");

    }


    public static void  expressResult(String expr){

        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine enginer = mgr.getEngineByName("javascript");
        try{
            Object temp =  enginer.eval(expr);
            System.out.println(String.format("===== express:%s,result:%s =======", expr, temp.toString()));
        }catch(ScriptException e){
            e.printStackTrace();
        }
    }
}
