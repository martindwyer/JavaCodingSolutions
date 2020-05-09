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
import java.util.Scanner;

public class RainFall {
    private double[] monthlyTotals = new double[12];
    
    public double totalRainFall() {
        double total = 0.0;
        for(int i = 0; i < 12; i++) {
            total += this.monthlyTotals[i];
        }
        return total;
    }
    
    public double averageRainFall() {
        double total = 0.0;
        double average = 0.0;
        for(int i = 0; i < 12; i++) {
            total += this.monthlyTotals[i];
        }
        average = total/12;
        return average;
    }
    public String mostRainFall() {
        double most = 0.0;
        int monthPosition = 0;
        String[] year = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        for(int i=0; i < 12; i++) {
            if(this.monthlyTotals[i] > most) {
                most = this.monthlyTotals[i];
                monthPosition = i;
            }
        }        
        return year[monthPosition];
    }
    public String leastRainFall() {
        double least = 9999999.0;
        int monthPosition = 0;
        String[] year = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        for(int i=0; i < 12; i++) {
            if(this.monthlyTotals[i] < least) {
                least = this.monthlyTotals[i];
                monthPosition = i;
            }
        }        
        return year[monthPosition];
    }
    
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        RainFall thisYear = new RainFall();
        double input = 0.0;
        boolean validInput = false;
        
        for(int i = 1; i <= 12; i++) {
            while(!validInput) {
                System.out.print("Enter rainfall for month " + i +":" );
                input = kb.nextDouble();
                if(input >= 0) {
                    thisYear.monthlyTotals[i-1] = input;
                    validInput = true;
                }
            }
            validInput = false;
        }
        
        System.out.println(thisYear.totalRainFall());
        System.out.println(thisYear.averageRainFall());
        System.out.println(thisYear.mostRainFall());
        System.out.println(thisYear.leastRainFall());
        
    }
}
