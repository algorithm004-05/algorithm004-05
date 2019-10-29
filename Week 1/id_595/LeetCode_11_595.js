/*
 * @lc app=leetcode.cn id=11 lang=javascript
 *
 * [11] 盛最多水的容器
 *
 * https://leetcode-cn.com/problems/container-with-most-water/description/
 *
 * algorithms
 * Medium (58.34%)
 * Likes:    849
 * Dislikes: 0
 * Total Accepted:    90.9K
 * Total Submissions: 155.3K
 * Testcase Example:  '[1,8,6,2,5,4,8,3,7]'
 *
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为
 * (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 
 * 
 * 
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 * 
 */

// @lc code=start
/**
 * @param {number[]} height
 * @return {number}
 */

//  解法1： 暴力循环，时间复杂度O（n^2）
var maxArea = function(height) {
    let max = 0;
    for(let i = 0; i < height.length - 1; i++) {
        for(let j = i + 1; j < height.length; j++) {
            let area = (j - i) * Math.min(height[i], height[j]);
            max = max < area ? area : max;
        }
    }

    return max;
};

// 解法2：左右夹逼，中间收敛
// 思路：用两个指针i、j，看两个指针那个高度低，就往中间收缩，如果收缩后的位置的高度比收缩前还要低，则不需要考虑，
// 因为当你宽度变小后，为了让面积更大，只可能找更高的高度才有可能使得面积更大。 由于一次遍历，所以时间复杂度为O（n）

var maxArea = function(height) {
    let max = 0;
    let i, j; // 申请头尾两个指针
    
    for(i = 0, j = height.length - 1; i < j;) {
        let minHeight = height[i] < height[j] ? height[i++] : height[j--];
        let area = (j - i + 1) * minHeight;
        max = max < area ? area : max;
    }

    return max;
};
// @lc code=end

