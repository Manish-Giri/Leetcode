package breakapalindrome;

/**
 * Given a palindromic string palindrome, replace exactly one character by any lowercase English letter so that the string becomes the lexicographically smallest possible string that isn't a palindrome.
 *
 * After doing so, return the final string.  If there is no way to do so, return the empty string.
 *
 *
 *
 * Example 1:
 *
 * Input: palindrome = "abccba"
 * Output: "aaccba"
 * Example 2:
 *
 * Input: palindrome = "a"
 * Output: ""
 *
 *
 * Constraints:
 *
 * 1 <= palindrome.length <= 1000
 * palindrome consists of only lowercase English letters.
 */

 class Solution {

     /**
      * Runtime: 0 ms, faster than 100.00% of Java online submissions for Break a Palindrome.
      * Memory Usage: 38.7 MB, less than 5.10% of Java online submissions for Break a Palindrome.
      *
      * @param palindrome
      * @return
      */
     String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1) return "";
        char[] pdr = palindrome.toCharArray();
        boolean allA = true;
        for(int i = 0; i < pdr.length/2; i++) {
            if(pdr[i] != 'a') {
                allA = false;
                pdr[i] = 'a';
                break;
            }

        }
        if(allA)
            pdr[pdr.length-1] = 'b';
        return new String(pdr);
    }
}
