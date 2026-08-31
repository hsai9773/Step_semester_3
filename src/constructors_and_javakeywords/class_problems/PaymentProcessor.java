package constructors_and_javakeywords.class_problems;
class M5FeeAccount {
}
class HostelFeeAccount extends M5FeeAccount {
}
public class PaymentProcessor {
    int hostelCount=0;
    int dayScholarCount=0;
    public void processPayment(M5FeeAccount account,double amount) {
        if(account instanceof HostelFeeAccount) {
            System.out.println("Paid in two installments (hostel account)");
            hostelCount++;
        } else {
            System.out.println("Paid in one go (day-scholar account)");
            dayScholarCount++;
        }
    }
    public void printCount() {
        System.out.println("Hostel accounts processed: "+hostelCount+" | Day-scholar accounts processed: "+dayScholarCount);
    }
    public static void main(String[] args) {
        M5FeeAccount[] accounts={new HostelFeeAccount(),new HostelFeeAccount(),new M5FeeAccount(),new M5FeeAccount()};
        double amount=60000;
        PaymentProcessor processor=new PaymentProcessor();
        for(int i=0;i<accounts.length;i++) {
            processor.processPayment(accounts[i],amount);
        }
        processor.printCount();
    }
}