package introductionToDataStructures.assignment_problems;
import java.util.*;

public class MostPopularCanteenOrder {

    public static void mostPopular(String[] orders) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String item : orders) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        String bestItem = orders[0];
        int bestCount = map.get(bestItem);

        for (String item : orders) {
            int count = map.get(item);

            if (count > bestCount) {
                bestItem = item;
                bestCount = count;
            }
        }

        System.out.println("(" + bestItem + ", " + bestCount + ")");
    }

    public static void main(String[] args) {
        String[] orders = {
            "dosa", "idli", "vada", "dosa",
            "idli", "dosa", "tea"
        };

        mostPopular(orders);
    }
}