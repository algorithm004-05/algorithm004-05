/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
//  6 7 8 0 1 2 3 4 5
var search = function(nums, target) {
    let low = 0
    let high = nums.length - 1
    while (low < high) {
        let mid = (low + high) / 2
        if (nums[0] <= nums[mid] && (target > nums[mid]) || target < nums[0]) {
            low = mid + 1
        } else if (target > nums[mid] && target < nums[0]) {
            low = mid + 1
        } else {
            high = mid
        }
    }
};