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

public class StringReverse {
    
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter a string to be reversed:");
        String s = kb.nextLine();
        String sReverse = reverse(s);
        System.out.println(sReverse);
        
    }
    
    public static String reverse(String s) {
	if(s.length() <= 1) return s;
	
	else
		return s.charAt(s.length()-1) + reverse(s.substring(0,s.length()-1));
    }
    
}
