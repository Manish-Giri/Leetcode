package firstuniquecharacterinastring;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * <p>
 * Examples:
 * <p>
 * s = "leetcode"
 * return 0.
 * <p>
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */

class Solution {
    public int firstUniqChar(String s) {
        // lowercase letters a: 97, z: 122, diff: 0->25(26 letters)
        int[] asciiCodes = new int[26];
        int idx = -1;
        for (int i = 0; i < s.length(); i++) {
            // offset to fit within 0-25
            idx = ((int) s.charAt(i)) - 97;
            asciiCodes[idx]++;
        }
        for (int i = 0; i < s.length(); i++) {
            idx = ((int) s.charAt(i)) - 97;
            if (asciiCodes[idx] == 1) {
                return i;
            }
        }
        return -1;
    }
}

/*
Success
Details
Runtime: 8 ms, faster than 84.32% of Java online submissions for First Unique Character in a String.
Memory Usage: 41.8 MB, less than 5.71% of Java online submissions for First Unique Character in a String.
 */
