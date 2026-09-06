package java_basics.assignment_problems;
import java.util.Scanner;
public class ExamHallSeatDuplicationChecker {
    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound=false;
        for(int i=0;i<seatNumbers.length;i++) {
            for(int j=i+1;j<seatNumbers.length;j++) {
                if(seatNumbers[i]==seatNumbers[j]) {
                    System.out.println("Duplicate seat number: "+seatNumbers[i]);
                    duplicateFound=true;
                }
            }
        }
        if(!duplicateFound) {
            System.out.println("No duplicate seat numbers found.");
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of seats: ");
        int n=sc.nextInt();
        int[] seatNumbers=new int[n];
        System.out.println("Enter seat numbers:");
        for(int i=0;i<n;i++) {
            seatNumbers[i]=sc.nextInt();
        }
        checkDuplicateSeats(seatNumbers);
    }
}