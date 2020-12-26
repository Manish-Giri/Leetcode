package permutations.optimized;

import java.util.ArrayList;
import java.util.List;

class Solution {

    /**
     * Runtime: 1 ms, faster than 92.74% of Java online submissions for Permutations.
     * Memory Usage: 39.1 MB, less than 73.38% of Java online submissions for Permutations.
     *
     * @param nums
     * @return
     */
    List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> perms = new ArrayList<>();
        List<Integer> array = new ArrayList<>();
        for (int n : nums) array.add(n);
        helper(0, array, perms);
        return perms;
    }


    private void helper(int index, List<Integer> array, List<List<Integer>> perms) {
        // base case - when index is at the last, add current perm
        if (index == array.size() - 1) {
            perms.add(new ArrayList<>(array));
            return;
        }

        for (int j = index; j < array.size(); j++) {
            swap(array, index, j);
            helper(index + 1, array, perms);
            swap(array, index, j);
        }
    }

    private void swap(List<Integer> array, int i, int j) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }
}
