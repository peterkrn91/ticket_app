package models;

public class Concert {
    private ConcertInfo concertInfo;
    private int totalBooth;
    private Booth[] booth = new Booth[]{};
    public Concert(ConcertInfo concertInfo, int totalBooth, Booth[] booth) {
        this.concertInfo = concertInfo;
        this.totalBooth = totalBooth;
        this.booth = booth;
    }

    public ConcertInfo getConcertInfo() {
        return concertInfo;
    }

    public void setConcertInfo(ConcertInfo concertInfo) {
        this.concertInfo = concertInfo;
    }

    public int getTotalBooth() {
        return totalBooth;
    }

    public void setTotalBooth(int totalBooth) {
        this.totalBooth = totalBooth;
    }

    public Booth[] getBooth() {
        return booth;
    }

    public void setBooth(Booth[] booth) {
        this.booth = booth;
    }
}