package TicketReservationAppNew;

public class Ticket {

    private double distance;
    private int typeNo; //1 Tek yon, 2 Gidis-Donus
    private String seatNo;
    private double price;
    private Bus bus;
    private Passenger passenger;

    //Fiyati hesaplamak icin

    public Ticket(double distance, int typeNo, String seatNo, Bus bus, Passenger passenger) {
        this.distance = distance;
        this.typeNo = typeNo;
        this.seatNo = seatNo;
        this.bus = bus;
        this.passenger = passenger;
    }

    //Fiyati hesaplamak icin

    public void setPrice(int age, boolean isPeakTime) {
        double total =0;
        int seat = Integer.parseInt(this.seatNo);

        // Yolculuk tipi ve koltuk numarasına göre fiyatlandırma
        switch (this.typeNo) {
            case 1: //Tek yon
                total = (seat % 3 == 0 ) ? this.distance * 1.2 : this.distance * 1;
                break;
            case 2: //Gidis-Donus
                total = (seat% 3 == 0 ) ? this.distance * 2.4 : this.distance * 2;
                total *= 0.8; //Gidis-Donus indrimi
        }

        //Yasa gore indirim
        if (age < 12) {
            total *= 0.5; //12 yas altina%50 indrim
        } else if (age > 65) {
            total *= 0.7; //65 yasustune %30 indirim
        }

        //Yogun zaman fiyat artisi
        if (isPeakTime) {
            total *= 1.25; //Yogun zamanlarda %25 artis
        }

        this.price = total;
    }

    //Bilet ciktisi alma


    public void printTicket() {
        System.out.println("*".repeat(42));
        System.out.println(" --- Bilet Detayları --- ");
        System.out.println("Yolcu Adı       : " + this.passenger.getName());
        System.out.println("Yolcu Yaşı      : " + this.passenger.getAge());
        System.out.println("Otobüs Plakası  : " + this.bus.getNumberPlate());
        System.out.println("Rota            : " + this.bus.getRoute());
        System.out.println("Kalkış Saati    : " + this.bus.getDepartureTime());
        System.out.println("Mesafe (KM)     : " + this.distance);
        System.out.println("Yolculuk Tipi   : " + (this.typeNo == 1 ? "Tek Yön" : "Gidiş-Dönüş"));
        System.out.println("Koltuk No       : " + this.seatNo);
        System.out.println("Toplam Fiyat    : " + this.price + " TL");
        System.out.println("İyi Yolculuklar Dileriz!");
        System.out.println("*".repeat(42));

    }
}