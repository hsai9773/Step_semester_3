package datastructures.class_problem;

import java.util.*;

interface Chargeable {
    void charge();
}

class Vehicle {
    String passNumber;
    String owner;
    String type;
    int fee;

    Vehicle(String passNumber, String owner, String type) {
        this.passNumber = passNumber;
        this.owner = owner;
        this.type = type;
        fee = (type.equals("Bike") || type.equals("EBike")) ? 300 : 1000;
    }

    void displayPass() {
        System.out.println(passNumber + " (" + type + ") pass fee " + fee);
    }
}

class ElectricVehicle extends Vehicle implements Chargeable {
    ElectricVehicle(String passNumber, String owner, String type) {
        super(passNumber, owner, type);
    }

    public void charge() {
        System.out.println(passNumber + " charging bay allotted");
    }
}

public class CampusVehiclePassSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Vehicle> vehicles = new HashMap<>();

        while (sc.hasNext()) {
            String operation = sc.next();

            if (operation.equals("PASS")) {
                String type = sc.next();
                String pass = sc.next();
                String owner = sc.next();

                Vehicle v;
                if (type.equals("EBike") || type.equals("ECar")) {
                    v = new ElectricVehicle(pass, owner, type);
                } else {
                    v = new Vehicle(pass, owner, type);
                }

                vehicles.put(pass, v);
                v.displayPass();

            } else if (operation.equals("CHARGE")) {
                String pass = sc.next();
                Vehicle v = vehicles.get(pass);

                if (v == null) {
                    System.out.println("Vehicle not found");
                } else if (v instanceof Chargeable) {
                    ((Chargeable) v).charge();
                } else {
                    System.out.println(pass + " rejected: charging unsupported");
                }
            }
        }

        sc.close();
    }
}