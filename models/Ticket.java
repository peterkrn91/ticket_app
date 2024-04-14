package models;

public class Ticket {
    private int concert;
    private int booth;
    private int row;
    private int column;

    public Ticket(int concert, int booth, int row, int column) {
        this.concert = concert;
        this.booth = booth;
        this.row = row;
        this.column = column;
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

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
