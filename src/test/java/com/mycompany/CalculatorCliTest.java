/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import org.mockito.Mockito;
import java.io.StringReader;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import static org.mockito.Mockito.*;

/**
 *
 * @author user
 */
public class CalculatorCliTest {

    private Calculator calculatorMock;

    private CalculatorCli calculatorCli;

    @Before
    public void setUp() {

        calculatorMock = Mockito.mock(Calculator.class);
        calculatorCli = new CalculatorCli(calculatorMock);
    }

    @Rule
    public TestRule timeout = new Timeout(1, TimeUnit.MINUTES);

    @Test
    public void emptyExpressionsMustBeSkipped() {
        calculatorCli.runInteractiveSession(new StringReader(";\n; ;;;\t\n;"));
        Mockito.verifyZeroInteractions(calculatorMock);
    }

    public void eachExpressionSeparatedBySemicolonMustBeEvaluated() {
        calculatorCli.runInteractiveSession(new StringReader("1;2;3;"));

        verify(calculatorMock).calculate("1");
        verify(calculatorMock).calculate("2");
        verify(calculatorMock).calculate("3");
        verifyNoMoreInteractions(calculatorMock);
    }

    @Test
    public void eachExpressionSeparatedBySemicolonMustBeEvaluated_2() throws InterruptedException {
        //Thread.sleep(100);
        when(calculatorMock.calculate("1")).thenReturn(1d);
        when(calculatorMock.calculate("2")).thenReturn(2d);
        when(calculatorMock.calculate("3")).thenReturn(3d);

        calculatorCli.runInteractiveSession(new StringReader("1;2;3;"));
        verify(calculatorMock).calculate("1");
        verify(calculatorMock).calculate("2");
        verify(calculatorMock).calculate("3");
        verifyNoMoreInteractions(calculatorMock);
    }

}
