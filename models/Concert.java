package models;

public class Concert {
    private ConcertInfo concertInfo;
    private int totalBooth;
    private Booth[] booths = new Booth[] {};

    public Concert(ConcertInfo concertInfo, int totalBooth, Booth[] booths) {
        this.concertInfo = concertInfo;
        this.totalBooth = totalBooth;
        this.booths = booths;
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
        return booths;
    }

    public void setBooth(Booth[] booths) {
        this.booths = booths;
    }
}