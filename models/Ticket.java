package models;

public class Ticket {
    private int concert;
    private int booth;
    private int quantity;
    private int price;

    public Ticket(int concert, int booth, int quantity) {
        this.concert = concert;
        this.booth = booth;
        this.quantity = quantity;
    }

    public int getConcert() {
        return concert;
    }

    public void setConcert(int concert) {
        this.concert = concert;
    }

    public int getBooth() {
        return booth;
    }

    public void setBooth(int booth) {
        this.booth = booth;
    }
}
