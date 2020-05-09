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
public class StringBinarySearch {
    
    public static void main(String[] args) {
        String s = "b";
        String[] stringArray = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        boolean gotOne = getWidgetMatch(s,stringArray);
        System.out.println(gotOne);
        
        
    }
    
    
    public static boolean getWidgetMatch(String s, String[] sArray) {
	boolean foundObject = false;
	int lowIndex = 0;
	int highIndex = sArray.length-1;
	int middleIndex = (highIndex -lowIndex)/2;
        int objectValue = s.compareTo(s);
              

        while(!foundObject && lowIndex <= highIndex) {
        
                if(s.compareTo(sArray[middleIndex]) == objectValue) {
                    foundObject = true;
                } else if(s.compareTo(sArray[middleIndex]) < objectValue) {
                    lowIndex = lowIndex;
                    highIndex = middleIndex -1;
                    middleIndex = (highIndex -lowIndex)/2;
                } else {
                    lowIndex = middleIndex +1;
                    highIndex = highIndex;
                    middleIndex = (highIndex -lowIndex)/2;
                }
	}
	
	return foundObject;
    }
}
