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
public class IsReverse {

    public static void main(String[] args) {
        
        int[] a = {1,2,3,4,5,6,7,8};
        int[] b = {8,7,6,5,4,3,2,1};
        
        boolean isMirror = false;
	for(int i = 0, j = b.length-1; i < a.length; i++, j--) {
		
                        System.out.println("a = " + a[i]);
                        System.out.println("b = " + b[j]);
			if (a[i] == b[j]) {
				isMirror = true;
			} else {
				isMirror = false;
				break;
			}
		
	}
	System.out.println(isMirror);
        
        
        
    }

    
}
