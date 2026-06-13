package solutions;

import leet.LeetIO;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < charArray.length; i++) {
            if (stack.isEmpty()) {
                stack.push(charArray[i]);
                continue;
            }
            char c = charArray[i];
            Character peek = stack.peek();
            if (c==')') {
                if (peek == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (c=='}') {
                if (peek == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (c==']') {
                if (peek == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        LeetIO io = new LeetIO();
        String s = io.nextString();
        ValidParentheses solution = new ValidParentheses();
        System.out.println(solution.isValid(s));
    }
}
