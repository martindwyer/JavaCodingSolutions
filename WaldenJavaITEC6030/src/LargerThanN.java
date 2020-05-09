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
public class LargerThanN {
    
    public static void largerThanN(int n, int[] nArray) {
        for(int i = 0; i < nArray.length; i++) {
            if(nArray[i] > n) System.out.println(nArray[i]);
        }
    }
    
    public static void main(String[] args) {
        int[] a1 = {1, 5, 10, 2, 4, -3, 6};
        int[] a2 = {10, 12, 15, 24};
        int n1 = 3;
        int n2 = 12;
        
        largerThanN(n1,a1);
        largerThanN(n2,a2);
        
    }
    
    
}
