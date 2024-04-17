package controllers;

import java.util.HashMap;
import models.Customer;

public class LoginController {

    public static String loginCustomer(String name, String pass, HashMap<String, Customer> customers){
        for(String key : customers.keySet()){
            if (customers.get(key).getName().equalsIgnoreCase(name)) {
                if (customers.get(key).getPassword().equalsIgnoreCase(pass)) {// password username bener
                    if (customers.get(key).getRole().equalsIgnoreCase("admin")) {
                        return "admin"; // admin
                    }
                    return key; // user
                }
            }else{
                return "register";// username tidak ada suruh register
            }
        }
        return "login"; // password salah
    }
}
