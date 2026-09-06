package java_basics.assignment_problems;
import java.util.Scanner;
public class WareHouseInventoryBalancer {
    public static void analyzeInventory(int[] sectionA,int[] sectionB) {
        int totalA=0;
        int totalB=0;
        int max=sectionA[0];
        int section=1;
        int index=0;
        for(int i=0;i<sectionA.length;i++) {
            totalA+=sectionA[i];
            if(sectionA[i]>max) {
                max=sectionA[i];
                section=1;
                index=i;
            }
        }
        for(int i=0;i<sectionB.length;i++) {
            totalB+=sectionB[i];
            if(sectionB[i]>max) {
                max=sectionB[i];
                section=2;
                index=i;
            }
        }
        System.out.println("Total inventory in Section A: "+totalA);
        System.out.println("Total inventory in Section B: "+totalB);
        if(totalA==totalB) {
            System.out.println("Inventory is balanced.");
        } else {
            System.out.println("Inventory is not balanced.");
        }
        System.out.println("Maximum inventory: "+max);
        System.out.println("Section: "+section);
        System.out.println("Item: "+(index+1));
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of items: ");
        int n=sc.nextInt();
        int[] sectionA=new int[n];
        int[] sectionB=new int[n];
        System.out.println("Enter Section A inventory:");
        for(int i=0;i<n;i++) {
            sectionA[i]=sc.nextInt();
        }
        System.out.println("Enter Section B inventory:");
        for(int i=0;i<n;i++) {
            sectionB[i]=sc.nextInt();
        }
        analyzeInventory(sectionA,sectionB);
    }
}