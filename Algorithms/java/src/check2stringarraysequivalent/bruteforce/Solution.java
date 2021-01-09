package check2stringarraysequivalent.bruteforce;

/**
 * Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
 * <p>
 * A string is represented by an array if the array elements concatenated in order forms the string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
 * Output: true
 * Explanation:
 * word1 represents string "ab" + "c" -> "abc"
 * word2 represents string "a" + "bc" -> "abc"
 * The strings are the same, so return true.
 * Example 2:
 * <p>
 * Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
 * Output: false
 * Example 3:
 * <p>
 * Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
 * Output: true
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= word1.length, word2.length <= 103
 * 1 <= word1[i].length, word2[i].length <= 103
 * 1 <= sum(word1[i].length), sum(word2[i].length) <= 103
 * word1[i] and word2[i] consist of lowercase letters.
 */

class Solution {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Check If Two String Arrays are Equivalent.
     * Memory Usage: 36.6 MB, less than 97.30% of Java online submissions for Check If Two String Arrays are Equivalent.
     *
     * @param word1
     * @param word2
     * @return
     */
    boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        var sb1 = new StringBuilder();
        var sb2 = new StringBuilder();
        for (String s : word1) {
            sb1.append(s);
        }
        for (String s : word2) {
            sb2.append(s);
        }

        return sb1.toString().equals(sb2.toString());

    }
}
