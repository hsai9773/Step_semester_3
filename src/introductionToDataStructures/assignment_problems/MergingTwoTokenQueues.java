package introductionToDataStructures.assignment_problems;

import java.util.*;

public class MergingTwoTokenQueues {

    public static ArrayList<Integer> mergeTokens(int[] a, int[] b) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                result.add(a[i++]);
            } else {
                result.add(b[j++]);
            }
        }

        while (i < a.length) {
            result.add(a[i++]);
        }

        while (j < b.length) {
            result.add(b[j++]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] counterA = {3, 8, 15, 20};
        int[] counterB = {5, 8, 12};

        System.out.println(mergeTokens(counterA, counterB));
    }
}