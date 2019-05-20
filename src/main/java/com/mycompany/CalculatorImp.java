/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author user
 */
public class CalculatorImp implements Calculator {

    @Override
    public double calculate(String expression) {
        //return 0;
        //return Double.parseDouble(expression);

        // throw new UnsupportedOperationException();
        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
        try {
            defineMathFunctions(scriptEngine);
            return ((Number) scriptEngine.eval(expression)).doubleValue();

        } catch (ScriptException e) {
            throw new IllegalArgumentException("Failed to evaluate expression", e);

        }

    }

//    private static void defineMathFunction(ScriptEngine scriptEngine) throws ScriptException {
//        for (String function : new String[] {"sin", "cos", "sqrt"}){
//           scriptEngine.eval("function" + function + "(x) { return Java.type('java.lang.Math')." +function + "(x); }");
//           
//        }
//        
//    }
    private static void defineMathFunctions(ScriptEngine scriptEngine) throws ScriptException {
        for (String function : new String[]{"sin", "cos", "sqrt"}) {
            scriptEngine.eval("function " + function + "(x) { return Java.type('java.lang.Math')." + function + "(x); }");
        }
    }
}
