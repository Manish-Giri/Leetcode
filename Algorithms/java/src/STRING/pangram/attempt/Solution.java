package STRING.pangram.attempt;

/**
 * A pangram is a sentence where every letter of the English alphabet appears at least once.
 *
 * Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
 * Output: true
 * Explanation: sentence contains at least one of every letter of the English alphabet.
 * Example 2:
 *
 * Input: sentence = "leetcode"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= sentence.length <= 1000
 * sentence consists of lowercase English letters.
 */
 class Solution {
    /**
     * Runtime
     * Details
     * 7ms
     * Beats 6.52%of users with Java
     * Memory
     * Details
     * 40.90mb
     * Beats 35.34%of users with Java
     * @param sentence
     * @return
     */
     boolean checkIfPangram(String sentence) {
        char[] letters = sentence.trim().replaceAll("[^A-Za-z]", "").toLowerCase().toCharArray();
        int[] alphabets = new int[26];
        for(char c: letters) {
            alphabets[((int)c) - 97] = ++alphabets[((int)c) - 97];
        }
        for(int n: alphabets) {
            if(n == 0)
                return false;
        }
        return true;
    }
}
