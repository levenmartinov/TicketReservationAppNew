package TicketReservationAppNew;

public class Passenger {

    private  String name;
    private int age;

    //Constructor

    public Passenger(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // getter methods

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // setter methods

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }




}
