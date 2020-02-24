package trappingrainwater;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 *
 * Example:
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
 class Solution {

     // Time - O(n^2)
     int trap(int[] height) {
        int totalWaterTrapped = 0, maxHeightLeft, maxHeightRight, minHeightAtIdx, waterAtIdx = 0;
        for(int i = 0; i < height.length; i++) {
            maxHeightLeft = findMaxFrom(i, true, height);
            maxHeightRight = findMaxFrom(i, false, height);
            minHeightAtIdx = Math.min(maxHeightLeft, maxHeightRight);
            if(minHeightAtIdx > 0) {
                waterAtIdx = minHeightAtIdx - height[i];
                if(waterAtIdx >= 0)
                    totalWaterTrapped += waterAtIdx;
            }
        }
        return totalWaterTrapped;
    }

    private int findMaxFrom(int idx, boolean left, int[] height) {
        int maxHeight = 0;
        if(left) {
            for(int i = 0; i < idx; i++) {
                if(height[i] > maxHeight) {
                    maxHeight = height[i];
                }
            }
        }
        else {
            for(int i = idx+1; i < height.length; i++) {
                if(height[i] > maxHeight) {
                    maxHeight = height[i];
                }
            }
        }
        return maxHeight;
    }
}
