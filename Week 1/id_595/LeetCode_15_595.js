/*
 * @lc app=leetcode.cn id=15 lang=javascript
 *
 * [15] 三数之和
 *
 * https://leetcode-cn.com/problems/3sum/description/
 *
 * algorithms
 * Medium (24.12%)
 * Likes:    1430
 * Dislikes: 0
 * Total Accepted:    104.6K
 * Total Submissions: 433.6K
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * ？找出所有满足条件且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 
 * 满足要求的三元组集合为：
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */

//  解法1：定一个数，然后左右双指针向中间遍历。
var threeSum = function(nums) {
    let result = [];
    let len = nums.length;

    nums.sort((a, b) => a - b); // 排序


    for(let i = 0; i < len - 2; i++) {
        if(nums[i] > 0 || nums[len - 1] < 0) break; // 确保最小数小于0， 最大数大于0
        if(i > 0 && nums[i] === nums[i - 1]) continue;

        let left = i + 1;
        let right = len - 1;

        while(left < right) {
            let sum = nums[i] + nums[left] + nums[right];
            if(sum === 0) {
                result.push([nums[i], nums[left], nums[right]]);
                while(left < right && nums[left] === nums[left + 1]) left++;
                while(left < right && nums[right] === nums[right - 1]) right--;
                left++;
                right--;
            } else {
                if(sum > 0) right--;
                else left++;
            }
        }
    }

    return result
};
// @lc code=end

