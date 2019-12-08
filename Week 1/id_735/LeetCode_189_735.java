/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
// 方法一: 旋转 k 次，每次将数组旋转 1 个元素。
// 时间复杂度：O(n*k). 每个元素都被移动 1 步（O(n)） k次（O(k)） 。
// 空间复杂度：O(1). 没有额外空间被使用。

public class Solution {

    public void rotate(int[] nums, int k) {

        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }
}

// @lc code=end

