package solutions;

import leet.LeetIO;

import java.util.HashMap;
import java.util.Map;

/**
 * Example LeetCode solution showing the LeetIO pattern.
 *
 * Run this class and paste two lines into the run console:
 *   [2,7,11,15]
 *   9
 *
 * Expected output:
 *   [0,1]
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer j = seen.get(target - nums[i]);
            if (j != null) return new int[]{j, i};
            seen.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        LeetIO io = new LeetIO();
        int[] nums = io.nextIntArray();
        int target = io.nextInt();
        io.println(new TwoSum().twoSum(nums, target));
    }
}
