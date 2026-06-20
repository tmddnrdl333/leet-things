
package solutions;

import leet.LeetIO;

public class PowerOfThree {

    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }

        int maxPowerOf3 = 1162261467; // 3^19 is the largest power of 3 in int range
        return maxPowerOf3 % n == 0;
    }

    public static void main(String[] args) {
        LeetIO io = new LeetIO();
        int n = io.nextInt();
        PowerOfThree powerOfThree = new PowerOfThree();
        System.out.println(powerOfThree.isPowerOfThree(n));
    }
}
