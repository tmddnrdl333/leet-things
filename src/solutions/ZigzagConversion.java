package solutions;

import leet.LeetIO;

public class ZigzagConversion {

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        char[] charArray = s.toCharArray();
        int length = charArray.length;

        int targetIndexArrayLength = numRows * 2 - 2;
        int[] targetIndexArray = new int[targetIndexArrayLength];
        for (int i = 0; i < numRows; i++) {
            targetIndexArray[i] = i;
        }
        for (int i = 0; i < numRows - 2; i++) {
            targetIndexArray[numRows + i] = numRows - 2 - i;
        }

        StringBuilder[] stringBuilders = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            stringBuilders[i] = new StringBuilder();
        }

        for (int i = 0; i < length; i++) {
            int targetIndexArrayIndex = i % targetIndexArrayLength;
            int targetIndex = targetIndexArray[targetIndexArrayIndex];
            stringBuilders[targetIndex].append(charArray[i]);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            result.append(stringBuilders[i].toString());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        LeetIO io = new LeetIO();
        String s = io.nextString();
        int numRows = io.nextInt();
        ZigzagConversion solution = new ZigzagConversion();
        System.out.println(solution.convert(s, numRows));
    }
}
