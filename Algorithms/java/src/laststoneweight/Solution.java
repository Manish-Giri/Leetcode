package laststoneweight;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * We have a collection of stones, each stone has a positive integer weight.
 * <p>
 * Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 * <p>
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 */

class Solution {

    int lastStoneWeight(int[] stones) {
        LinkedList<Integer> stoneList = Arrays.stream(stones)
                .boxed().collect(Collectors.toCollection(LinkedList::new));
        while (stoneList.size() > 1) {
            stoneList.sort(Comparator.reverseOrder());
            int s1 = stoneList.pollFirst();
            int s2 = stoneList.pollFirst();
            if (s1 != s2) {
                stoneList.add(s1 - s2);
            }
        }
        return stoneList.isEmpty() ? 0 : stoneList.peekFirst();
    }

    /*
    Runtime: 10 ms, faster than 6.70% of Java online submissions for Last Stone Weight.
    Memory Usage: 39.3 MB, less than 100.00% of Java online submissions for Last Stone Weight.
    */
}
