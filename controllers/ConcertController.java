package controllers;

import java.util.HashMap;
import models.ConcertInfo;
import models.Ticket;
import models.Transaction;
import models.Concert;
import models.Customer;

import java.util.LinkedList;

import models.Booth;

public class ConcertController {
    public static Concert addConcert(ConcertInfo concertInfo, int totalBooth, Booth[] booths) {
        Concert concert = new Concert(concertInfo, totalBooth, booths);
        return concert;
    }
    public static void displayTicket(Transaction transactions, Concert concert){
        System.out.println(transactions.getInvoiceNumber() + 
                "\t\t" +concert.getConcertInfo().getTitle() + 
                "\t\t" + concert.getBooth()[transactions.getTickets().getBooth()].getCatName() +
                "\t\t" + concert.getBooth()[transactions.getTickets().getBooth()].getPrice() +
                "\t\t"+ transactions.getTickets().getQuantity() );
    }
    public static void createTransaction(String invoice, int concertID, int boothCategory, int quantity, HashMap<String,Customer> customers, String presentUserId, Booth booth){
        Transaction createTransaction = new Transaction(invoice,
                    new Ticket(concertID, boothCategory, quantity));
        LinkedList<Transaction> userTransactions = customers.get(presentUserId).getTransactions();
        if (userTransactions == null) {
            userTransactions = new LinkedList<>();
        }
        userTransactions.add(createTransaction);
        customers.get(presentUserId).setTransactions(userTransactions);
        booth.addTotal(quantity * booth.getPrice());
    }
}
