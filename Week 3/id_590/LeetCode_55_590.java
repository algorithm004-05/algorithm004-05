package homework.week3;

//https://leetcode-cn.com/problems/jump-game/
public class LeetCode_55_590 {
    public boolean canJump(int[] nums) {
        int  curr = 0, target = 0;
        while (target < nums.length - 1) {
            if (target < nums[curr] + curr) {
                target = nums[curr] + curr;
            }
            if (curr==target && nums[curr]==0){
                return false;
            }
            curr++;
        }
        return true;
    }

}
