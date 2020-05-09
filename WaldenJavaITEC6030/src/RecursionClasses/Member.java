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
package RecursionClasses;

import java.util.Scanner;

public class Member {
 
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter size of array:");
        int arraySize = kb.nextInt();
        int[] intArray = new int[arraySize];
        
        for(int i= 0; i < arraySize; i++) {
            System.out.print("Enter number for array index " + i + ":");
            intArray[i] = kb.nextInt();
        }
        
        System.out.print("Enter number to search for in array:");
        int searchKey = kb.nextInt();
        
        boolean foundElement = isMember(intArray,searchKey);
        
        System.out.println(foundElement);        
    }
    
 
    public static boolean isMember(int[] array, int m) {
        int n = array.length;
        return search(array,n,m);
    }
   
    public static boolean search(int[] array, int n, int m) {
	if(n==0) return false;
	if(array[n-1] == m) {
		return true;
	} else {
		return search(array,n-1,m);
	}
    }
}
