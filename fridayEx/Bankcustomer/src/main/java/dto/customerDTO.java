/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.BankCustomer;
import javax.persistence.Entity;

/**
 *
 * @author fskn
 */

public class customerDTO {
    private int customerID;
    private String fullName;
    private String accountNumber;
    private double balance; 
    BankCustomer bankCustomer = new BankCustomer();

    public customerDTO() {
    }
    
    public customerDTO(BankCustomer bc) {
        this.customerID = bc.getId();
        this.fullName = bc.getFirstName() + bc.getLastName();
        this.accountNumber = bc.getAccountNumber();
        this.balance = bc.getBalance();
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public BankCustomer getBankCustomer() {
        return bankCustomer;
    }

    public void setBankCustomer(BankCustomer bankCustomer) {
        this.bankCustomer = bankCustomer;
    }

    @Override
    public String toString() {
        return "customerDTO{" + "customerID=" + customerID + ", fullName=" + fullName + ", accountNumber=" + accountNumber + ", balance=" + balance + ", bankCustomer=" + bankCustomer + '}';
    }

    
    
}
