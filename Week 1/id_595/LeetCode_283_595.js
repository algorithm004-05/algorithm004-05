/*
 * @lc app=leetcode.cn id=283 lang=javascript
 *
 * [283] 移动零
 *
 * https://leetcode-cn.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (57.04%)
 * Likes:    411
 * Dislikes: 0
 * Total Accepted:    75.3K
 * Total Submissions: 131.5K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 
 * 说明:
 * 
 * 
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * 
 * 
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */


//  解法1：将非0元素前移到目标位置，然后将剩余位置补0
var moveZeroes = function(nums) {
    if(nums.length < 1) return nums; // 一开始做一个数组长度判断

    let index = 0;  // 记录非0元素所放的位置index
    let len = nums.length;
    for(let i = 0; i < len; i++) {  // 一轮遍历，将非0元素前移到正确的位置
        if(nums[i] !== 0) {
            nums[index++] = nums[i];
        }
    }

    while(index < len) { // 非0元素放到正确位置后，剩余的位置全部补0
        nums[index++] = 0;
    }

    return nums;
};

// 解法2：双指针法
// 思路：用一个指针i指向非0元素应该在的位置，然后遍历，遇到非0元素就与所指的位置元素进行交换，
// 感觉与解法1差不多，只不过此处交换后，0也处于后面的位置不需要再次补0了
var moveZeroes = function(nums) {
    if(nums.length < 1) return nums; // 一开始做一个数组长度判断

    let i = 0; // 指针i指向非0元素应该所处的位置

    for(let j = 0; j < nums.length; j++) {
        if(nums[j] !== 0) { // 如果所遇元素不为0，就将它和i所指元素进行交换，同时++i，将i后移一位
            [nums[j], nums[i]] = [nums[i], nums[j]]; // 使用ES6语法，将nums[i]和nums[j]元素交换
            i++;
        }
    }

    return nums;
};
// @lc code=end

