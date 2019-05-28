package com.mycompany;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.CalculatorImp;
import static jdk.nashorn.internal.objects.Global.Infinity;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class CalculatorImpTest {

    private CalculatorImp calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new CalculatorImp();
    }

    @Test
    public void zeroTest() throws Exception {
        double result = calculator.calculate("0");
        assertEquals(0, result, 1e-9);
    }

    @Test
    public void FloatingPointTest() throws Exception {
        double result = calculator.calculate("-3000.02");
        assertEquals(-3000.02, result, 1e-9);
    }

    @Test
    public void addTest_1() throws Exception {
        double result = calculator.calculate("30.4/2");
        assertEquals(15.2, result, 1e-9);
    }

    @Test
    public void addTest_2() throws Exception {
        double result = calculator.calculate("(2+2)*1.5/10-444");
        assertEquals(-443.4, result, 1e-9);
    }

    @Test
    public void functionTest() throws Exception {
        double result = calculator.calculate("sin(1)*sin(1)+cos(1)*cos(1)");
        assertEquals(1, result, 1e-9);
    }
    
    @Test
    public void zeroDivision() throws Exception {
        double result = calculator.calculate("10/0");
        assertEquals(Infinity, result, 1e-9);
    }
}
