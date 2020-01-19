package removeduplicatesfromsortedarray;

class Solution {
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("Original array length: " + arr.length);
        System.out.println("New length of array: " + removeDuplicates(arr));

    }
}

/*
OUTPUT -

Original array length: 10
New length of array: 5

 */