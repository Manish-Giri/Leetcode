package highfive;

import java.util.*;

/**
 * Given a list of scores of different students, return the average score of each student's top five scores in the order of each student's id.
 *
 * Each entry items[i] has items[i][0] the student's id, and items[i][1] the student's score.  The average score is calculated using integer division.
 *
 *
 *
 * Example 1:
 *
 * Input: [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
 * Output: [[1,87],[2,88]]
 * Explanation:
 * The average of the student with id = 1 is 87.
 * The average of the student with id = 2 is 88.6. But with integer division their average converts to 88.
 *
 *
 * Note:
 *
 * 1 <= items.length <= 1000
 * items[i].length == 2
 * The IDs of the students is between 1 to 1000
 * The score of the students is between 1 to 100
 * For each student, there are at least 5 scores
 */

 class Solution {
     int[][] highFive(int[][] items) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for(int[] item: items) {
            if(map.containsKey(item[0])) {
                map.get(item[0]).add(item[1]);
            }
            else {
                List<Integer> temp = new ArrayList<>();
                temp.add(item[1]);
                map.put(item[0], temp);
            }
        }
        int[][] res = new int[map.size()][2];
        int idx = 0, sum = 0, avg = 0;
        for(Map.Entry<Integer, List<Integer>> e: map.entrySet()) {
            int id = e.getKey();
            List<Integer> scores = e.getValue();
            scores.sort(Collections.reverseOrder());
            for(int i = 0; i < 5; i++) {
                sum += scores.get(i);
            }
            avg = sum/5;
            res[idx++] = new int[]{id, avg};
            sum = 0;
            avg = 0;
        }
        return res;

    }
}

/*
Runtime: 6 ms, faster than 44.34% of Java online submissions for High Five.
Memory Usage: 41.6 MB, less than 100.00% of Java online submissions for High Five.
 */
