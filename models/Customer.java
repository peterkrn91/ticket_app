package models;

import java.util.LinkedList;

public class Customer {
    private String name, phoneNumber, creditCardNumber;
    private LinkedList<Transaction> transactions = new LinkedList<Transaction>();

    public Customer(String name, String phoneNumber, String creditCardNumber, LinkedList<Transaction> transactions) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.creditCardNumber = creditCardNumber;
        this.transactions = transactions;
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
