package objectClassMethodsInnerClasses.class_problems;
import java.util.Scanner;
abstract class Vehicle {
    protected String vehicleId;
    protected String vehicleType;
    protected boolean available;
    public Vehicle(String vehicleId, String vehicleType) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
        this.available = true;
    }
    public abstract double calculateCharge(int days);
    public boolean isAvailable() {
        return available;
    }
    public void rentVehicle() {
        available = false;
    }
    public void returnVehicle() {
        available = true;
    }
    public String getVehicleId() {
        return vehicleId;
    }
    public String getVehicleType() {
        return vehicleType;
    }
}
class Sedan extends Vehicle {
    public Sedan(String vehicleId) {
        super(vehicleId, "Sedan");
    }
    @Override
    public double calculateCharge(int days) {
        return days * 50;
    }
}
class SUV extends Vehicle {
    public SUV(String vehicleId) {
        super(vehicleId, "SUV");
    }
    @Override
    public double calculateCharge(int days) {
        return days * 80;
    }
}
class Truck extends Vehicle {
    public Truck(String vehicleId) {
        super(vehicleId, "Truck");
    }
    @Override
    public double calculateCharge(int days) {
        return days * 100;
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
class Rental {
    private Customer customer;
    private Vehicle vehicle;
    private int days;
    private double charge;
    public Rental(Customer customer, Vehicle vehicle, int days) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.days = days;
        this.charge = vehicle.calculateCharge(days);
    }
    public void displayRental() {
        System.out.println("Vehicle: " + vehicle.getVehicleId());
        System.out.println("Customer: " + customer.getName());
        System.out.println("Days: " + days);
        System.out.println("Rental charge: $" + charge);
    }
}
public class VehicleRentalSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter customer 1 name: ");
        Customer customer1 = new Customer(sc.nextLine());
        System.out.print("Enter vehicle type (Sedan/SUV/Truck): ");
        String type1 = sc.nextLine();
        System.out.print("Enter vehicle ID: ");
        String id1 = sc.nextLine();
        Vehicle vehicle;
        if (type1.equalsIgnoreCase("Sedan")) {
            vehicle = new Sedan(id1);
        } else if (type1.equalsIgnoreCase("SUV")) {
            vehicle = new SUV(id1);
        } else {
            vehicle = new Truck(id1);
        }
        System.out.print("Enter rental days: ");
        int days1 = sc.nextInt();
        sc.nextLine();
        if (vehicle.isAvailable()) {
            vehicle.rentVehicle();
            Rental rental = new Rental(customer1, vehicle, days1);
            System.out.println("\nVehicle rented successfully.");
            rental.displayRental();
        } else {
            System.out.println("Vehicle is currently unavailable.");
        }
        System.out.print("\nEnter customer 2 name: ");
        Customer customer2 = new Customer(sc.nextLine());
        System.out.print("Enter rental days for customer 2: ");
        int days2 = sc.nextInt();
        if (vehicle.isAvailable()) {
            vehicle.rentVehicle();
            Rental rental2 = new Rental(customer2, vehicle, days2);
            System.out.println("Vehicle rented successfully.");
            rental2.displayRental();
        } else {
            System.out.println("Vehicle is currently unavailable.");
        }
        System.out.println("\nReturning vehicle...");
        vehicle.returnVehicle();
        System.out.println("Vehicle returned successfully.");
        sc.close();
    }
}