/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Random;

/**
 *
 * @author marti
 */
public class CalculatorLogicTest {

    /**
     * Test of process method, of class CalculatorLogic.
     */
    @Test
    public void testProcess() {
        Random r = new Random();

        System.out.println("Testing process() method from CalculatorLogic");
        CalculatorLogic instance = new CalculatorLogic();
        instance.setEventString("4+9-5*6/4");

        System.out.println("Testing 'c' (clear event string)");
        String expResult = "";
        String result = instance.process('c');
        assertEquals("Clear button fails", expResult, result);

        System.out.println("Testing 'e' (clear last entered item)");
        instance.setEventString("4+9-5*6/4");
        expResult = "4+9-5*6/";
        result = instance.process('e');
        assertEquals("Clear entry fails", expResult, result);

        System.out.println("Testing 'n' (changing sign)");
        instance.setEventString("4+9-5*6/4");
        expResult = "-4+9-5*6/4";
        result = instance.process('n');
        assertEquals("Change sign button fails", expResult, result);

        System.out.println("Testing default (adding char to event string)");
        instance.setEventString("4+9-5*6/4");
        expResult = "4+9-5*6/45";
        result = instance.process('5');
        assertEquals("Adding char fails", expResult, result);

        System.out.println("Testing for '=' entered (calculate result)");
        System.out.println("Testing addition of two integers n1,n2");
        int n1 = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        // Testing addition
        for (int i = 0; i < 500; i++) {
            n1 = r.nextInt(1000);
            n2 = r.nextInt(1000);
            String s = "" + n1 + "+" + n2;
            instance.setEventString(s);
            expResult = "" + n1 + "+" + n2 + " = " + (n1 + n2);
            result = instance.process('=');
            assertEquals("addition fails", expResult, result);
        }
        System.out.println("On '=' addition passes for two random integers (500 tries)");

        // Testing subtraction
        for (int i = 0; i < 500; i++) {
            n1 = r.nextInt(1000);
            n2 = r.nextInt(1000);
            String s = "" + n1 + "-" + n2;
            instance.setEventString(s);
            expResult = "" + n1 + "-" + n2 + " = " + (n1 - n2);
            result = instance.process('=');
            assertEquals("subtraction fails", expResult, result);
        }
        System.out.println("On '=' subtraction passes for two random integers (500 tries)");

        // Testing multiplication
        for (int i = 0; i < 500; i++) {
            n1 = r.nextInt(1000);
            n2 = r.nextInt(1000);
            String s = "" + n1 + "*" + n2;
            instance.setEventString(s);
            expResult = "" + n1 + "*" + n2 + " = " + (n1 * n2);
            result = instance.process('=');
            assertEquals("multiplication fails", expResult, result);
        }
        System.out.println("On '=' multiplication passes for two random integers (500 tries)");

        // Testing division
        for (int i = 0; i < 500; i++) {
            n1 = r.nextInt(1000);
            n2 = r.nextInt(1000) + 1;
            String s = "" + n1 + "/" + n2;
            instance.setEventString(s);
            expResult = "" + n1 + "/" + n2 + " = " + (n1 / n2);
            result = instance.process('=');
            assertEquals("division fails", expResult, result);
        }
        System.out.println("On '=' division passes for two random integers (500 tries)");

    }

}
