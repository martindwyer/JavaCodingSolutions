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
public class HasEmpty {
    public static void main(String[] args) {
        boolean hasEmpty;
        String[] name1 = {"fred","barney","wilma","betty",null};
        String[] name2 = {"fred","barney","wilma","betty",""};
        String[] name3 = {"fred","barney","wilma","betty"};
        
        System.out.println(hasEmpty(name1));
        System.out.println(hasEmpty(name2));
        System.out.println(hasEmpty(name3));
    }
    
    public static boolean hasEmpty(String[] nameArray) {
        boolean foundEmpty = false;
        for(String s: nameArray) {
            
            if(s == null) {
                foundEmpty = true;
                break;
            }
            if(s.isEmpty()){
                foundEmpty = true;
                break;
            } 
        }
        return foundEmpty;
    }
}
