package models;

import java.util.LinkedList;

public class Customer {
    private String name, password, phoneNumber, creditCardNumber, role;
    private LinkedList<Transaction> transactions = new LinkedList<Transaction>();

    public Customer(String name, String pass, String phoneNumber, String creditCardNumber, String role) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.creditCardNumber = creditCardNumber;
        this.password = pass;
        this.role = role;
        this.transactions = new LinkedList<>();
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role){
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public LinkedList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(LinkedList<Transaction> transactions) {
        this.transactions = transactions;
    }
}
