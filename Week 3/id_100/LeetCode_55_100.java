public class LeetCode_55_100 {
    /**
     * 假设可以跳至尾部，我们从尾部开始往回跳，看能否跳到索引等于0即可
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        int end = nums.length - 1;
        for (int i =  end - 1; i >= 0; i--) {
            if (nums[i] >= end - i) {
                end = i;
            }
        }
        return end == 0;
    }
}