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
public class SubStringTestData {
    
    public static ArrayList<String[]> getTestData() {
        
        ArrayList<String[]> testData = new ArrayList<String[]>();
        
        String[] caseOne = new String[4];
        caseOne[0] = "One thousand char string, with white space separator";
        caseOne[1] = Database.get1000CharString();
        caseOne[2] = " ";
        caseOne[3] = "\n" +
"!\"#$%&'()*+,-./0123456789\n" +
":;<=>?@ABCDEF\n" +
"GHIJKLMNOP\n" +
"QRSTUVWXYZ\n" +
"[\\]^_`abcdef\n" +
"ghijklmnopqrstuvwxyz{|}~\n" +
"!\"#$%&'()*+,-./0123456789\n" +
":;<=>?@ABCDEF\n" +
"GHIJKLMNOP\n" +
"QRSTUVWXYZ\n" +
"[\\]^_`abcdef\n" +
"ghijklmnopqrstuvwxyz{|}~\n" +
"!\"#$%&'()*+,-./0123456789\n" +
":;<=>?@ABCDEF\n" +
"GHIJKLMNOP\n" +
"QRSTUVWXYZ\n" +
"[\\]^_`abcdef\n" +
"ghijklmnopqrstuvwxyz{|}~\n" +
"!\"#$%&'()*+,-./0123456789\n" +
":;<=>?@ABCDEF\n" +
"GHIJKLMNOP\n" +
"QRSTUVWXYZ\n" +
"[\\]^_`abcdef\n" +
"ghijklmnopqrstuvwxyz{|}~\n" +
"!\"#$%&'()*+,-./0123456789\n" +
":;<=>?@ABCDEF\n" +
"GHIJKLMNOP\n" +
"QRSTUVWXYZ\n" +
"[\\]^_`abcdef\n" +
"ghijklmnopqrstuvwxyz{|}~\n" +
"!\"#$%&'()*+,-./0123456789\n" +
":;<=>?@ABCDEF\n" +
"GHIJKLMNOP\n" +
"QRSTUVWXYZ\n" +
"[\\]^_`abcdef\n" +
"ghijklmnopqrstuvwxyz{|}~\n" +
"!\"#$%&'()*+,-./0123456789\n" +
":;<=>?@ABCDEF\n" +
"GHIJKLMNOP\n" +
"QRSTUVWXYZ\n" +
"[\\]^_`abcdef\n" +
"ghijklmnopqrstuvwxyz{|}~\n" +
"!\"#$%&'()*+,-./0123456789\n" +
":;<=>?@ABCDEF\n" +
"GHIJKLMNOP\n" +
"QRSTUVWXYZ\n" +
"[\\]^_`abcdef\n" +
"ghijklmnopqrstuvwxyz{|}~\n" +
"!\"#$%&'()*+,-./0123456789\n" +
":;<=>?@ABCDEF\n" +
"GHIJKLMNOP\n" +
"QRSTUVWXYZ\n" +
"[\\]^_`abcdef\n" +
"ghijklmnopqrstuvwxyz{|}~\n" +
"!\"#$%&'()*+,-./0123456789\n" +
":;<=>?@ABCDEF\n" +
"GHIJKLMNOP\n" +
"QRSTUVWXYZ\n" +
"[\\]^_`abcdef\n" +
"ghijklmnopqrstuvwxyz{|}~";
        
        testData.add(caseOne);

        String[] caseTwo = new String[4];
        caseTwo[0] = "One thousand char string, with hashtag # separator";
        caseTwo[1] = Database.get1000CharString();
        caseTwo[2] = "#";
        caseTwo[3] = " !\"\n" +
"$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"\n" +
"$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"\n" +
"$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"\n" +
"$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"\n" +
"$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"\n" +
"$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"\n" +
"$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"\n" +
"$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"\n" +
"$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"\n" +
"$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~";
        
        testData.add(caseTwo);

        return testData;
    }
    
}
