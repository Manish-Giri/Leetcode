package findallnumbersdisappearedinanarray;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

class Solution {
    /*
    Runtime: 23 ms, faster than 16.39% of Java online submissions for Find All Numbers Disappeared in an Array.
    Memory Usage: 47.8 MB, less than 93.41% of Java online submissions for Find All Numbers Disappeared in an Array.
    */
    private List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i : nums) hs.add(i);
        List<Integer> res = new ArrayList<>();
        IntStream.rangeClosed(1, nums.length).filter(e -> !hs.contains(e)).forEach(res::add);
        return res;
    }

    public static void main(String[] args) {
        int[] n = {4, 3, 2, 7, 8, 2, 3, 1};
        var list = new Solution().findDisappearedNumbers(n);
        System.out.println(list);
    }
}
