package accessmodifiers.class_problems;

public class CineScreenTest {

    public static void main(String[] args) {

        CineScreen screen = new CineScreen(3);

        System.out.println(screen.getSeatsAvailable());

        screen.bookSeat();
        System.out.println(screen.getSeatsAvailable());

        screen.bookSeat();
        screen.bookSeat();
        System.out.println(screen.getSeatsAvailable());

        screen.bookSeat();
        System.out.println(screen.getSeatsAvailable());

        screen.cancelBooking();
        System.out.println(screen.getSeatsAvailable());

        screen.cancelBooking();
        screen.cancelBooking();
        screen.cancelBooking();
        System.out.println(screen.getSeatsAvailable());
    }
}