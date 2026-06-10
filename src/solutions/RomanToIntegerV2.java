package solutions;

import leet.LeetIO;

import java.util.Map;

public class RomanToIntegerV2 {

    private static final Map<Character, Integer> VALUES = Map.of(
        'I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);

    public int romanToInt(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = VALUES.get(s.charAt(i));
            if (i + 1 < s.length() && cur < VALUES.get(s.charAt(i + 1))) {
                total -= cur;   // right neighbor is larger -> subtract
            } else {
                total += cur;   // otherwise -> add
            }
        }
        return total;
    }

    public static void main(String[] args) {
        LeetIO io = new LeetIO();
        String s = io.nextString();
        RomanToIntegerV2 solution = new RomanToIntegerV2();
        System.out.println(solution.romanToInt(s));
    }
}
