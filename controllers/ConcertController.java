package controllers;

import models.ConcertInfo;
import models.Transaction;
import models.Concert;
import models.Booth;

public class ConcertController {
    public static Concert addConcert(ConcertInfo concertInfo, int totalBooth, Booth[] booths) {
        Concert concert = new Concert(concertInfo, totalBooth, booths);
        return concert;
    }
    public static int countBoothIncome(ArrayList<Concert> concert, int indexBooth, int indexConcert){
        for()
    }
    public static void displayTicket(Transaction transactions, Concert concert){
        System.out.println(transactions.getInvoiceNumber() + 
                "\t\t" +concert.getConcertInfo().getTitle() + 
                "\t\t" + concert.getBooth()[transactions.getTickets().getBooth()].getCatName() +
                "\t\t" + concert.getBooth()[transactions.getTickets().getBooth()].getPrice() +
                "\t\t"+ transactions.getTickets().getQuantity() );
    }
}
