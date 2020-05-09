package laureate;

import java.util.Random;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import data.DataInterface;

/**
 * This class is used to run tests for string operations methods used in the 
 * software application.  All methods here appear in the Application class
 * with the single exception of getCharAt( ), which is in StringTools
 *
 * @author Martin Dwyer
 */
public class StringOperations {

    private final PrintStream originalOut = System.out;

    /**
     * Test of charCount method, of class Application.
     */
    @Test
    public void testCharCount() {
        System.out.println("\n\033[34mTesting charCount() method from Application\033[0m");
        System.out.println("======================================================================");

        Application instance = new Application();
        ArrayList<String[]> testCases = DataInterface.charCount();
        String[] testCase = new String[3];
        String testTitle = "";
        String testInput = "";
        String expectedResult = "";
        String result = "";
        Boolean fail = false;

        for (int j = 0; j < testCases.size(); j++) {

            testCase = testCases.get(j);
            testTitle = testCase[0];
            testInput = testCase[1];
            expectedResult = testCase[2];

            System.out.println("======================================================================\n");
            System.out.println("Test Case " + (j + 1) + ": " + testTitle);
            System.out.println("... processsing test ...\n");

            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));

            instance.charCount(testInput);
            result = outContent.toString();

            System.setOut(originalOut);

            StringWriter expectedStringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(expectedStringWriter);

            printWriter.println(expectedResult);
            printWriter.close();
            String expected = expectedStringWriter.toString();

            if (expected.trim().equals(result.trim())) {
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
     * Test of invert method, of class Application.
     */
    @Test
    public void testInvertString() {
        System.out.println("\n\033[34mTesting invert() method from Application\033[0m");
        System.out.println("======================================================================");

        Application instance = new Application();
        ArrayList<String[]> testCases = DataInterface.invert();
        String[] testCase = new String[3];
        String testTitle = "";
        String testInput = "";
        String expectedResult = "";
        String result = "";
        Boolean fail = false;

        for (int j = 0; j < testCases.size(); j++) {

            testCase = testCases.get(j);
            testTitle = testCase[0];
            testInput = testCase[1];
            expectedResult = testCase[2];

            System.out.println("======================================================================\n");
            System.out.println("Test Case " + (j + 1) + ": " + testTitle);
            System.out.println("... processsing test ...\n");

            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));

            instance.invert(testInput);
            result = outContent.toString();

            System.setOut(originalOut);

            StringWriter expectedStringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(expectedStringWriter);

            printWriter.println(expectedResult);
            printWriter.close();
            String expected = expectedStringWriter.toString();

            if (expected.trim().equals(result.trim())) {
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
     * Test of subString method of class Application 
     *
     */
    @Test
    public void testSubString() {
       System.out.println("\n\033[34mTesting subString() method from Application\033[0m");
       System.out.println("======================================================================");

        Application instance = new Application();

        ArrayList<String[]> testCases = DataInterface.subStringTestData();
        for(String[] testCase: testCases) {
            System.out.println(testCase.length);
            System.out.println(testCase[0]);
        }
        
        String[] testCase = new String[4];
        String testTitle = "";
        String testDescription = "";
        String testInput = "";
        char testDelimiter = "0".charAt(0);
        String expectedResult = "";
        String result = "";
        String message = "";
        Boolean fail = false;

        for (int j = 0; j < testCases.size(); j++) {

            testCase = testCases.get(j);
            testTitle = testCase[0];
            testInput = testCase[1];
            testDelimiter = testCase[2].charAt(0);
            expectedResult = testCase[3];

            System.out.println("======================================================================\n");
            System.out.println("Test Case " + (j + 1) + ": " + testTitle);
            System.out.println("Description: " + testTitle + "\n");
            System.out.println("... processsing test ...\n");

            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));

            instance.subString(testInput, testDelimiter);
            result = outContent.toString();

            System.setOut(originalOut);

            StringWriter expectedStringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(expectedStringWriter);

            printWriter.println(expectedResult);
            printWriter.close();
            String expected = expectedStringWriter.toString();

            if (expected.trim().equals(result.trim())) {
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
     * Test of toLowercase method, of class Application.
     *
     */
    @Test
    public void testToLowerCase() {
        System.out.println("\n\033[34mTesting toLowercase() method from Application\033[0m");
        System.out.println("======================================================================");

        Application instance = new Application();
        ArrayList<String[]> testCases = DataInterface.toLowercase();
        String[] testCase = new String[3];
        String testTitle = "";
        String testInput = "";
        String expectedResult = "";
        String result = "";
        Boolean fail = false;

        for (int j = 0; j < testCases.size(); j++) {
            testCase = testCases.get(j);
            testTitle = testCase[0];
            testInput = testCase[1];
            expectedResult = testCase[2];

            System.out.println("======================================================================\n");
            System.out.println("Test Case " + (j + 1) + ": " + testTitle);
            System.out.println("... processsing test ...\n");

            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));

            instance.toLowercase(testInput);
            result = outContent.toString();

            System.setOut(originalOut);

            StringWriter expectedStringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(expectedStringWriter);
            printWriter.println(expectedResult);
            printWriter.close();
            String expected = expectedStringWriter.toString();

            if (expected.trim().equals(result.trim())) {
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
     * Test of vowelCase method, of class Application.
     *
     */
    @Test
    public void testVowelCase() {
        System.out.println("\n\033[34mTesting vowelCase() method from Application\033[0m");
        System.out.println("======================================================================");

        Application instance = new Application();
        ArrayList<String[]> testCases = DataInterface.vowelCase();
        String[] testCase = new String[3];
        String testTitle = "";
        String testInput = "";
        String expectedResult = "";
        String result = "";
        Boolean fail = false;

        for (int j = 0; j < testCases.size(); j++) {

            testCase = testCases.get(j);
            testTitle = testCase[0];
            testInput = testCase[1];
            expectedResult = testCase[2];

            System.out.println("======================================================================\n");
            System.out.println("Test Case " + (j + 1) + ": " + testTitle);
            System.out.println("... processsing test ...\n");

            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));

            instance.vowelCase(testInput);
            result = outContent.toString();

            System.setOut(originalOut);

            StringWriter expectedStringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(expectedStringWriter);
            printWriter.println(expectedResult);
            printWriter.close();
            String expected = expectedStringWriter.toString();

            if (expected.trim().equals(result.trim())) {
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
     * Test of uniqueOccurrences method, of class Application.
     *
     * Test case: stated case
     */
    @Test
    public void testUniqueOccurrences() {
        System.out.println("\n\033[34mTesting uniqueOccurrences() method from Application\033[0m");
        System.out.println("======================================================================");
        Application instance = new Application();

        ArrayList<String[]> testCases = DataInterface.uniqueOccurrences();
        String[] testCase = new String[4];
        String testTitle = "";
        String testDescription = "";
        String testInput = "";
        char testDelimiter = "0".charAt(0);
        String resultData;
        String[] expectedResult;
        String result;
        String[] resultArray;
        String message = "";
        Boolean fail = false;

        for (int j = 0; j < testCases.size(); j++) {

            testCase = testCases.get(j);
            testTitle = testCase[0];
            testInput = testCase[1];
            testDelimiter = testCase[2].charAt(0);
            resultData = testCase[3];

            System.out.println("======================================================================\n");
            System.out.println("Test Case " + (j + 1) + ": " + testTitle);
            System.out.println("Description: " + testTitle + "\n");
            System.out.println("... processsing test ...\n");

            // Capture the Result
            // Setting up output
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));

            instance.uniqueOccurrences(testInput, testDelimiter);
            result = outContent.toString();
            resultArray = result.split("\n");

            // Resetting input and output streams 
            System.setOut(originalOut);

            // Expected Result
            StringWriter expectedStringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(expectedStringWriter);

            printWriter.println(resultData);
            printWriter.close();
            expectedResult = expectedStringWriter.toString().split("\n");

            // conducting test
            for (int i = 0; i < expectedResult.length; i++) {
                if (expectedResult[i].trim().equals(resultArray[i].trim())) {

                } else {
                    if (fail == false) {
                        fail = true;
                    }
                    System.out.println("\033[31;1mTest fails for case: " + testTitle + ". \033[0m");
                    System.out.println("\033[31;1mExpected Result:\033[0m " + "\n" + expectedResult + "");
                    System.out.println("\033[31;1mActual Result:\033[0m " + "\n" + result + "");
                }
            }
            if (fail == false) {
                System.out.println("\033[32mResults as expected.  Test passes.\033[33m");
            }
            System.out.println("\n======================================================================");
        }
        if (fail == true) {
            Assert.fail("Method fails!  See console for details");
        } 
        
    }


    /**
     * Test of getCharAt method, of class StringTools.
     * Test case: 1000 char string, 100 random trials
     *
     */
    @Test
    public void testGetCharAt() {
        System.out.println("======================================================================");
        System.out.println("\n\033[34mTesting getCharAt() method from StringTools\033[0m");
        System.out.println("Test case: 1000 char string, 100 random trials");
        System.out.println("======================================================================\n");
        System.out.println("... processing tests ....");
        String stringInput = DataInterface.get1000CharString();
        StringTools instance = new StringTools(stringInput);
        Random rg = new Random();
        int index = 0;
        for (int i = 0; i < 100; i++) {
            index = rg.nextInt(1000);
            assertEquals(stringInput.charAt(index), instance.getCharAt(index));
        }
        System.out.println("\033[32mResults as expected.  Test passes.\033[33m");
        System.out.println("\n\n======================================================================\n");
    }
}
