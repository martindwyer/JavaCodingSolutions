/*
 * Copyright (C) 2019 marti
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

/**
 *
 * @author marti
 */
import java.util.ArrayList;

public class GetBigWords {
    
    public static void main(String[] args) {
        String text= "There are 87,000,000 people in Canada 6A7B0C0V0D1E2S0D9D09 son-in-law";
        String[] result = getBigWords(text);
        for(int m= 0; m < result.length; m++ ){
            System.out.println(result[m]);
        }
                
    }
    
    public static String[] getBigWords(String s) {
        
        s = s.replace("@", " ");
        s = s.replace(".", " ");
        s = s.replace("-", " ");
        s = s.replace(",", "");
        String[] wordArray = s.split(" ");
        
        ArrayList<String> bigWords = new ArrayList<String>();
        
        boolean numeric = true;
        boolean containsNumber = true;
        double num = 0.0;
        for(int i=0; i < wordArray.length; i++) {
            
            try {
                num = Double.parseDouble(wordArray[i]);
            } catch (NumberFormatException e) {
                numeric = false;
            }
            
            char[] chars = wordArray[i].toCharArray();
            for(char c: chars) {
                try {
                    num = Double.parseDouble(String.valueOf(c));
                    containsNumber = true;
                    break;
                } catch (NumberFormatException e) {
                    containsNumber = false;
                }
            }
            
            if(wordArray[i].length() > 5 && !numeric && !containsNumber) {
                bigWords.add(wordArray[i]);
                
            }
            numeric = true;
            containsNumber = true;
        }
        
        String[] bigWordsArray = bigWords.toArray(new String[0]);
        
        return bigWordsArray;
        
        

    }
}
