package twoSum;

import java.util.Arrays;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length - 1; i++) {
            int first = nums[i];
            for(int j = i+1; j < nums.length; j++) {
                int second = nums[j];
                if(first + second == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};

    }

    public static void main(String[] args) {

        System.out.println("hi");
        System.out.println(Arrays.toString(twoSum(new int[]{5,4,10,3,2,94,8, 44, 40, 13}, 43)));
    }
}
