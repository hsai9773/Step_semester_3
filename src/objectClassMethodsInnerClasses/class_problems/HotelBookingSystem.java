package objectClassMethodsInnerClasses.class_problems;
import java.time.LocalDate;
import java.util.*;
abstract class Room {
    protected int roomNumber;
    protected String roomType;
    public Room(int roomNumber, String roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
    }
    public abstract double calculatePrice(int days);
    public int getRoomNumber() {
        return roomNumber;
    }
    public String getRoomType() {
        return roomType;
    }
}
class StandardRoom extends Room {
    public StandardRoom(int roomNumber) {
        super(roomNumber, "Standard");
    }
    @Override
    public double calculatePrice(int days) {
        return days * 100;
    }
}

class DeluxeRoom extends Room {

    public DeluxeRoom(int roomNumber) {
        super(roomNumber, "Deluxe");
    }

    @Override
    public double calculatePrice(int days) {
        return days * 150;
    }
}

class Suite extends Room {

    public Suite(int roomNumber) {
        super(roomNumber, "Suite");
    }

    @Override
    public double calculatePrice(int days) {
        return days * 250;
    }
}

class Customer {

    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Reservation {

    private Customer customer;
    private Room room;

    private LocalDate startDate;
    private LocalDate endDate;

    private boolean cancelled;

    public Reservation(
            Customer customer,
            Room room,
            LocalDate startDate,
            LocalDate endDate) {

        this.customer = customer;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cancelled = false;
    }

    public boolean overlaps(
            LocalDate start,
            LocalDate end) {

        if (cancelled) {
            return false;
        }

        return start.isBefore(endDate)
                && end.isAfter(startDate);
    }

    public void cancel(LocalDate cancellationDeadline) {

        LocalDate today = LocalDate.now();

        if (today.isBefore(cancellationDeadline)
                || today.isEqual(cancellationDeadline)) {

            cancelled = true;

            System.out.println(
                "Reservation cancelled successfully."
            );

        } else {

            System.out.println(
                "Cancellation deadline has passed."
            );
        }
    }

    public double calculatePrice() {

        long days =
            java.time.temporal.ChronoUnit.DAYS.between(
                startDate,
                endDate
            );

        return room.calculatePrice((int) days);
    }

    public Room getRoom() {
        return room;
    }

    public void display() {

        System.out.println(
            "Customer: " + customer.getName()
        );

        System.out.println(
            "Room: "
            + room.getRoomNumber()
            + " (" + room.getRoomType() + ")"
        );

        System.out.println(
            "Dates: "
            + startDate
            + " to "
            + endDate
        );

        System.out.println(
            "Price: $" + calculatePrice()
        );
    }
}

class Hotel {

    private ArrayList<Room> rooms;
    private ArrayList<Reservation> reservations;

    public Hotel() {

        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public boolean isAvailable(
            Room room,
            LocalDate startDate,
            LocalDate endDate) {

        for (Reservation reservation : reservations) {

            if (reservation.getRoom() == room
                    && reservation.overlaps(
                        startDate,
                        endDate)) {

                return false;
            }
        }

        return true;
    }

    public Reservation makeReservation(
            Customer customer,
            Room room,
            LocalDate startDate,
            LocalDate endDate) {

        if (!isAvailable(room, startDate, endDate)) {

            System.out.println(
                "Room "
                + room.getRoomNumber()
                + " is not available."
            );

            return null;
        }

        Reservation reservation =
            new Reservation(
                customer,
                room,
                startDate,
                endDate
            );

        reservations.add(reservation);

        System.out.println(
            "Reservation confirmed."
        );

        reservation.display();

        return reservation;
    }
}

public class HotelBookingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Hotel hotel = new Hotel();

        Room standard =
            new StandardRoom(101);

        Room deluxe =
            new DeluxeRoom(201);

        Room suite =
            new Suite(301);

        hotel.addRoom(standard);
        hotel.addRoom(deluxe);
        hotel.addRoom(suite);

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        Customer customer =
            new Customer(name);

        System.out.print(
            "Enter room type (Standard/Deluxe/Suite): "
        );

        String type = sc.nextLine();

        Room selectedRoom;

        if (type.equalsIgnoreCase("Standard")) {
            selectedRoom = standard;
        } else if (type.equalsIgnoreCase("Deluxe")) {
            selectedRoom = deluxe;
        } else {
            selectedRoom = suite;
        }

        System.out.print(
            "Enter start date (YYYY-MM-DD): "
        );

        LocalDate startDate =
            LocalDate.parse(sc.nextLine());

        System.out.print(
            "Enter end date (YYYY-MM-DD): "
        );

        LocalDate endDate =
            LocalDate.parse(sc.nextLine());

        System.out.println("\nChecking availability...");

        Reservation reservation =
            hotel.makeReservation(
                customer,
                selectedRoom,
                startDate,
                endDate
            );

        if (reservation != null) {

            System.out.println(
                "\nReservation created successfully."
            );

            System.out.print(
                "Enter cancellation deadline (YYYY-MM-DD): "
            );

            LocalDate deadline =
                LocalDate.parse(sc.nextLine());

            System.out.println(
                "\nAttempting cancellation..."
            );

            reservation.cancel(deadline);
        }

        sc.close();
    }
}
