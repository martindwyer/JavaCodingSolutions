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
public class AskForStringTestData {

    public static ArrayList<String[]> getTestData() {
        ArrayList<String[]> testData = new ArrayList<String[]>();

        String char1000 = " !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~";
        String char1001 = " !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~Z";
        String emptyString = "";
        String whiteSpace = " ";
        
         // Testing of empty string
        String[] testCase3 = new String[4];
        testCase3[0] = "Testing askForString() for empty string input";
        testCase3[1] = "Expected return of empty string";
        testCase3[2] = "";
        testCase3[3] = "";
        testData.add(testCase3);

        // Testing of white space string
        String[] testCase4 = new String[4];
        testCase4[0] = "Testing askForString() for white space string";
        testCase4[1] = "Expected return of white space string";
        testCase4[2] = " ";
        testCase4[3] = " ";
        testData.add(testCase4);

        
        // Testing 1000 char string
        String[] testCase1 = new String[4];
        testCase1[0] = "Testing askForString() for 1000 char string";
        testCase1[1] = "Expected return of string input";
        testCase1[2] = char1000;
        testCase1[3] = char1000;
        testData.add(testCase1);

        // Testing 1001 char string
        String[] testCase2 = new String[4];
        testCase2[0] = "Testing askForString() for 1001 char string";
        testCase2[1] = "Expected rejection of input, return of empty string";
        testCase2[2] = char1001;
        testCase2[3] = "";
        testData.add(testCase2);

       
        return testData;

    }

}
