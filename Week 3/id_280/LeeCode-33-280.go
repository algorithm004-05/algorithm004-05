
package main

import "fmt"

func main() {
    in := [...]int{4,5,6,7,0,1,2}
    fmt.Println(search(in[:], 0))
}

func search(nums []int, target int) int {
    start := 0
    end := len(nums) - 1;
    for start <= end {
        mid := (start + end) / 2;
        if nums[mid] == target {
            return mid
        }
             
        if nums[start] <= nums[mid] {
            if target < nums[mid] && target >= nums[start] {
                 end = mid - 1
            } else {
                start = mid + 1
            } 
        } 

        if nums[mid] <= nums[end] {
            if target > nums[mid] && target <= nums[end] {
                start = mid + 1
            } else {
                end = mid - 1
            }
        }
    }
    return -1
}