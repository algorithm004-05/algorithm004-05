/**
 * https://leetcode.com/problems/rotate-array/
 */
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length < 2) {
            return;
        }
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        rotateSwap(nums, k);
    }

    /*
     * 原地旋转，遍历数组前移
     */
    private void rotateLocal(int[] nums, int k) {
        int p0 = nums.length - k, p1 = nums.length - 1;
        for (; p0 > 0; p0--, p1--) {
            int target = nums[p0 -1];
            System.copyArray
            for (int p = p0; p <= p1; p++) {
                nums[p-1] = nums[p];
            }
            nums[p1] = target;
        }
    }

    /*
     * 分段交换
     */
    private void rotateSwap(int[] nums, int k) {
        int[] temp = new int[k];
        System.arraycopy(nums, nums.length - k, temp, 0, k);
        System.arraycopy(nums, 0, nums, k, nums.length - k);
        System.arraycopy(temp, 0, nums, 0, k);
    }
}