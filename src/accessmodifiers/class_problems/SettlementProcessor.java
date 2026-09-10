package accessmodifiers.class_problems;

public class SettlementProcessor {

    public static String processNightlySettlement(BookingReceipt[] receipts) {

        int processed = 0;
        int nullSkipped = 0;
        int groupCount = 0;
        int individualCount = 0;

        for (BookingReceipt receipt : receipts) {

            if (receipt == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (receipt instanceof GroupBookingReceipt) {
                groupCount++;
            } else {
                individualCount++;
            }
        }

        return processed + " processed | "
                + nullSkipped + " null skipped | "
                + groupCount + " group | "
                + individualCount + " individual";
    }
}