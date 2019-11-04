/**
 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

 ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

 你可以假设数组中不存在重复的元素。

 你的算法时间复杂度必须是 O(log n) 级别。

 示例 1:

 输入: nums = [4,5,6,7,0,1,2], target = 0
 输出: 4
 示例 2:

 输入: nums = [4,5,6,7,0,1,2], target = 3
 输出: -1

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    let midIdx = findMidIdx(nums)
    if (target == nums[midIdx]) {
        return midIdx
    }
    let m = nums.length - 1
    let s = target <= nums[m] ? midIdx : 0
    let e = target > nums[m] ? midIdx : m
    while (s <= e) {
        m = s + Math.floor((e - s) / 2)
        if(nums[m] == target) {
            return m
        } else if (target > nums[m]) {
            s = m + 1
        } else {
            e = m - 1
        }
    }
    return -1;
};

let findMidIdx = function (nums) {
    //找到最小的一个元素
    let s = 0, e = nums.length - 1
    while (s < e) {
        let m = s + Math.floor((e - s) / 2)
        if(nums[m] > nums[e]) {
            s = m + 1
        } else {
            e = m
        }
    }
    return s
}