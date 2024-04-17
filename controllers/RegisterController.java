package controllers;

import models.Customer;

public class RegisterController {
    public static Customer registerCustomer(String name, String pass, String phoneNumber, String creditCardNumber) {
        Customer newCustomer = new Customer(name, pass, phoneNumber, creditCardNumber, "user");
        return newCustomer;
    }
}
