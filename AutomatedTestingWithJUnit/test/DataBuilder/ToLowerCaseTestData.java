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
public class ToLowerCaseTestData {
    
    public static ArrayList<String[]> getTestData() {

        ArrayList<String[]> testData = new ArrayList<String[]>();
        
        String[] testCase1 = new String[3];

        testCase1[0] = "1000 char string";
        testCase1[1] = " !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~";
        testCase1[2] = toLowerCaseExpected(testCase1[1]);
        
        testData.add(testCase1);
        
        String[] testCase2 = new String[3];

        testCase2[0] = "white space string";
        testCase2[1] = " ";
        testCase2[2] = toLowerCaseExpected(testCase2[1]);
        
        testData.add(testCase2);

        String[] testCase3 = new String[3];

        testCase3[0] = "empty string";
        testCase3[1] = "";
        testCase3[2] = toLowerCaseExpected(testCase3[1]);
        
        testData.add(testCase3);        

        return testData;

    }

    private static String toLowerCaseExpected(String val) {
        // Expected Result
        String expectedString = "";
        for (int i = 0; i < val.length(); i++) {
            char letter = val.charAt(i);

            if (String.valueOf(letter).matches("[A-Z]")) {
                expectedString += (char) (letter + 32);

            } else {
                expectedString += (letter);
            }
        }
        
        return expectedString;
        
    }

    
}
