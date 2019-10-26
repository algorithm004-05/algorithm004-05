/*
 * @lc app=leetcode.cn id=88 lang=javascript
 *
 * [88] 合并两个有序数组
 *
 * https://leetcode-cn.com/problems/merge-sorted-array/description/
 *
 * algorithms
 * Easy (45.53%)
 * Likes:    329
 * Dislikes: 0
 * Total Accepted:    77K
 * Total Submissions: 169.2K
 * Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 
 * 说明:
 * 
 * 
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 
 * 
 * 示例:
 * 
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 
 * 输出: [1,2,2,3,5,6]
 * 
 */

// @lc code=start
/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */

//  解法1：运用JS数组中splice方法的特性，将nums1中的0去除，补上nums2，然后排序
var merge = function(nums1, m, nums2, n) {
    let len = nums1.length;
    nums1.splice(len - n, n, ...nums2);
    
    nums1.sort((a, b) => a - b);

    return nums1;
};

// 解法2：双指针/从后往前。
// 思路：分别用两个指针i，j指向nums1和nums2的非0尾数位置，然后用一个指针p指向nums1最后一位，
// 分别比较i和j所指位置的元素大小，将大的放到p所指的位置，当i或者j有一个小于0，那么就把「nums2从下标为0到下标为j的元素，覆盖到nums1的首部」

var merge = function(nums1, m, nums2, n) {
    let i = nums1.length - 1 - n;
    let j = nums2.length - 1;
    let p = nums1.length - 1;

    while(j >= 0 && i >= 0) {
        nums1[p--] = nums1[i] <= nums2[j] ? nums2[j--] : nums1[i--];
    }

    nums1.splice(0, j + 1, ...nums2.slice(0, j + 1));

    return nums1;

};
// @lc code=end

