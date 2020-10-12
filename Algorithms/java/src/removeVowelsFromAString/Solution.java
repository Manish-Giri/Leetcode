package removeVowelsFromAString;

 class Solution {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Vowels from a String.
     * Memory Usage: 36.7 MB, less than 11.88% of Java online submissions for Remove Vowels from a String.
     */
     String removeVowels(String S) {
        StringBuilder sb = new StringBuilder();
        for (char ch : S.toCharArray()) {
            if ((ch != 'a') && (ch != 'e') && (ch != 'i') && (ch != 'o') && (ch != 'u'))
                sb.append(ch);
        }
        return sb.toString();
    }

    /*
    Runtime: 2 ms, faster than 27.67% of Java online submissions for Remove Vowels from a String.

    Memory Usage: 37.5 MB, less than 11.88% of Java online submissions for Remove Vowels from a String.

     String removeVowels(String S) {
        return S.replaceAll("[aeiou]+", "");
    }
    */
}
