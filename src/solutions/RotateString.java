package solutions;

import leet.LeetIO;

import java.util.HashMap;
import java.util.Map;

public class RotateString {
    public boolean rotateString(String s, String goal) {
        char[] sArray = s.toCharArray();
        char[] goalArray = goal.toCharArray();

        int sLength = sArray.length;
        int goalLength = goalArray.length;

        if (sLength != goalLength) {
            return false;
        }

        outer:
        for (int i = 0; i < sLength; i++) {
            for (int j = 0; j < sLength; j++) {
                int k = i + j >= sLength ? i + j - sLength : i + j;
                if (sArray[k] != goalArray[j]) {
                    continue outer;
                }
            }
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        LeetIO io = new LeetIO();
        String s = io.nextString();
        String goal = io.nextString();
        io.println(new RotateString().rotateString(s, goal));
    }
}
