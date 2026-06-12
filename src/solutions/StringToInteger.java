package solutions;

import leet.LeetIO;

public class StringToInteger {

    public int myAtoi(String s) {
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        int index = 0;

        // 1. ignore whitespace
        while (index < length) {
            char c = charArray[index];
            if (c != ' ') break;
            index++;
        }
        if (index == length) return 0;

        // 2. determine the sign
        int sign = 1;
        if (charArray[index] == '-') {
            sign = -1;
            index++;
        } else if (charArray[index] == '+') {
            index++;
        }
        if (index == length) return 0;

        // 3. convert to number
        long number = 0;
        for (int i = index; i < length; i++) {
            if (charArray[i] < '0' || charArray[i] > '9') {
                break;
            }
            number *= 10;
            number += charArray[i] - '0';
            if (number > Integer.MAX_VALUE) {
                break;
            }
        }

        // 4. rounding to int
        if (sign == 1 && number > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (sign == -1 && number > -1L * Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return sign * (int) number;
    }

    public static void main(String[] args) {
        LeetIO io = new LeetIO();
        String s = io.nextString();
        StringToInteger solution = new StringToInteger();
        System.out.println(solution.myAtoi(s));
    }
}
