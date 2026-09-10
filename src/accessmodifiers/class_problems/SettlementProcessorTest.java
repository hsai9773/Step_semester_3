package accessmodifiers.class_problems;

public class SettlementProcessorTest {

    public static void main(String[] args) {

        BookingReceipt individual = new BookingReceipt(
                "B101",
                "Alice",
                new String[]{"A1", "A2"}
        );

        BookingReceipt group = new GroupBookingReceipt(
                "B102",
                "Bob",
                new String[]{"B1", "B2", "B3"},
                3
        );

        BookingReceipt[] receipts = {
                individual,
                group,
                null
        };

        System.out.println(
                SettlementProcessor.processNightlySettlement(receipts)
        );
    }
}