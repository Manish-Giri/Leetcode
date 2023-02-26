package BINARYSEARCH.smallestlettergreaterthantarget.attempt;

/**
 * You are given an array of characters letters that is sorted in non-decreasing order, and a character target. There are at least two different characters in letters.
 * <p>
 * Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: letters = ["c","f","j"], target = "a"
 * Output: "c"
 * Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.
 * Example 2:
 * <p>
 * Input: letters = ["c","f","j"], target = "c"
 * Output: "f"
 * Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.
 * Example 3:
 * <p>
 * Input: letters = ["x","x","y","y"], target = "z"
 * Output: "x"
 * Explanation: There are no characters in letters that is lexicographically greater than 'z' so we return letters[0].
 */
class Solution {

    static char nextGreatestLetter(char[] letters, char target) {
        int pos = binarySearch(letters, target);
        return letters[pos];
    }

    static int binarySearch(char[] letters, char target) {
        int start = 0, end = letters.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // even if target found - search in right half for next greater element
            if (target >= letters[mid]) start = mid + 1;
            else if (target < letters[mid]) end = mid - 1;
        }
        return start % letters.length;
    }

    public static void main(String[] args) {
        char[] letters = {'x', 'x', 'y', 'y'};
        char target = 'z';
        System.out.println("Next greatest letter: " + nextGreatestLetter(letters, target));
        letters = new char[]{'c', 'f', 'j'};
        System.out.println("Next greatest letter: " + nextGreatestLetter(letters, 'c'));
        System.out.println("Next greatest letter: " + nextGreatestLetter(letters, 'a'));

    }
}
