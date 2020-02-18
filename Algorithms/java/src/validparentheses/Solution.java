package validparentheses;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 */

public class Solution {

    public boolean isValid(String s) {
        Stack<Character> parens = new Stack<>();
        if(s.length() == 0) return true;
        boolean isValid = false;
        for(char c: s.toCharArray()) {
            switch(c) {
                case '(':
                case '[':
                case '{':
                    parens.push(c);
                    break;
                case ')':
                case ']':
                case '}':
                    if(parens.isEmpty()) return false;
                    char curr = parens.pop();
                    if((c == ')' && curr != '(')
                            || (c == ']' && curr != '[')
                            || (c == '}' && curr != '{')
                    ) {
                        return false;
                    }
                    else {
                        isValid = true;
                    }
            }
        }
        // if stack is still not empty - then there are mismatched parentheses still present - invalid expression
        return parens.isEmpty() && isValid;
    }
}

/*
Success
Details
Runtime: 1 ms, faster than 98.68% of Java online submissions for Valid Parentheses.
Memory Usage: 37.9 MB, less than 5.06% of Java online submissions for Valid Parentheses.
 */