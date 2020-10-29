package longestsubstringwithoutrepeatingcharacters.bruteforce;

import java.util.HashSet;

class Solution {

    /**
     * Runtime: 75 ms, faster than 15.19% of Java online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 39.8 MB, less than 7.92% of Java online submissions for Longest Substring Without Repeating Characters
     * @param s
     * @return
     */
    int lengthOfLongestSubstring(String s) {
        int longestSubstringLength = 0;
        int currentSubstringLength = 0;
        HashSet<Character> hs = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                if(!hs.contains(ch)) {
                    hs.add(ch);
                    currentSubstringLength++;
                }
                else {
                    // found duplicate character
                    if(currentSubstringLength >= longestSubstringLength)
                        longestSubstringLength = currentSubstringLength;
                    currentSubstringLength = 0;
                    hs.clear();
                    // break out of innermost loop
                    break;
                }
            }
        }
        return longestSubstringLength == 0 ? hs.size() : longestSubstringLength;
    }

    public static void main(String[] args) {
        String s = "au";
        System.out.println(new Solution().lengthOfLongestSubstring(s));
    }

}
