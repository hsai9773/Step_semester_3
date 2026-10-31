package datastructures.class_problem;

import java.util.*;

public class ClassMarkGridAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> names = new ArrayList<>();
        ArrayList<int[]> marksList = new ArrayList<>();

        while (sc.hasNext()) {
            String name = sc.next();
            String line = sc.nextLine().trim();
            line = line.replace("[", "").replace("]", "").replace(",", "");

            String[] values = line.split("\\s+");
            int[] marks = new int[3];

            for (int i = 0; i < 3; i++) {
                marks[i] = Integer.parseInt(values[i]);
            }

            names.add(name);
            marksList.add(marks);
        }

        int count = names.size();
        int[][] marks = new int[count][3];
        int[] totals = new int[count];
        int[] subjectTotals = new int[3];

        int topper = 0;

        for (int i = 0; i < count; i++) {
            marks[i] = marksList.get(i);

            for (int j = 0; j < 3; j++) {
                totals[i] += marks[i][j];
                subjectTotals[j] += marks[i][j];
            }

            if (totals[i] > totals[topper]) {
                topper = i;
            }
        }

        System.out.print("Totals ");
        for (int i = 0; i < count; i++) {
            System.out.print(names.get(i) + " " + totals[i]);
            if (i < count - 1) System.out.print(", ");
        }

        System.out.printf("%naverages %.2f, %.2f, %.2f%n",
            (double) subjectTotals[0] / count,
            (double) subjectTotals[1] / count,
            (double) subjectTotals[2] / count);

        System.out.println("topper " + names.get(topper) + " (" + totals[topper] + ")");
        sc.close();
    }
}