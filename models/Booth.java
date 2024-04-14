package models;

public class Booth {
    private int totalRow;
    private int totalColumn;
    private Seat[][] seats = new Seat[totalRow][totalColumn];
    private int availableTicket;
    private int price;

    public Booth(int totalRow, int totalColumn, Seat[][] seats, int availableTicket, int price) {
        this.totalRow = totalRow;
        this.totalColumn = totalColumn;
        this.seats = seats;
        this.availableTicket = availableTicket;
        this.price = price;
    }

    public int getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(int totalRow) {
        this.totalRow = totalRow;
    }

    public int getTotalColumn() {
        return totalColumn;
    }

    public void setTotalColumn(int totalColumn) {
        this.totalColumn = totalColumn;
    }

    public Seat[][] getSeats() {
        return seats;
    }

    public void setSeats(Seat[][] seats) {
        this.seats = seats;
    }

    public int getAvailableTicket() {
        return availableTicket;
    }

    public void setAvailableTicket(int availableTicket) {
        this.availableTicket = availableTicket;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
