package solutions;

import leet.LeetIO;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();

        int sLength = array.length;

        int longestLength = 0;

        int start = 0;
        outer:
        while (start < sLength - longestLength) {
//            System.out.println("--- start: " + start);
            boolean[] set = new boolean[128];
            for (int i = start; i < sLength; i++) {
                char targetChar = array[i];
                if (set[targetChar]) {
                    start++;
                    continue outer;
                }
                longestLength = Math.max(i - start + 1, longestLength);
//                System.out.println(array[i] + ": " + longestLength);
                set[targetChar] = true;
            }
            start++;
        }

        return longestLength;
    }

    public static void main(String[] args) {
        LeetIO io = new LeetIO();
        String s = io.nextString();
        io.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s));
    }
}
