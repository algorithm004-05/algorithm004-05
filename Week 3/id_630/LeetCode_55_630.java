class Solution {
    public boolean canJump(int[] nums) {
        int curPosition = nums.length-1;
        for(int i= nums.length-1;i>=0;i--) {
            if (i+nums[i]>=curPosition) {
                curPosition = i;
            }
        }
        return curPosition == 0;
    }
}