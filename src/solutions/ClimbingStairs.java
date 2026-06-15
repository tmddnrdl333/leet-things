package solutions;

import leet.LeetIO;
import leet.TreeNode;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1) return 1;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        LeetIO io = new LeetIO();
        int n = io.nextInt();
        ClimbingStairs sameTree = new ClimbingStairs();
        System.out.println(sameTree.climbStairs(n));
    }
}
