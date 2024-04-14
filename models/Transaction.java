package models;

public class Transaction {
    private int invoiceNumber;
    private Ticket[] tickets = new Ticket[]{};

    public Transaction(int invoiceNumber, Ticket[] tickets) {
        this.invoiceNumber = invoiceNumber;
        this.tickets = tickets;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Ticket[] getTickets() {
        return tickets;
    }

    public void setTickets(Ticket[] tickets) {
        this.tickets = tickets;
    }
}
