/*
 * @lc app=leetcode.cn id=1 lang=javascript
 *
 * [1] 两数之和
 *
 * https://leetcode-cn.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (46.78%)
 * Likes:    6599
 * Dislikes: 0
 * Total Accepted:    622.6K
 * Total Submissions: 1.3M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 
 * 示例:
 * 
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 
 * 
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */

//  解法1：暴力求解法
var twoSum = function(nums, target) {
    for(let i = 0; i < nums.length - 1; i++) {
        for(let j = i + 1; j < nums.length; j++) {
            if(nums[i] + nums[j] === target) {
                return [i, j];
            }
        }
    }
    return -1;
};

// 解法二：使用Hash表
var twoSum = function(nums, target) {
    let hash = {};

    for(let i = 0; i < nums.length; i++) {
        if(hash[nums[i]] !== undefined) {
            return [hash[nums[i]], i];
        } else {
            hash[target - nums[i]] = i; // 注意这里要返回的是下标值，所以我们在hash中就存储下标值
        }    
    }
    return -1;
};

// @lc code=end

