package laureate;

import DataBuilder.Database;
import data.DataInterface;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.junit.Assert;

/**
 * This class is used to run tests for methods in the User Interface including
 * the go( ) method which generates the main menu, the askForString( ) method
 * which prompts the user for a string, and the askForWordDelimiter( ) method
 * which asks for a single character string
 *
 * @author Martin Dwyer
 */
public class UserInterface {

    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    /**
     * Test of go{ } method, of class Application.
     */
    @Test
    public void testGo() {
        System.out.println("\n\033[34mTesting go() method from Application\033[0m");        
        System.out.println("======================================================================");
        Application instance = new Application();

        // Get data from external source
        ArrayList<String[]> testCases = DataInterface.go();
        String[] testCase = new String[4];
        String testTitle = "";
        String testDescription = "";
        String testInput = "";
        String expectedResult = "";
        String message = "";
        Boolean fail = false;

        for (int j = 0; j < testCases.size(); j += 1) {
            testCase = testCases.get(j);
            testTitle = testCase[0];
            testDescription = testCase[1];
            testInput = testCase[2];
            expectedResult = testCase[3];

            System.out.println("======================================================================\n");
            System.out.println("Test Case " + (j + 1) + ": " + testTitle);
            System.out.println("Description: " + testDescription + "\n");
            System.out.println("... processsing test ...\n");
            String val = testInput;

            // Setting up input stream
            ByteArrayInputStream inContent = new ByteArrayInputStream(val.getBytes());

            System.setIn(inContent);

            // Capture the Result
            // Setting up output
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();

            System.setOut(new PrintStream(outContent));

            instance.go();

            // Resetting input and output streams 
            System.setOut(originalOut);

            System.setIn(originalIn);

            // Expected Result
            StringWriter expectedStringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(expectedStringWriter);
            printWriter.println(expectedResult);
            printWriter.close();

            // Preparing string output for comparison
            String expected = expectedStringWriter.toString().trim().replaceAll("[^a-zA-Z0-9_-]", "");
            String actual = outContent.toString().trim().replaceAll("[^a-zA-Z0-9_-]", "");

            // conducting test
            if (expected.equals(actual)) {
                message = "Testing passes for go(): " + testTitle;
                assertTrue(message, true);
                System.out.println("\033[32mResults as expected.  Test passes.\033[33m");
            } else {
                if (fail == false) {
                    fail = true;
                }
                System.out.println("\033[31;1mTest fails for case: " + testTitle + "  \033[0m");
                System.out.println("\033[31;1mExpected Result:\033[0m " + "\n" + expected + "");
                System.out.println("\033[31;1mActual Result:\033[0m " + "\n" + actual + "");
            }
            System.out.println("\n======================================================================");

        }
        if (fail == true) {
            Assert.fail("Method fails!  See console for details");
        }
    }

    /**
     * Test of askForString{ } method, of class Application.
     */
    @Test
    public void testAskForString() {
        ArrayList<String[]> testCases = DataInterface.askForString();
        System.out.println("\n\033[34mTesting askForString() method from Application\033[0m");
        System.out.println("======================================================================");
        Application instance = new Application();
        String[] testCase = new String[4];
        String testTitle = "";
        String testDescription = "";
        String testInput = "";
        String expectedResult = "";
        String result = "";
        String message = "";
        Boolean fail = false;

        for (int j = 0; j < testCases.size(); j++) {

            testCase = testCases.get(j);
            testTitle = testCase[0];
            testDescription = testCase[1];
            testInput = testCase[2];
            expectedResult = testCase[3];

            System.out.println("======================================================================\n");

            System.out.println("Test Case " + (j + 1) + ": " + testTitle);
            System.out.println("Description: " + testDescription + "\n");
            System.out.println("... processsing test ...\n");
            String val = testInput;
            String var = testInput + "\n";
            ByteArrayInputStream stringStream = new ByteArrayInputStream(var.getBytes());
            BufferedReader br = new BufferedReader(new InputStreamReader(stringStream));
            String stringResponse = null;
            result = instance.askForString(br);

            // conducting test
            if (expectedResult.equals(result)) {
                System.out.println("\033[32mResults as expected.  Test passes.\033[33m");
            } else {
                if (fail == false) {
                    fail = true;
                }
                System.out.println("\033[31;1mTest fails for case: " + testTitle + "  \033[0m");
                System.out.println("\033[31;1mExpected Result:\033[0m " + "\n" + expectedResult + "");
                System.out.println("\033[31;1mActual Result:\033[0m " + "\n" + result + "");
            }
            System.out.println("\n======================================================================");

        }
        if (fail == true) {
            Assert.fail("Method fails!  See console for details");
        }
    }

    /**
     * Test of askForWordDelimiter{ } method, of class Application.
     */
    @Test
    public void testAskForWordDelimiter() {

        ArrayList<String[]> testCases = DataInterface.askForChar();

        System.out.println("\n\033[34mTesting askForDelimiter() method from Application\033[0m");
        System.out.println("======================================================================");

        Application instance = new Application();
        String[] testCase = new String[4];
        String testTitle = "";
        String testDescription = "";
        String testInput = "";
        char expectedResult = " ".charAt(0);
        char result = " ".charAt(0);
        String message = "";
        Boolean fail = false;

        for (int j = 0; j < testCases.size(); j++) {
            testCase = testCases.get(j);
            testTitle = testCase[0];
            testDescription = testCase[1];
            testInput = testCase[2];
            expectedResult = testCase[3].charAt(0);

            System.out.println("======================================================================\n");
            System.out.println("Test Case " + (j + 1) + ": " + testTitle);
            System.out.println("Description: " + testDescription + "\n");
            System.out.println("... processsing test ...\n");
            String val = testInput;
            String var = testInput + "\n";
            ByteArrayInputStream stringStream = new ByteArrayInputStream(var.getBytes());
            BufferedReader br = new BufferedReader(new InputStreamReader(stringStream));
            result = instance.askForWordDelimiter(br);

            // conducting test
            if (expectedResult == result) {
                System.out.println("\033[32mResults as expected.  Test passes.\033[33m");
            } else {
                if (fail == false) {
                    fail = true;
                }
                System.out.println("\033[31;1mTest fails for case: " + testTitle + "  \033[0m");
                System.out.println("\033[31;1mExpected Result:\033[0m " + "\n" + expectedResult + "");
                System.out.println("\033[31;1mActual Result:\033[0m " + "\n" + result + "");
            }
            System.out.println("\n======================================================================");

        }
        if (fail == true) {
            Assert.fail("Method fails!  See console for details");
        }

    }
}
