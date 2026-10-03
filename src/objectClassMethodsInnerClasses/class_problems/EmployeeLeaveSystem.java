package objectClassMethodsInnerClasses.class_problems;

import java.util.Scanner;

abstract class Employee {

    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract boolean canTakeLeave(int days);
}

class FullTimeEmployee extends Employee {

    public FullTimeEmployee(String name) {
        super(name);
    }

    @Override
    public boolean canTakeLeave(int days) {
        return days <= 20;
    }
}

class PartTimeEmployee extends Employee {

    public PartTimeEmployee(String name) {
        super(name);
    }

    @Override
    public boolean canTakeLeave(int days) {
        return days <= 10;
    }
}

class Contractor extends Employee {

    public Contractor(String name) {
        super(name);
    }

    @Override
    public boolean canTakeLeave(int days) {
        return days <= 5;
    }
}

enum LeaveStatus {
    PENDING,
    APPROVED,
    REJECTED
}

class LeaveRequest {

    private Employee employee;
    private String startDate;
    private String endDate;
    private int days;
    private LeaveStatus status;

    public LeaveRequest(Employee employee, String startDate,
                        String endDate, int days) {

        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.days = days;
        this.status = LeaveStatus.PENDING;
    }

    public void approve() {

        if (status != LeaveStatus.PENDING) {
            System.out.println(
                "Cannot approve a request that is already processed."
            );
            return;
        }

        if (!employee.canTakeLeave(days)) {
            System.out.println("Leave policy does not allow this request.");
            return;
        }

        status = LeaveStatus.APPROVED;

        System.out.println(
            employee.getName() + "'s leave request approved."
        );
    }

    public void reject() {

        if (status != LeaveStatus.PENDING) {
            System.out.println(
                "Cannot reject a request that is already processed."
            );
            return;
        }

        status = LeaveStatus.REJECTED;

        System.out.println(
            employee.getName() + "'s leave request rejected."
        );
    }

    public void changeToPending() {

        if (status != LeaveStatus.PENDING) {

            System.out.println(
                "Cannot change leave request status from "
                + status + " to PENDING."
            );

            return;
        }

        status = LeaveStatus.PENDING;
    }

    public void display() {

        System.out.println("\nLeave Request");
        System.out.println("Employee: " + employee.getName());
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + endDate);
        System.out.println("Days: " + days);
        System.out.println("Status: " + status);
    }
}

public class EmployeeLeaveSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter employee type (FullTime/PartTime/Contractor): ");
        String type = sc.nextLine();

        System.out.print("Enter employee name: ");
        String name = sc.nextLine();

        Employee employee;

        if (type.equalsIgnoreCase("FullTime")) {
            employee = new FullTimeEmployee(name);
        } else if (type.equalsIgnoreCase("PartTime")) {
            employee = new PartTimeEmployee(name);
        } else {
            employee = new Contractor(name);
        }

        System.out.print("Enter start date: ");
        String startDate = sc.nextLine();

        System.out.print("Enter end date: ");
        String endDate = sc.nextLine();

        System.out.print("Enter number of leave days: ");
        int days = sc.nextInt();

        LeaveRequest request =
            new LeaveRequest(employee, startDate, endDate, days);

        System.out.println("\nLeave request submitted.");
        request.display();

        System.out.print(
            "\nEnter review decision (approve/reject): "
        );

        String decision = sc.next();

        if (decision.equalsIgnoreCase("approve")) {
            request.approve();
        } else {
            request.reject();
        }

        request.display();

        System.out.println("\nAttempting to change status to Pending...");
        request.changeToPending();

        request.display();

        sc.close();
    }
}