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

    public static void importData() {
        // concert data
        Booth boothConcertA1 = new Booth(12, 1000000, "pink");
        Booth boothConcertA2 = new Booth(12, 1200000 , "red");
        Booth boothConcertB2 = new Booth(5, 3000000, "white");
        ConcertInfo concertInfo1 = new ConcertInfo("Bandung", "01/02/2024", "12:00", "bestTIme", "Ed Shereen",
                "the best concert you will ever had");
        ConcertInfo concertInfo2 = new ConcertInfo("Jakarta", "01/16/2024", "14:00", "Laufey Wordl Tour", "Laufey",
                "the second best concert you will ever had");
        concert.add(new Concert(concertInfo2, 0, new Booth[] { boothConcertA1, boothConcertA2 }));

        // customer data
        customers.put("001", new Customer("Reivel", "123", "082321534551", "0329 0234 2130 3210", "admin"));
        customers.put("002", new Customer("Peter", "123", "31290312", "38129321", "user"));
    
    }

    public static void main(String[] args) {
        importData();
        Login();
    }

    public static void Login() {
        System.out.println("masukan nama Anda");
        String nama = scn.nextLine();
        System.out.println("masukan Password");
        String pass = scn.nextLine();
        String cek = LoginController.loginCustomer(nama, pass, customers);
        if (cek.equalsIgnoreCase("admin")) {
            System.out.println("selamat datang admin");
            Admin();
        } else if (cek.equalsIgnoreCase("login")) {
            presentUserId = cek;
            System.out.println("maaf password akun anda salah");
            Login();
        } else if (cek.equalsIgnoreCase("register")) {
            System.out.println("maaf Anda belum membuat akun. silahkan register");
            Register();
        } else {    
            System.out.println("selamat datang " + nama);
            pilihConcert();
        }

    }

    public static void Register() {
        System.out.println("masukan nama Anda");
        String nama = scn.nextLine();
        System.out.println("masukan password");
        String pass = scn.nextLine();
        System.out.println("masukan nomor telepon Anda");
        String phoneNum = scn.nextLine();
        System.out.println("masukan nomor kartu kredit Anda");
        String cardNum = scn.nextLine();
        Customer newCustomer = RegisterController.registerCustomer(nama, pass, phoneNum, cardNum);
        customers.put(nama, newCustomer);
        System.out.println("Selamat Bergabung " + nama);
        presentUserId = nama;
        pilihConcert();
    }

    public static void pilihConcert() {
        System.out.println("===== Selamat Datang =======");
        System.out.println("Id\tTitle\t\tDate\t\tArtist");
        for (int i = 0; i < concert.size(); i++) {
            System.out.println(i + "  " + concert.get(i).getConcertInfo().getTitle() + "       "
                    + concert.get(i).getConcertInfo().getDate() + "       "
                    + concert.get(i).getConcertInfo().getArtistName());
            System.out.println("\n================================");
        }
        System.out.println("silahkan pilih Id Concert");
        int pilihConcert = scn.nextInt();
        if (concert.size() < pilihConcert && pilihConcert < 0) {
            System.out.println("maaf concert yang ada pilih tidak ada");
            pilihConcert();
        }else{
            pilihBooth(pilihConcert);
        }

    }
    public static void pilihBooth(int concertId){
        System.out.println("==============");
        System.out.println("booth id\t booth category\t price");
        Booth[] booths = concert.get(concertId).getBooth();
        for (int i = 0; i < booths.length; i++) {
            System.out.println(i + "\t" + booths[i].getCatName() +"\t"+ booths[i].getPrice());
        }
        System.out.println("masukan id category booth");
        int pilihCat = scn.nextInt();
        System.out.println("masukan banyak tiket yang ingin dibeli");
        int quantity = scn.nextInt();
        if (pilihCat > booths.length && pilihCat > 0) {
            System.out.println("maaf booth yang ada pilih tidak ada");
            pilihBooth(concertId);
        } else {
            transaction(concertId, pilihCat, quantity);
        }
    }
    public static void transaction(int concertId, int pilihBooth, int quantity) { //invoice number, ticket apa aja, quantity, total satuan, total smua
        System.out.println("apahkah anda yakin ? ");
        boolean confirmation = scn.nextBoolean();
        if (confirmation) {
            String invoice = "INV" + concertId+""+pilihBooth;
            Transaction createTransaction = new Transaction(invoice, new Ticket(concertId, pilihBooth, quantity));
            if (customers.get(presentUserId).getTransactions().isEmpty()) {
                LinkedList<Transaction> transactions = new LinkedList<>();
                transactions.add(createTransaction);
                customers.get(presentUserId).setTransactions(transactions);
            }else{
                LinkedList<Transaction> transactions = customers.get(presentUserId).getTransactions();
                transactions.add(createTransaction);
                customers.get(presentUserId).setTransactions(transactions);
            }
            System.out.println(customers.get(presentUserId).getTransactions().get(0).getInvoiceNumber());
        } else {
            pilihBooth(concertId);
        }
    }

    public static void Admin() {
        System.out.println("selamat datang admin");
    }

}
