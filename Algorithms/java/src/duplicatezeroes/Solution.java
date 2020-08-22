package duplicatezeroes;

class Solution {
    /**
     * Runtime: 17 ms, faster than 25.95% of Java online submissions for Duplicate Zeros.
     * Memory Usage: 39.9 MB, less than 21.34% of Java online submissions for Duplicate Zeros.
     *
     * @param arr
     */
    private void duplicateZeros(int[] arr) {

        int i = 0, lastZeroIndex = -1;
        while (i < arr.length) {
            i = lastZeroIndex + 1;

            while (i < arr.length && arr[i] != 0) {
                i++;
            }
            if (i == arr.length - 1 || i >= arr.length) break;
            lastZeroIndex = i;
            shiftElements(arr, i + 1);
            arr[++lastZeroIndex] = 0;
        }
    }

    private void shiftElements(int[] arr, int start) {
        for (int i = arr.length - 1; i > start; i--) {
            arr[i] = arr[i - 1];
        }
    }
}

