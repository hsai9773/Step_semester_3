package oop.assignment_problems;
public class Employee1 {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;
    public Employee1(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }
    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
    public static void main(String[] args) {

        Employee1 employee1 = new Employee1("Divya", 65000);
        Employee1 employee2 = new Employee1("Arjun", 45000);
        Employee1 employee3 = new Employee1("Priya", 55000);
        System.out.println("3 Employee objects created");
        Employee1.printCompanyInfo();
    }
}