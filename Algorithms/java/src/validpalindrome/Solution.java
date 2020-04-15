package validpalindrome;

class Solution {

    /**
     * Approach 1 - Create new reversed string and compare with original
     * Time - O(n), Space - O(n)
     * <p>
     * Runtime: 16 ms, faster than 28.20% of Java online submissions for Valid Palindrome.
     * Memory Usage: 40.1 MB, less than 19.64% of Java online submissions for Valid Palindrome.
     */
    boolean isPalindrome_ApproachOne(String s) {
        String p = s.replaceAll("[^\\p{Alnum}]", "");
        return p.equalsIgnoreCase(new StringBuilder(p).reverse().toString());
    }

    /**
     * Approach 2 - Two Pointers, compare chars at both ends
     * Time - O(n), Space - O(1)
     *
     * Runtime: 17 ms, faster than 27.34% of Java online submissions for Valid Palindrome.
     * Memory Usage: 40.6 MB, less than 16.07% of Java online submissions for Valid Palindrome.
     */
    boolean isPalindrome_ApproachTwo(String s) {
        String p = s.replaceAll("[^\\p{Alnum}]", "");
        for (int i = 0, j = p.length() - 1; i < j; i++, j--)
            if (Character.toLowerCase(p.charAt(i)) != Character.toLowerCase(p.charAt(j)))
                return false;
        return true;
    }
}
