package controllers;

import java.util.HashMap;
import models.Customer;

public class LoginController {

    public static String loginCustomer(String name, String pass, HashMap<String, Customer> customers) {
        boolean usernameExists = false;
        for (String key : customers.keySet()) {
            if (customers.get(key).getName().equalsIgnoreCase(name)) {
                usernameExists = true;
                if (customers.get(key).getPassword().equalsIgnoreCase(pass)) {
                    if (customers.get(key).getRole().equalsIgnoreCase("admin")) {
                        return "admin"; // admin
                    }
                    return key; // user
                }
            }
        }
        if (!usernameExists) {
            return "register"; // username tidak ada, new user diminta register
        }
        return "login"; // password salah
    }
}
