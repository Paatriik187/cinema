package patrik.smolicek.cinema;

public class Customer {
    int Seat;
    String Name;

    public Customer(){}
    public Customer(int customer, String name) {
        Seat = customer;
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getSeat() {
        return Seat;
    }

    public void setSeat(int seat) {
        Seat = seat;}

    @Override
    public String toString() {
        return Seat +"|"+ Name;
    }
}
