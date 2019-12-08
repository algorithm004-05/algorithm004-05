/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        
        //输入参数为无解
        if (nums == null) {
            return false;
        }

        //能够到达的最后位置的下标，初始值是最后一个元素的位置，意为，最后一个元素能够到达最后一个地方（从后往前）
        int canReachable = nums.length - 1;
        for (int i=canReachable; i>=0; i--) {
            //若当前下标加上下标所在的步数可以到达canReachable，那么就后退到那个位置
            if (nums[i]+i >= canReachable) {
                canReachable = i;
            }
        }
        return canReachable == 0;
    }
}
// @lc code=end

