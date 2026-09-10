package accessmodifiers.class_problems;

public class BookingReceipt {

    private final String bookingId;
    private final String customerName;
    private final String[] seatNumbers;

    public BookingReceipt(String bookingId, String customerName, String[] seatNumbers) {
        this.bookingId = bookingId;
        this.customerName = customerName;
        this.seatNumbers = seatNumbers.clone();
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String[] getSeatNumbers() {
        return seatNumbers.clone();
    }

    public BookingReceipt withUpdatedSeat(int index, String newSeat) {
        String[] updatedSeats = seatNumbers.clone();
        updatedSeats[index] = newSeat;

        return new BookingReceipt(bookingId, customerName, updatedSeats);
    }
}