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
public class VowelCaseTestData {

    public static ArrayList<String[]> getVowelCaseData() {

        ArrayList<String[]> testData = new ArrayList<String[]>();
        
        String[] testCase1 = new String[3];

        testCase1[0] = "1000 char string";
        testCase1[1] = " !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~";
        testCase1[2] = vowelCaseExpected(testCase1[1]);
        
        testData.add(testCase1);
        
        String[] testCase2 = new String[3];

        testCase2[0] = "white space string";
        testCase2[1] = " ";
        testCase2[2] = vowelCaseExpected(testCase2[1]);
        
        testData.add(testCase2);

        String[] testCase3 = new String[3];

        testCase3[0] = "empty string";
        testCase3[1] = "";
        testCase3[2] = vowelCaseExpected(testCase3[1]);
        
        testData.add(testCase3);        

        return testData;

    }

    private static String vowelCaseExpected(String val) {

        String expectedString = "";
        for (int i = 0; i < val.length(); i++) {
            char letter = val.charAt(i);

            switch (letter) {
                case ' ':
                    expectedString += ' ';
                    break;
                case 'A':
                    expectedString += letter;
                    break;
                case 'E':
                    expectedString += letter;
                    break;
                case 'I':
                    expectedString += letter;
                    break;
                case 'O':
                    expectedString += letter;
                    break;
                case 'U':
                    expectedString += letter;
                    break;
                case 'a':
                    expectedString += (char) (letter - 32);
                    break;
                case 'e':
                    expectedString += (char) (letter - 32);
                    break;
                case 'i':
                    expectedString += (char) (letter - 32);
                    break;
                case 'o':
                    expectedString += (char) (letter - 32);
                    break;
                case 'u':
                    expectedString += (char) (letter - 32);
                    break;

                default:
                    if ((letter >= 'A' && letter <= 'Z')) {
                        expectedString += (char) (letter + 32);

                    } else {
                        expectedString += letter;
                    }
            }
        }
         return expectedString;
    }
}