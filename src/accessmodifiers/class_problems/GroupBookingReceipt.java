package accessmodifiers.class_problems;

public class GroupBookingReceipt extends BookingReceipt {

    private final int groupSize;

    public GroupBookingReceipt(String bookingId, String customerName, String[] seatNumbers, int groupSize) {
        super(bookingId, customerName, seatNumbers);
        this.groupSize = groupSize;
    }

    public int getGroupSize() {
        return groupSize;
    }
}