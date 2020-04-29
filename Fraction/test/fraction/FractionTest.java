/**
 * Author:      Martin Dwyer
 * Course:      ITEC 6130: Walden University
 * Assignment:  Unit 1
 * Date:        2019-03-06
 * 
 * Description: Build Fraction class and JUnit Testing class FractionTest
 *              Testing can be completed by running FractionText.java
 */
package fraction;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marti
 */
public class FractionTest {
    
    public FractionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    
    @Test               // @Test begins unit test of the constructor begins here
    public void testFraction() {
        Fraction result = null;             // Creates a null object in Fraction
        System.out.println("Arithmetic exception constructor test");
        try {
            result = new Fraction(4,0);
        } catch (ArithmeticException e) {
            
            // Constructor has rightly returned the arithmetic exception
            // Doing nothing here leaves the ojbect null
            
        }
        try {
            
            // From the JUnit Assert class, the assertNull will check to see if 
            // the object is still null.  If a non-null object has been created, 
            // the assertNull() method will produce an AssertionError. Test failed.
            assertNull("null constructor failed",result);  
            
        } catch (AssertionError e) {
            System.out.println("Test failed");
            throw e;
        }
        System.out.println("Test successful");
    }
    

    /**
     * Test of add method, of class Fraction.
     */
    @Test
    public void testAdd() {
        System.out.println("\nTesting add(Fraction(4,7),Fraction(1/9))");
        Fraction a = new Fraction(4,7);
        Fraction b = new Fraction(1,9);
        Fraction expResult = new Fraction((4*9 + 1*7),(7*9));
        Fraction result = Fraction.add(a, b);
        System.out.println("Expected Result: " + expResult.toString());
        System.out.println("         Result: " + result.toString());
        try {
            assertEquals("add() method fails",expResult, result);
        } catch (AssertionError e) {
            System.out.println("Test failed");
            throw e;
        }
        System.out.println("Test successful");
    }

    /**
     * Test of subtract method, of class Fraction.
     */
    @Test
    public void testSubtract() {
        System.out.println("\nTesting subtract(Fraction(4,7),Fraction(1/9))");
        Fraction a = new Fraction(4,7);
        Fraction b = new Fraction(1,9);
        Fraction expResult = new Fraction((4*9 - 1*7),(7*9));
        Fraction result = Fraction.subtract(a, b);
        System.out.println("Expected Result: " + expResult.toString());
        System.out.println("         Result: " + result.toString());
        try {
            assertEquals("subtract() method fails",expResult, result);
        } catch (AssertionError e) {
            System.out.println("Test failed");
            throw e;
        }
        System.out.println("Test successful");

    }

    /**
     * Test of multiply method, of class Fraction.
     */
    @Test
    public void testMultiply() {
        System.out.println("\nTesting multiply(Fraction(4,7),Fraction(1/9))");
        Fraction a = new Fraction(4,7);
        Fraction b = new Fraction(1,9);
        Fraction expResult = new Fraction(4*1,9*7);
        Fraction result = Fraction.multiply(a, b);
        System.out.println("Expected Result: " + expResult.toString());
        System.out.println("         Result: " + result.toString());
        try {
            assertEquals("multiply() method fails",expResult, result);
        } catch (AssertionError e) {
            System.out.println("Test failed");
            throw e;
        }
        System.out.println("Test successful");
    }

    /**
     * Test of divide method, of class Fraction.
     */
    @Test
    public void testDivide() {
        System.out.println("\nTesting divide(Fraction(4,7),Fraction(1/9))");
        Fraction a = new Fraction(4,7);
        Fraction b = new Fraction(1,9);
        Fraction expResult = new Fraction(4*9,1*7);
        Fraction result = Fraction.divide(a, b);
        System.out.println("Expected Result: " + expResult.toString());
        System.out.println("         Result: " + result.toString());
        try {
            assertEquals("divide() method fails",expResult, result);
        } catch (AssertionError e) {
            System.out.println("Test failed");
            throw e;
        }
        System.out.println("Test successful");
    }

    /**
     * Test of gcd method, of class Fraction.
     */
    @Test
    public void testGcd() {
        System.out.println("\nTesting gcd(7,28):");
        int expResult = 7;
        int result = Fraction.gcd(7,28);
        System.out.println("Expected Result: " + expResult);
        System.out.println("         Result: " + result);
        try {
            assertEquals("gcd() method fails",expResult, result);
        } catch (AssertionError e) {
            System.out.println("Test failed");
            throw e;
        }
        System.out.println("Test successful");
    }

     /**
     * Test of simplify method, of class Fraction.
     */
    @Test
    public void testSimplify() {
        System.out.println("\nTesting Fraction(8,24).simplify():");
        Fraction expResult = new Fraction(1,3);
        Fraction result = new Fraction(8,24).simplify();
        System.out.println("Expected Result: " + expResult);
        System.out.println("         Result: " + result);
        try {
            assertEquals("gcd() method fails",expResult, result);
        } catch (AssertionError e) {
            System.out.println("Test failed");
            throw e;
        }
        System.out.println("Test successful");
    }
    
    
    /**
     * Test of equals method, of class Fraction.
     */
    @Test
    public void testEquals() {
        System.out.println("\nTesting equals() method against Fraction(4,7)");
        Object obj = new Fraction(4,7);
        Fraction instance = new Fraction(4,7);
        boolean result = instance.equals(obj);
        boolean expResult = true;
        System.out.println("Expected Result: " + expResult);
        System.out.println("         Result: " + result);
        try {
            assertTrue("equals() method test failed",result);
        } catch (AssertionError e) {
            System.out.println("Test failed");
            throw e;
        }
        System.out.println("Test successful");
    }

    /**
     * Test of toString method, of class Fraction.
     */
    @Test
    public void testToString() {
        System.out.println("\nTesting toString() method with Fraction(4,7):");
        Fraction instance = new Fraction(4,7);
        String expResult = "4/7";
        String result = instance.toString();
        System.out.println("Expected Result: " + expResult);
        System.out.println("         Result: " + result);
        try {
            assertEquals("toString() method test fails",expResult, result);
        } catch (AssertionError e) {
            System.out.println("Test failed");
            throw e;
        }
        System.out.println("Test successful");
        
    }
    
}
