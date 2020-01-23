package implementstrStr;

public class Solution {
    public int strStr(String haystack, String needle) {
        return needle.length() == 0 ? 0 : haystack.indexOf(needle);
    }
}

/*
Your input
"hello"
"ll"
Output
2
Expected
2
 */