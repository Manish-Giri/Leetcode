package keyboardrow;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 * Example:
 * <p>
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 * <p>
 * <p>
 * Note:
 * <p>
 * You may use one character in the keyboard more than once.
 * You may assume the input string will only contain letters of alphabet.
 */
class Solution {
    char[][] rows = {{'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P'},
            {'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L'},
            {'Z', 'X', 'C', 'V', 'B', 'N', 'M'}};

    String[] findWords(String[] words) {
        boolean isMatch = true;
        List<String> res = new ArrayList<String>();
        for (String w : words) {
            if (w.length() == 1) {
                res.add(w);
                continue;
            }
            int firstLetterRow = findRowOfLetter(w.charAt(0));
            for (int i = 1; i < w.length(); i++) {
                if (findRowOfLetter(w.charAt(i)) != firstLetterRow) {
                    isMatch = false;
                    break;
                }
                isMatch = true;
            }
            if (isMatch) {
                res.add(w);
                isMatch = false;
            }
        }
        return res.toArray(new String[res.size()]);
    }

    private int findRowOfLetter(char c) {
        for (int i = 0; i < rows.length; i++) {
            for (char curr : rows[i]) {
                if (Character.toLowerCase(curr) == Character.toLowerCase(c)) {
                    return i;
                }
            }
        }
        return -1;
    }
}

/*
Details
Runtime: 0 ms, faster than 100.00% of Java online submissions for Keyboard Row.
Memory Usage: 37.7 MB, less than 7.69% of Java online submissions for Keyboard Row.
 */