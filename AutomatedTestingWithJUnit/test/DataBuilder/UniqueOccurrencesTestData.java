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
public class UniqueOccurrencesTestData {
    
    public static ArrayList<String[]> getTestData() {
        
        ArrayList<String[]> testData = new ArrayList<String[]>();
        
        String[] caseOne = new String[4];
        caseOne[0] = "One thousand char string, with white space separator";
        caseOne[1] = "!#$%& '()*+,-./ 0123456789 :;<=>?@ ABCDEFGHIJKLMNOPQRSTUVWXYZ []^_` abcdefghijklmnopqrstuvwxyz {|}~ !#$%& '()*+,-./ 0123456789 :;<=>?@ ABCDEFGHIJKLMNOPQRSTUVWXYZ []^_` abcdefghijklmnopqrstuvwxyz {|}~ !#$%& '()*+,-./ 0123456789 :;<=>?@ ABCDEFGHIJKLMNOPQRSTUVWXYZ []^_` abcdefghijklmnopqrstuvwxyz {|}~ !#$%& '()*+,-./ 0123456789 :;<=>?@ ABCDEFGHIJKLMNOPQRSTUVWXYZ []^_` abcdefghijklmnopqrstuvwxyz {|}~ !#$%& '()*+,-./ 0123456789 :;<=>?@ ABCDEFGHIJKLMNOPQRSTUVWXYZ []^_` abcdefghijklmnopqrstuvwxyz {|}~ !#$%& '()*+,-./ 0123456789 :;<=>?@ ABCDEFGHIJKLMNOPQRSTUVWXYZ []^_` abcdefghijklmnopqrstuvwxyz {|}~ !#$%& '()*+,-./ 0123456789 :;<=>?@ ABCDEFGHIJKLMNOPQRSTUVWXYZ []^_` abcdefghijklmnopqrstuvwxyz {|}~ !#$%& '()*+,-./ 0123456789 :;<=>?@ ABCDEFGHIJKLMNOPQRSTUVWXYZ []^_` abcdefghijklmnopqrstuvwxyz {|}~ !#$%& '()*+,-./ 0123456789 :;<=>?@ ABCDEFGHIJKLMNOPQRSTUVWXYZ []^_` abcdefghijklmnopqrstuvwxyz {|}~ !#$%& '()*+,-./ 0123456789 :;<=>?@ ABCDEFGHIJKLMNOPQRSTUVWXYZ []^_` abcdefghijklmnopqrstuvwxyz {|}~ ";
        caseOne[2] = " ";
        caseOne[3] = "10 #$%&\n"
                + "10 ()*+/\n"
                + "10 0123456789\n"
                + "10 <=>@\n"
                + "10 ABCDEFGHIJKLMNOPQRSTUVWXYZ\n"
                + "10 []^_`\n"
                + "10 abcdefghijklmnopqrstuvwxyz\n"
                + "10 {|}~";
        
        testData.add(caseOne);

        String[] caseTwo = new String[4];
        caseTwo[0] = "One thousand char string, with hashtag # separator";
        caseTwo[1] = "!#$%& '()*+,-./ 0123456789 :;<=>?@ ABCDEFGHIJKLMNOPQRSTUVWXYZ []^_` abcdefghijklmnopqrstuvwxyz {|}~ !#$%& '()*+,-./ 0123456789 :;<=>?@ ABCDEFGHIJKLMNOPQRSTUVWXYZ []^_` abcdefghijklmnopqrstuvwxyz {|}~ !#$%& '()*+,-./ 0123456789 :;<=>?@ ABCDEFGHIJKLMNOPQRSTUVWXYZ []^_` abcdefghijklmnopqrstuvwxyz {|}~ !#$%& '()*+,-./ 0123456789 :;<=>?@ ABCDEFGHIJKLMNOPQRSTUVWXYZ []^_` abcdefghijklmnopqrstuvwxyz {|}~ !#$%& '()*+,-./ 0123456789 :;<=>?@ ABCDEFGHIJKLMNOPQRSTUVWXYZ []^_` abcdefghijklmnopqrstuvwxyz {|}~ !#$%& '()*+,-./ 0123456789 :;<=>?@ ABCDEFGHIJKLMNOPQRSTUVWXYZ []^_` abcdefghijklmnopqrstuvwxyz {|}~ !#$%& '()*+,-./ 0123456789 :;<=>?@ ABCDEFGHIJKLMNOPQRSTUVWXYZ []^_` abcdefghijklmnopqrstuvwxyz {|}~ !#$%& '()*+,-./ 0123456789 :;<=>?@ ABCDEFGHIJKLMNOPQRSTUVWXYZ []^_` abcdefghijklmnopqrstuvwxyz {|}~ !#$%& '()*+,-./ 0123456789 :;<=>?@ ABCDEFGHIJKLMNOPQRSTUVWXYZ []^_` abcdefghijklmnopqrstuvwxyz {|}~ !#$%& '()*+,-./ 0123456789 :;<=>?@ ABCDEFGHIJKLMNOPQRSTUVWXYZ []^_` abcdefghijklmnopqrstuvwxyz {|}~ ";
        caseTwo[2] = "#";
        caseTwo[3] = "1 \n"
                + "10 $%& ()*+/ 0123456789 <=>@ ABCDEFGHIJKLMNOPQRSTUVWXYZ []^_` abcdefghijklmnopqrstuvwxyz {|}~ ";
        
        testData.add(caseTwo);
        
        return testData;
        
    }
    
}
