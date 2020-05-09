/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBuilder;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

/**
 *
 * @author marti
 */
public class CharCountTestData {

    public static ArrayList<String[]> getTestData() {

        ArrayList<String[]> testData = new ArrayList<String[]>();

        String[] caseTwo = new String[3];
        caseTwo[0] = "White space string";
        caseTwo[1] = " ";

        // Expected Result
        StringWriter expectedStringWriter2 = new StringWriter();
        PrintWriter printWriter2 = new PrintWriter(expectedStringWriter2);

        printWriter2.println("Alphabetic: 0");
        printWriter2.println("Numeric: 0");
        printWriter2.println("Other: 1");
        printWriter2.close();
        String expected2 = expectedStringWriter2.toString();

        caseTwo[2] = expected2;

        
        testData.add(caseTwo);

        String[] caseThree = new String[3];
        caseThree[0] = "Empty string";
        caseThree[1] = " ";

        // Expected Result
        StringWriter expectedStringWriter3 = new StringWriter();
        PrintWriter printWriter3 = new PrintWriter(expectedStringWriter3);

        printWriter3.println("Alphabetic: 0");
        printWriter3.println("Numeric: 0");
        printWriter3.println("Other: 0");
        printWriter3.close();
        String expected3 = expectedStringWriter3.toString();

        caseThree[2] = expected3;

        testData.add(caseThree);

        String[] caseOne = new String[3];
        caseOne[0] = "One thousand char string";
        caseOne[1] = "!#$%& '()*+,-./ 0123456789 :;<=>?@ ABCDEFGHIJKLMNOPQRSTUVWXYZ []^_` abcdefghijklmnopqrstuvwxyz {|}~ !#$%& '()*+,-./ 0123456789 :;<=>?@ ABCDEFGHIJKLMNOPQRSTUVWXYZ []^_` abcdefghijklmnopqrstuvwxyz {|}~ !#$%& '()*+,-./ 0123456789 :;<=>?@ ABCDEFGHIJKLMNOPQRSTUVWXYZ []^_` abcdefghijklmnopqrstuvwxyz {|}~ !#$%& '()*+,-./ 0123456789 :;<=>?@ ABCDEFGHIJKLMNOPQRSTUVWXYZ []^_` abcdefghijklmnopqrstuvwxyz {|}~ !#$%& '()*+,-./ 0123456789 :;<=>?@ ABCDEFGHIJKLMNOPQRSTUVWXYZ []^_` abcdefghijklmnopqrstuvwxyz {|}~ !#$%& '()*+,-./ 0123456789 :;<=>?@ ABCDEFGHIJKLMNOPQRSTUVWXYZ []^_` abcdefghijklmnopqrstuvwxyz {|}~ !#$%& '()*+,-./ 0123456789 :;<=>?@ ABCDEFGHIJKLMNOPQRSTUVWXYZ []^_` abcdefghijklmnopqrstuvwxyz {|}~ !#$%& '()*+,-./ 0123456789 :;<=>?@ ABCDEFGHIJKLMNOPQRSTUVWXYZ []^_` abcdefghijklmnopqrstuvwxyz {|}~ !#$%& '()*+,-./ 0123456789 :;<=>?@ ABCDEFGHIJKLMNOPQRSTUVWXYZ []^_` abcdefghijklmnopqrstuvwxyz {|}~ !#$%& '()*+,-./ 0123456789 :;<=>?@ ABCDEFGHIJKLMNOPQRSTUVWXYZ []^_` abcdefghijklmnopqrstuvwxyz {|}~ ";

        // Expected Result
        StringWriter expectedStringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(expectedStringWriter);

        printWriter.println("Alphabetic: 520");
        printWriter.println("Numeric: 100");
        printWriter.println("Other: 380");
        printWriter.close();
        String expected = expectedStringWriter.toString();

        caseOne[2] = expected;

        testData.add(caseOne);

        return testData;

    }
}
