/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBuilder;

import java.util.ArrayList;

/**
 *
 * @author marti
 */
public class AskForCharTestData {
    
    public static ArrayList<String[]> getTestData() {
    
        ArrayList<String[]> testData = new ArrayList<String[]>();
        
        // Testing single char string
        String[] testCase1 = new String[4];
        testCase1[0] = "Testing askForWordDelimiter() for single char response";
        testCase1[1] = "Expected return of single char";
        testCase1[2] = "a";
        testCase1[3] = "a";
        testData.add(testCase1);
        
        // Testing empty string
        String[] testCase2 = new String[4];
        testCase2[0] = "Testing askForWordDelimiter() for empty string response";
        testCase2[1] = "Prompt for proper input";
        testCase2[2] = "\na";
        testCase2[3] = "a";
        testData.add(testCase2);
        
        // Testing long string input
        String[] testCase3 = new String[4];
        testCase3[0] = "Testing askForWordDelimiter() for input too long";
        testCase3[1] = "Expected rejection of input, prompt for proper input";
        testCase3[2] = "abcde\na";
        testCase3[3] = "a";
        testData.add(testCase3);
        
        return testData;
    }
    
    
    
    
}
