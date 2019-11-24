package leetcode.jacf.tech;

/**
 * 55. 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/
 * <p>
 * TODO: digest
 *
 * @author jacf
 */
public class JumpGame {
    public class Solution {
        public boolean canJump(int[] nums) {
            int lastPos = nums.length - 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (i + nums[i] >= lastPos) {
                    lastPos = i;
                }
            }
            return lastPos == 0;
        }
    }
}
