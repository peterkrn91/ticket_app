package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import controllers.*;
import models.*;

public class Main {
    static HashMap<String, Customer> customers = new HashMap<>();
    static ArrayList<Concert> concert = new ArrayList<>();
    static Scanner scn = new Scanner(System.in);
    static String presentUserId;

    public static void main(String[] args) {
        importData();
        Login();
    }

    public static void importData() {
        // concert data
        Booth boothConcertA1 = new Booth(300, 150, "Pink");
        Booth boothConcertA2 = new Booth(200, 175, "Blue");
        Booth boothConcertB1 = new Booth(50, 300, "Platinum");
        Booth boothConcertB2 = new Booth(400, 130, "Green");
        ConcertInfo concertInfo1 = new ConcertInfo("Jakarta International Stadium, Jakarta", "02/03/2024", "18:00",
                "+-=÷x Tour (The Mathematics Tour)", "Ed Sheeran",
                "Ed Sheeran's 4th World Tour");
        ConcertInfo concertInfo2 = new ConcertInfo("JIEXPO Kemayoran, Jakarta", "25/05/2024", "17:00",
                "Laufey in Java Jazz Festival", "Laufey",
                "Special Performance by Laufey in Java Jazz Festival");
        concert.add(new Concert(concertInfo1, 2, new Booth[] { boothConcertA1, boothConcertA2 }));
        concert.add(new Concert(concertInfo2, 2, new Booth[] { boothConcertB1, boothConcertB2 }));

        // customer data
        customers.put("1", new Customer("Reivel", "123", "082321534551", "0329 0234 2130 3210", "admin"));
        customers.put("2", new Customer("Peter", "123", "081258291928", "0129 2327 7570 5890", "user"));
        customers.put("3", new Customer("Calv", "123", "081222222222", "0229 3327 4570 5890", "user"));
    }

    public static void Login() {
        System.out.print("Input name (exit): ");
        String nama = scn.nextLine();
        while(!nama.equals("exit")){
            System.out.print("Input password: ");
            String pass = scn.nextLine();
            String cek = LoginController.loginCustomer(nama, pass, customers);
    
            if (cek == null) {
                System.out.println("Error: Customer database or presentUserId is null.");
                return;
            }
    
            if (cek.equalsIgnoreCase("admin")) {
                System.out.println("Welcome, admin Ticket.Com!");
                Admin();
            } else if (cek.equalsIgnoreCase("login")) {
                presentUserId = cek;
                System.out.println("Incorrect password. Please try again.");
                Login();
            } else if (cek.equalsIgnoreCase("register")) {
                System.out.println("Sorry, your account doesn't exist. Please register.");
                Register();
            } else {
                System.out.println("Welcome to Ticket.Com, " + nama + "! ");
                presentUserId = cek;
                System.out.println("1. See Concert\n2. See Ticket\n3. Exit\nPilih Menu :");
                int pilihan = scn.nextInt();
                while(pilihan!=3){
                    System.out.println("============== CUST MENU ==============");
                    switch(pilihan){
                        case 1:
                            pilihConcert();
                        break;
                        case 2:
                            for (int i = 0; i < customers.get(presentUserId).getTransactions().size(); i++) {
                                Transaction t1 = customers.get(presentUserId).getTransactions().get(i);
                                System.out.println("invoiceNum\t\tconcert\t\t\tbooth\t\tticketPrice\t\tTicket\t\tQuantity");
                                Concert c1 = concert.get(t1.getTickets().getConcert());
                                ConcertController.displayTicket(t1, c1);
                            }
                        break;
                        default:
                        System.out.println("Salah Input, Silahkan Input Ulang");
                        break; 
                    }
                    System.out.println("1. See Concert\n2. See Ticket\n3. Exit\nPilih Menu :");
                    pilihan = scn.nextInt();
                }
            } 
            scn.nextLine();
            System.out.print("Input name (exit): ");
            nama = scn.nextLine();
        }
    }

    public static void Register() {
        System.out.print("Input name: ");
        String nama = scn.nextLine();
        System.out.print("Input password: ");
        String pass = scn.nextLine();
        System.out.print("Input personal number: ");
        String phoneNum = scn.nextLine();
        System.out.print("Input Credit Card number: ");
        String cardNum = scn.nextLine();
        Customer newCustomer = RegisterController.registerCustomer(nama, pass, phoneNum, cardNum);
        customers.put(nama, newCustomer);
        System.out.println("Welcome to Ticket.Com, " + nama + "! ");
        presentUserId = nama;
        pilihConcert();
    }

    public static void pilihConcert() {
        System.out.println("=============================== AVAILABLE CONCERTS ===============================");
        System.out.println("Id\t\tTitle\t\t\t\tDate\t\t\tArtist");
        for (int i = 0; i < concert.size(); i++) {
            System.out.println(i + "\t" + concert.get(i).getConcertInfo().getTitle() + "\t"
                    + concert.get(i).getConcertInfo().getDate() + "\t\t"
                    + concert.get(i).getConcertInfo().getArtistName());
            System.out.println("\n===================================================================================");
        }
        System.out.println("Choose ConcertID: ");
        int concertID = scn.nextInt();
        if (concert.size() < concertID && concertID < 0) {
            System.out.println("Error, ConcertID doesn't exist.");
            pilihConcert();
        } else {
            pilihBooth(concertID);
        }

    }

    public static void pilihBooth(int concertID) {
        System.out.println("============== AVAILABLE BOOTHS ==============");
        System.out.println("BoothID\t\tBooth Category\t\tPrice");
        Booth[] booths = concert.get(concertID).getBooth();
        for (int i = 0; i < booths.length; i++) {
            System.out.println(i + "\t\t" + booths[i].getCatName() + "\t\t" + booths[i].getPrice());
        }
        System.out.println("==============================================");
        System.out.print("Input Booth Category: ");
        int boothCategory = scn.nextInt();
        System.out.print("Input Ticket Quantity: ");
        int quantity = scn.nextInt();
        if (boothCategory > booths.length && boothCategory > 0) {
            System.out.println("Error, Booth Category doesn't exist.");
            pilihBooth(concertID);
        } else {
            transaction(concertID, boothCategory, quantity, booths[boothCategory]);
        }
    }

    public static void transaction(int concertID, int boothCategory, int quantity, Booth booth) { // invoice number,
                                                                                                  // ticket apa aja,
        // quantity, total satuan, total
        // smua
        System.out.println("==============================================");
        System.out.println("Confirm your transaction? (true/false)");
        boolean confirmation = scn.nextBoolean();
        scn.nextLine();

        if (confirmation) {
            if (customers != null && customers.containsKey(presentUserId)) {
                String invoice = "INV" + concertID + "" + boothCategory;
                Transaction createTransaction = new Transaction(invoice,
                        new Ticket(concertID, boothCategory, quantity));

                LinkedList<Transaction> userTransactions = customers.get(presentUserId).getTransactions();
                if (userTransactions == null) {
                    userTransactions = new LinkedList<>();
                }
                userTransactions.add(createTransaction);
                customers.get(presentUserId).setTransactions(userTransactions);

                System.out.println("==============================================");
                System.out.println("Transaction successful!\nYour invoice number: \t"
                        + customers.get(presentUserId).getTransactions().get(0).getInvoiceNumber());

                booth.addTotal(quantity * booth.getPrice());
            } else {
                System.out.println("Customer or presentUserId is null. Unable to process transaction.");
            }
        } else {
            pilihBooth(concertID);
        }
    }

    public static void Admin() {
        System.out.println("============== ADMIN MENU ==============");
        System.out.println("1. Add Concerts\n2. Check Concert Income\n3. Check Customer's Transactions\n4. Exit");
        System.out.println("Choose Menu: ");
        int menu = scn.nextInt();

        while(menu!=4){
            switch (menu) {
                case 1:
                    System.out.print("Concert title: ");
                    String title = scn.next();
                    scn.nextLine();
                    System.out.print("Concert artistName: ");
                    String artistName = scn.next();
                    System.out.print("Concert date: ");
                    String date = scn.next();
                    System.out.print("Concert time: ");
                    String time = scn.next();
                    System.out.print("Concert location: ");
                    String location = scn.next();
                    scn.nextLine();
                    System.out.print("Concert description: ");
                    String description = scn.next();
                    scn.nextLine();

                    System.out.print("Total Booth: ");
                    int totalBooth = scn.nextInt();
                    scn.nextLine();

                    System.out.println("Please input all booth details.");

                    Booth[] booths = new Booth[totalBooth];
                    for (int i = 0; i < totalBooth; i++) {
                        System.out.println("Booth " + (i + 1) + " Details:");
                        System.out.print("Booth Available Ticket: ");
                        int availableTicket = scn.nextInt();
                        System.out.print("Booth Ticket Price: ");
                        int ticketPrice = scn.nextInt();
                        scn.nextLine();
                        System.out.print("Booth Category Name: ");
                        String catName = scn.next();
                        booths[i] = new Booth(availableTicket, ticketPrice, catName);
                    }

                    ConcertController.addConcert(new ConcertInfo(location, date, time, title, artistName, description),
                            totalBooth, booths);
                    System.out.println(
                            "Successfully added new concert!\n" +
                                    "==================================" + "\n" +
                                    "Concert Details:\n" +
                                    "Title: " + title + "\n" +
                                    "Artist Name: " + artistName + "\n" +
                                    "Date: " + date + "\n" +
                                    "Time: " + time + "\n" +
                                    "Location: " + location + "\n" +
                                    "Description: " + description + "\n" +
                                    "==================================" + "\n" +
                                    "Total Booths: " + totalBooth + "\n" +
                                    "Booth Details:" + "\n" +
                                    "==================================");
                    for (int i = 0; i < totalBooth; i++) {
                        System.out.print("Booth " + (i + 1) + " Details:" + "\n");
                        System.out.print("Available Ticket: " + booths[i].getAvailableTicket() + "\n");
                        System.out.print("Ticket Price: " + booths[i].getPrice() + "\n");
                        System.out.print("Category Name: " + booths[i].getCatName() + "\n");
                        System.out.println();
                    }
                    Admin();
                    break;
                case 2:
                System.out.println("=======================================");
                for(int i=0; i<concert.size(); i++){
                    System.out.println("Concert\t:" + concert.get(i).getConcertInfo().getTitle());
                    Booth[] boothss = concert.get(i).getBooth();
                    for(int j=0;j<boothss.length;j++){
                        System.out.println("Total from Booth "+boothss[j].getCatName()+"\t:" + boothss[j].getTotal());
                    }
                    System.out.println("=======================================");
                }
                    break;
                case 3:
                
                System.out.println("ID\t\tNama");
                for (String key : customers.keySet()){
                    if(customers.get(key).getRole().equals("user")){
                        System.out.println(key +"\t\t"+customers.get(key).getName());
                    }
                }
                scn.nextLine();
                System.out.println("id customer : ");
                String id = scn.nextLine();
                Customer customer = customers.get(id);
                LinkedList<Transaction> transactions = customer.getTransactions();
                System.out.println("invoiceNum\t\tconcert\tbooth\tticketPrice\tTicketQuantity");
                for (int i = 0; i < transactions.size(); i++) {
                    if()
                    Transaction transaction1 = transactions.get(i);
                    Concert concert1 = concert.get(transaction1.getTickets().getConcert());
                    ConcertController.displayTicket(transaction1, concert1);
                }
                    break;
                case 4:
                break;
                default:
                    System.out.println("Invalid menu choice. Please select a valid menu option.");
                    Admin();
                    break;
            }
            
        System.out.println("============== ADMIN MENU ==============");
        System.out.println("1. Add Concerts\n2. Check Concert Income\n3. Check Customer's Transactions\n4. Exit");
        System.out.println("Choose Menu: ");
        menu = scn.nextInt();
        } 
    }

}
