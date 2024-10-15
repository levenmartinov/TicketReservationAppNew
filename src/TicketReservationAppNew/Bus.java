package TicketReservationAppNew;

import java.util.ArrayList;
import java.util.List;

public class Bus {

    private String numberPlate;
    private int numberOfSeat;
    private List<String> seats = new ArrayList<>(); //Koltuklar number icin
    private List<Boolean> seatAvailability = new ArrayList<>(); //Koltuklar dolu mu bosmu mu
    private String route;
    private String departureTime;

    //Constructor

    public Bus(String numberPlate, int numberOfSeat, String route, String departureTime) {
        this.numberPlate = numberPlate;
        this.numberOfSeat = numberOfSeat;
        this.route = route;
        this.departureTime = departureTime;

        // Koltuk numaralarını ve uygunluk durumlarını başlat
        for (int i = 1; i <= this.numberOfSeat; i++) {
            this.seats.add(String.valueOf(i)); //koltuk numarasi ekle
            this.seatAvailability.add(true); //Ilk once tum koltuklar bos
        }
    }

    //Koltuklar uygun mu kontrolu

    public boolean checkAvailability(String seatNo) {
        int seatIndex = Integer.parseInt(seatNo) - 1; //koltuk numarasini index donusturduk
        return this.seatAvailability.get(seatIndex); //True ise koltuk bos
    }

    //Koltuk reserve et
    public void reserveSeat(String seatNo) {
        int seatIndex = Integer.parseInt(seatNo) - 1;
        this.seatAvailability.set(seatIndex, false); // koltuk dolu isaretlenir
    }

    public String getRoute() {
        return route;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }
}
