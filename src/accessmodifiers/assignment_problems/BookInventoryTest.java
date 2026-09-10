package accessmodifiers.assignment_problems;

public class BookInventoryTest {

    public static void main(String[] args) {

        BookInventory inventory = new BookInventory(3);

        inventory.checkOut();
        inventory.checkOut();
        inventory.checkOut();
        inventory.checkOut();

        System.out.println(inventory.getCopiesAvailable());

        inventory.checkIn();
        inventory.checkIn();
        inventory.checkIn();
        inventory.checkIn();

        System.out.println(inventory.getCopiesAvailable());
    }
}