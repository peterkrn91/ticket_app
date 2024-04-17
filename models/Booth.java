package models;

public class Booth {
    private int availableTicket;
    private int price;
    private String catName;

    public Booth(int availableTicket, int price, String catName) {
        this.availableTicket = availableTicket;
        this.price = price;
        this.catName = catName;
    }

    public String getCatName(){
        return catName;
    }
    public void setCatName(String catName){
        this.catName = catName;
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
