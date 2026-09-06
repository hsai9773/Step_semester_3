package java_basics.assignment_problems;
import java.util.Scanner;
public class TrafficSignalStreakAnalyzer {
    public static void findLongestStreak(String signalLog) {
        char longestColor=signalLog.charAt(0);
        int longest=1;
        char currentColor=signalLog.charAt(0);
        int current=1;
        for(int i=1;i<signalLog.length();i++) {
            if(signalLog.charAt(i)==currentColor) {
                current++;
            } else {
                currentColor=signalLog.charAt(i);
                current=1;
            }
            if(current>longest) {
                longest=current;
                longestColor=currentColor;
            }
        }
        System.out.println("Longest streak color: "+longestColor);
        System.out.println("Longest streak length: "+longest);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter traffic signal log: ");
        String signalLog=sc.nextLine();
        findLongestStreak(signalLog);
    }
}