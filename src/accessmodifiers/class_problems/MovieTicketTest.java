package accessmodifiers.class_problems;

public class MovieTicketTest {

    public static void main(String[] args) {

        MovieTicket ticket = new MovieTicket();

        ticket.screenId = "SCREEN-1";
        ticket.ticketPrice = 250.0;
        ticket.movieTitle = "Avengers";

        System.out.println(ticket.screenId);
        System.out.println(ticket.ticketPrice);
        System.out.println(ticket.movieTitle);
    }
}