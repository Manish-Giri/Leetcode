package main

import (
	"arrays/twosum"
	"fmt"
)

func main() {
	nums := []int{2, 7, 11, 15}
	target := 9
	result := twosum.TwoSum(nums, target)
	fmt.Println("Result: ", result)

}
