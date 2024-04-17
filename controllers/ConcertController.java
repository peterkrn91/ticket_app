package controllers;

import models.ConcertInfo;
import models.Concert;
import models.Booth;

public class ConcertController {
    public static Concert addConcert(ConcertInfo concertInfo, int totalBooth, Booth[] booths) {
        Concert concert = new Concert(concertInfo, totalBooth, booths);
        return concert;
    }
}
