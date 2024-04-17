package models;

public class Transaction {
    private String invoiceNumber;
    private Ticket tickets;

    public Transaction(String invoiceNumber, Ticket ticket) {
        this.invoiceNumber = invoiceNumber;
        this.tickets = ticket;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Ticket getTickets() {
        return tickets;
    }

    public void setTickets(Ticket tickets) {
        this.tickets = tickets;
    }
}
