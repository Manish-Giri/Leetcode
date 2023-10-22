package twosum

// TwoSum Two Sum problem
func TwoSum(nums []int, target int) []int {
	result := make([]int, 2)
	myMap := make(map[int]int)
	for index, value := range nums {
		searchKey := target - value
		diffIndex, ok := myMap[searchKey]
		if ok == true {
			result[0] = index
			result[1] = diffIndex
			return result
		} else {
			myMap[value] = index
		}
	}
	return result
}
