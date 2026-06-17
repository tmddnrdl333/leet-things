package solutions;

import leet.LeetIO;

import java.util.Arrays;

public class CountingBits {

    /**
     *  0 -     0 - 0
     *  1 -     1 - 1
     *  2 -    10 - 1
     *  3 -    11 - 2
     *  4 -   100 - 1
     *  5 -   101 - 2
     *  6 -   110 - 2
     *  7 -   111 - 3
     *  8 -  1000 - 1
     *  9 -  1001 - 2
     * 10 -  1010 - 2
     * 11 -  1011 - 3
     * 12 -  1100 - 2
     * 13 -  1101 - 3
     * 14 -  1110 - 3
     * 15 -  1111 - 4
     * 16 - 10000 - 1
     * 17 - 10001 - 2
     * 18 - 10010 - 2
     * 19 - 10011 - 3
     */

    public int[] countBits(int n) {
        if (n == 0) return new int[]{0};

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        int i = 2;
        while (i <= n) {
            for (int j = 0; j < i && i + j <= n; j++) {
                dp[i + j] = 1 + dp[j];
            }
            i *= 2;
        }
        return dp;
    }

    public static void main(String[] args) {
        LeetIO io = new LeetIO();
        int n = io.nextInt();
        CountingBits countingBits = new CountingBits();
        System.out.println(Arrays.toString(countingBits.countBits(n)));
    }
}
