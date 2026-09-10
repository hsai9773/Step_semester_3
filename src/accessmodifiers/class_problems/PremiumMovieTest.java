package accessmodifiers.class_problems;

public class PremiumMovieTest {

    public static void main(String[] args) {

        PremiumMovieTicket ticket = new PremiumMovieTicket();

        ticket.ticketPrice = 500.0;

        ticket.checkAccess();
    }
}