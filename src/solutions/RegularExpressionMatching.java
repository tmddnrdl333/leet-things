package solutions;

import leet.LeetIO;

import java.util.regex.Pattern;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        return Pattern.matches(p, s);
    }

    public static void main(String[] args) {
        LeetIO io = new LeetIO();
        String s = io.nextString();
        String p = io.nextString();
        io.println(new RegularExpressionMatching().isMatch(s, p));
    }
}
