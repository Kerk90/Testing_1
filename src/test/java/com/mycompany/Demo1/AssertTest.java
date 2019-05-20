/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Demo1;

import static org.junit.Assert.assertEquals;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author user
 */
public class AssertTest {

    @Test
    @Ignore
    public void substring() {
        assertEquals("llo", "Hello".substring(3));
    }

    @Test
    public void demo_test() {
        assertEquals("Hello", "Hel" + "lo");
        assertEquals(
                1.0,
                1d / 3 + 1d / 3 + 1d / 3,
                1e-10);

    }
}
