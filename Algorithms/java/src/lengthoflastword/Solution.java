package lengthoflastword;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.
 * <p>
 * If the last word does not exist, return 0.
 * <p>
 * Note: A word is defined as a maximal substring consisting of non-space characters only.
 * <p>
 * Example:
 * <p>
 * Input: "Hello World"
 * Output: 5
 */
class Solution {
    public int lengthOfLastWord(String s) {
        if (s.trim().length() == 0)
            return 0;
        String[] words = s.split(" ");
        return words[words.length - 1].length();
    }
}
