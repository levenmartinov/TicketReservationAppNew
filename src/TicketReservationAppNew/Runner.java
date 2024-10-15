package TicketReservationAppNew;

public class Runner {
    public static void main(String[] args) {

        //1 otobus olustur
        Bus bus = new Bus("16NL0107", 41, "London to Liverpool", "07:00 PM");

        //2 yolcu olustur
        Passenger passenger = new Passenger("Michel Jordan", 38);

        //3 Koltuk uygunlugunu kontrol et ve bilet ciktisi al
        String seatNo = "13";
        if (bus.checkAvailability(seatNo)) {
            //koltuk reserve
            bus.reserveSeat(seatNo);

            //bilet olustur
            Ticket ticket = new Ticket(444, 2, seatNo, bus, passenger);
            ticket.setPrice(passenger.getAge(), true); //Peak time (yogun zaman) ture
            ticket.printTicket();

        } else {
            System.out.println("Secmis oldugunuz koltuk doludur!!!");
        }
    }
}
