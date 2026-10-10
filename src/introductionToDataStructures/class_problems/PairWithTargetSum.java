package introductionToDataStructures.class_problems;

import java.util.*;

public class PairWithTargetSum {

    public static boolean hasPairWithSum(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            int complement = target - num;

            if (set.contains(complement)) {
                return true;
            }

            set.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};

        System.out.println(hasPairWithSum(nums, 9));
    }
}