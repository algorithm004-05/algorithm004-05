/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start

// 双指针
// 解法分析: 记录不为零的个数. 遍历数组使所有不为零的数 置于前边.  之后把剩余的全部置为零.
class Solution {
    public void moveZeroes(int[] nums) {

        // i:插入位置下标 ; j:查找位置下标
        int i = 0; 
        for (int j = 0; j < nums.length; j++) {
            
            if (nums[j] != 0) {
            
                nums[i] = nums[j];
                i++;
            }
        }

        // 将后面的位置补0
        for (int p = i; p < nums.length; p++) {

            nums[p] = 0;
        }
    }
}

// @lc code=end

