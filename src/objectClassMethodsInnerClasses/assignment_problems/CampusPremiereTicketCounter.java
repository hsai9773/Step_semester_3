package objectClassMethodsInnerClasses.assignment_problems;

import java.time.*;
import java.util.*;

abstract class Seat {
    String number;
    Seat(String number) { this.number = number; }
    abstract double getPrice();
}

class RegularSeat extends Seat {
    RegularSeat(String n) { super(n); }
    double getPrice() { return 150; }
}

class PremiumSeat extends Seat {
    PremiumSeat(String n) { super(n); }
    double getPrice() { return 250; }
}

class ReclinerSeat extends Seat {
    ReclinerSeat(String n) { super(n); }
    double getPrice() { return 400; }
}

class Customer {
    String name;
    Customer(String name) { this.name = name; }
}

class Show {
    String time;
    Set<String> booked = new HashSet<>();

    Show(String time) { this.time = time; }

    boolean available(String seat) { return !booked.contains(seat); }
}

class Booking {
    Customer customer;
    Show show;
    List<Seat> seats;

    Booking(Customer c, Show s, List<Seat> seats) {
        customer = c; show = s; this.seats = seats;
    }

    double total() {
        double sum = 0;
        for (Seat s : seats) sum += s.getPrice();
        return sum;
    }

    void cancel() {
        for (Seat s : seats) show.booked.remove(s.number);
        System.out.println(customer.name + " cancelled; seats released.");
    }
}

public class CampusPremiereTicketCounter {
    static boolean book(Customer c, Show show, Seat... seats) {
        if (seats.length > 6) {
            System.out.println("Maximum 6 seats allowed.");
            return false;
        }

        for (Seat s : seats) {
            if (!show.available(s.number)) {
                System.out.println(s.number + " already booked.");
                return false;
            }
        }

        for (Seat s : seats) show.booked.add(s.number);

        List<Seat> list = Arrays.asList(seats);
        Booking b = new Booking(c, show, list);

        System.out.println(c.name + " booking confirmed " +
                list.stream().map(x -> x.number).toList() +
                " total ₹" + String.format("%.0f", b.total()) + ".");
        return true;
    }

    public static void main(String[] args) {
        Show show = new Show("7 PM");
        Customer asha = new Customer("Asha"), ravi = new Customer("Ravi"), neha = new Customer("Neha");

        Seat a1 = new RegularSeat("A1"), a2 = new RegularSeat("A2");
        Seat f5 = new PremiumSeat("F5"), r1 = new ReclinerSeat("R1");

        book(asha, show, a1, a2, f5);
        book(ravi, show, a2);
        book(ravi, show, r1);

        Booking ashaBooking = new Booking(asha, show, Arrays.asList(a1, a2, f5));
        ashaBooking.cancel();

        book(neha, show, a2);
    }
}