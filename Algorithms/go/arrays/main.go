package main

import (
	"arrays/singleelementinsortedarray"
	"arrays/twosum"
	"fmt"
)

func main() {
	nums := []int{2, 7, 11, 15}
	target := 9
	result := twosum.TwoSum(nums, target)
	fmt.Println("Result: ", result)

	nums1 := []int{1, 1, 2, 3, 3, 4, 4, 8, 8}
	result1 := singleelementinsortedarray.SingleNonDuplicate(nums1)
	fmt.Println("Result of Single Element in Sorted Array: ", result1)

}
