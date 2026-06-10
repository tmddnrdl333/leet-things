package solutions;

import leet.LeetIO;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class RomanToInteger {

    enum Roman {
        M(1000), D(500), C(100), L(50), X(10), V(5), I(1);

        int integer;

        Roman(int integer) {
            this.integer = integer;
        }

        Set<Roman> getLargers() {
            return Arrays.stream(Roman.values()).filter(i -> i.ordinal() < this.ordinal()).collect(Collectors.toSet());
        }

        int getLastIndexOfLargers(String s) {
            int lastIndex = -1;
            Set<Roman> largers = getLargers();
            for (Roman l : largers) {
                int i = s.lastIndexOf(l.name());
                lastIndex = Math.max(lastIndex, i);
            }
            return lastIndex;
        }
    }

    public int romanToInt(String s) {
        int mInteger = calculate(s, Roman.M, 1000);
        int dInteger = calculate(s, Roman.D, 500);
        int cInteger = calculate(s, Roman.C, 100);
        int lInteger = calculate(s, Roman.L, 50);
        int xInteger = calculate(s, Roman.X, 10);
        int vInteger = calculate(s, Roman.V, 5);
        int iInteger = calculate(s, Roman.I, 1);
        return mInteger + dInteger + cInteger + lInteger + xInteger + vInteger + iInteger;
    }

    // if a roman precedes a larger one, subtract
    int countSubtractions(String s, Roman roman) {
        int lastIndexOfLargers = roman.getLastIndexOfLargers(s);
        if (lastIndexOfLargers == -1) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < lastIndexOfLargers; i++) {
            if (s.charAt(i) == roman.name().charAt(0)) count++;
        }
        return count;
    }

    // if a roman follows a larger one, add
    int countAdditions(String s, Roman roman) {
        int lastIndexOfLargers = roman.getLastIndexOfLargers(s);
        if (lastIndexOfLargers == -1) {
            lastIndexOfLargers = 0;
        }
        int count = 0;
        for (int i = lastIndexOfLargers; i < s.length(); i++) {
            if (s.charAt(i) == roman.name().charAt(0)) count++;
        }
        return count;
    }

    int calculate(String s, Roman roman, int integer) {
        int minus = countSubtractions(s, roman);
        int plus = countAdditions(s, roman);
        return integer * (plus - minus);
    }

    public static void main(String[] args) {
        LeetIO io = new LeetIO();
        String s = io.nextString();
        RomanToInteger solution = new RomanToInteger();
        System.out.println(solution.romanToInt(s));
    }
}
