/*
 * @lc app=leetcode.cn id=66 lang=javascript
 *
 * [66] 加一
 *
 * https://leetcode-cn.com/problems/plus-one/description/
 *
 * algorithms
 * Easy (41.24%)
 * Likes:    362
 * Dislikes: 0
 * Total Accepted:    85.6K
 * Total Submissions: 206.9K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * 
 * 
 */

// @lc code=start
/**
 * @param {number[]} digits
 * @return {number[]}
 */

//  思路：
// 情况1：末位直接加1，其他位不变，如 123 -> 124
// 情况2：末位加1后，出现进制，但是在中间停止,如 199 -> 200
// 情况三：出现进制，且延续到第一位，如 999 -> 1000
var plusOne = function(digits) {
    let len = digits.length;
    
    for(let i = len - 1; i >= 0; i--) {
        digits[i]++;
        digits[i] = digits[i] % 10;
        if(digits[i] !== 0) {
            return digits;
        }
    }

    digits.unshift(1);

    return digits;
};
// @lc code=end

