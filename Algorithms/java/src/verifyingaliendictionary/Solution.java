package verifyingaliendictionary;

/**
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
 * <p>
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * Example 2:
 * <p>
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
 * Example 3:
 * <p>
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * All characters in words[i] and order are English lowercase letters.
 */

class Solution {
    boolean isAlienSorted(String[] words, String order) {

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            int pos1 = 0, pos2 = 0;
            // find first point of difference
            while (pos1 < w1.length() && pos2 < w2.length() && w1.charAt(pos1) == w2.charAt(pos2)) {
                pos1++;
                pos2++;
            }
            // if letters remain in both words - compare current chars
            if (pos1 < w1.length() && pos2 < w2.length()) {
                if (order.indexOf(w1.charAt(pos1)) > order.indexOf(w2.charAt(pos2))) {
                    return false;
                }
            } else if (pos1 < w1.length() && pos2 == w2.length()) {
                return false;
            } else {
                return true;
            }
        }
        return true;

    }
}

/*
Success
Details
Runtime: 0 ms, faster than 100.00% of Java online submissions for Verifying an Alien Dictionary.
Memory Usage: 38 MB, less than 15.38% of Java online submissions for Verifying an Alien Dictionary.
 */