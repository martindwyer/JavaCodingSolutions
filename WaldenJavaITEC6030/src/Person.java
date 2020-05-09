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

import java.util.Scanner;

class Person {
    private String name;
    private String address;
    private String phoneNumber;

    public Person(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

class Customer extends Person {
    private String customerNumber;
    private boolean mailingList;

    public Customer(String customerNumber, boolean mailingList, String name, String address, String phoneNumber) {
        super(name, address, phoneNumber);
        this.customerNumber = customerNumber;
        this.mailingList = mailingList;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public boolean isMailingList() {
        return mailingList;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public void setMailingList(boolean mailingList) {
        this.mailingList = mailingList;
    }
 
   
}

class PreferredCustomer extends Customer {
    private int purchaseAmount, discountLevel;

    public PreferredCustomer(int purchaseAmount,String customerNumber, boolean mailingList, String name, String address, String phoneNumber) {
        super(customerNumber, mailingList, name, address, phoneNumber);
        this.purchaseAmount = purchaseAmount;
        this.discountLevel = discountLevel;
        if(purchaseAmount >= 2000) {
            this.discountLevel = 10;
        } else if(purchaseAmount >= 1500) {
            this.discountLevel = 7;
        } else if(purchaseAmount >= 1000) {
            this.discountLevel = 6;
        } else if(purchaseAmount >= 500) {
            this.discountLevel = 5;
        } else {
            this.discountLevel = 0;
        }
        
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getDiscountLevel() {
        return discountLevel;
    }

    public void setPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public void setDiscountLevel(int discountLevel) {
        this.discountLevel = discountLevel;
    }
    
    
}

class Driver {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String name, address, phoneNumber, customerNumber, input;
        int purchaseAmount, discountLevel;
        boolean mailingList;
        
        System.out.print("Enter name of customer:");
        name = kb.nextLine();
       
        System.out.print("Enter address of customer:");
        address = kb.nextLine();
        
        System.out.print("Enter phone number of customer:");
        phoneNumber = kb.nextLine();
        
        System.out.print("Enter customer number:");
        customerNumber = kb.nextLine();
        
        System.out.print("Enter yes/no -- does the customer want to recieve mail?:");
        input = kb.nextLine();
        if(input.equals("yes")) {
            mailingList = true;
        } else {
            mailingList = false;
        }

        System.out.print("Enter amount customer has spent:");
        purchaseAmount = kb.nextInt();
        
        PreferredCustomer newCustomer = new PreferredCustomer(purchaseAmount,customerNumber,mailingList,name,address,phoneNumber);

        
        System.out.println("\nCustomer: ");
        System.out.println("Name: " + newCustomer.getName());
        System.out.println("Address: " + newCustomer.getAddress());
        System.out.println("Phone Number: " + newCustomer.getPhoneNumber());
        System.out.println("Customer Number: " + newCustomer.getCustomerNumber());
        System.out.println("Recieve Mail?: " + newCustomer.isMailingList());
        System.out.println("Amount Purchased: $" + newCustomer.getPurchaseAmount()+".00");
        System.out.println("Percent off: " + newCustomer.getDiscountLevel()+"%");
      
        }        
        
    }
