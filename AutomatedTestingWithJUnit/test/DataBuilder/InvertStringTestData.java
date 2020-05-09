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
public class InvertStringTestData {

    public static ArrayList<String[]> getTestData() {

        ArrayList<String[]> testData = new ArrayList<String[]>();

        String[] testCase1 = new String[3];

        testCase1[0] = "1000 char string";
        testCase1[1] = " !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~";
        testCase1[2] = expectedResult(testCase1[1]);

        testData.add(testCase1);

        String[] testCase2 = new String[3];

        testCase2[0] = "white space string";
        testCase2[1] = " ";
        testCase2[2] = expectedResult(testCase2[1]);

        testData.add(testCase2);

        String[] testCase3 = new String[3];

        testCase3[0] = "empty string";
        testCase3[1] = "";
        testCase3[2] = expectedResult(testCase3[1]);

        testData.add(testCase3);

        return testData;

    }

    private static String expectedResult(String val) {
        // Expected Result
        String reverseVal = "";
        for (int i = val.length() - 1; i >= 0; i--) {
            reverseVal += val.charAt(i);
        }

        return reverseVal;

    }

}
