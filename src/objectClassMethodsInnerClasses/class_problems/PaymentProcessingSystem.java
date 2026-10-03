package objectClassMethodsInnerClasses.class_problems;

import java.util.*;

class Product {

    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}

class OrderItem {

    private Product product;
    private int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotal() {
        return product.getPrice() * quantity;
    }

    public void display() {
        System.out.println(
            product.getName()
            + " x "
            + quantity
            + " = $"
            + getTotal()
        );
    }
}

interface PaymentMethod {

    boolean processPayment(double amount);
}

class CreditCardPayment implements PaymentMethod {

    @Override
    public boolean processPayment(double amount) {

        System.out.println(
            "Processing Credit Card payment..."
        );

        return true;
    }
}

class PayPalPayment implements PaymentMethod {

    @Override
    public boolean processPayment(double amount) {

        System.out.println(
            "Processing PayPal payment..."
        );

        return false;
    }
}

class BankTransferPayment implements PaymentMethod {

    @Override
    public boolean processPayment(double amount) {

        System.out.println(
            "Processing Bank Transfer..."
        );

        return true;
    }
}

class Order {

    private String orderId;

    private ArrayList<OrderItem> items;

    private String status;

    public Order(String orderId) {

        this.orderId = orderId;
        items = new ArrayList<>();

        status = "Pending";
    }

    public void addProduct(
            Product product,
            int quantity) {

        items.add(
            new OrderItem(product, quantity)
        );
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double calculateTotal() {

        double total = 0;

        for (OrderItem item : items) {
            total += item.getTotal();
        }

        return total;
    }

    public void pay(PaymentMethod paymentMethod) {

        if (items.isEmpty()) {

            System.out.println(
                "Cannot process payment for an empty order."
            );

            return;
        }

        double amount = calculateTotal();

        System.out.println(
            "\nPayment initiated for Order "
            + orderId
        );

        System.out.println(
            "Amount: $" + amount
        );

        boolean success =
            paymentMethod.processPayment(amount);

        if (success) {

            status = "Paid";

            System.out.println(
                "Payment successful."
            );

        } else {

            System.out.println(
                "Payment failed."
            );
        }

        System.out.println(
            "Order status: " + status
        );
    }

    public void displayOrder() {

        System.out.println(
            "\nOrder ID: " + orderId
        );

        System.out.println("Items:");

        for (OrderItem item : items) {
            item.display();
        }

        System.out.println(
            "Total: $" + calculateTotal()
        );

        System.out.println(
            "Status: " + status
        );
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

public class PaymentProcessingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");

        Customer customer =
            new Customer(sc.nextLine());

        System.out.println(
            "\nOrder created for "
            + customer.getName()
        );

        Order order =
            new Order("ORD001");

        System.out.print(
            "Enter product name: "
        );

        String productName =
            sc.nextLine();

        System.out.print(
            "Enter product price: "
        );

        double price =
            sc.nextDouble();

        System.out.print(
            "Enter quantity: "
        );

        int quantity =
            sc.nextInt();

        Product product =
            new Product(
                productName,
                price
            );

        order.addProduct(
            product,
            quantity
        );

        order.displayOrder();

        System.out.println(
            "\nChoose payment method:"
        );

        System.out.println(
            "1. Credit Card"
        );

        System.out.println(
            "2. PayPal"
        );

        System.out.println(
            "3. Bank Transfer"
        );

        int choice =
            sc.nextInt();

        PaymentMethod paymentMethod;

        if (choice == 1) {

            paymentMethod =
                new CreditCardPayment();

        } else if (choice == 2) {

            paymentMethod =
                new PayPalPayment();

        } else {

            paymentMethod =
                new BankTransferPayment();
        }

        order.pay(paymentMethod);

        sc.close();
    }
}