public class RotateArray {
    //利用循环调用实现右移，时间复杂度为O(n^2)，空间复杂度为O(n)
    public void rotate(int[] nums, int k) {
        //往左移k次
        for (int i = 0; i < k; i++) {
            move(nums);
        }
    }

    private void move(int[] nums) {
        if (nums == null || nums.length == 0)
            return;

        int endNum = nums[nums.length - 1];
        for (int i = nums.length; i > 1; i--) {
            nums[i - 1] = nums[i - 2];
        }
        nums[0] = endNum;
    }
}
