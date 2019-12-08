package id_535;

/**
 * 旋转数组
 * created by lchen on 2019/10/19
 */
public class LeetCode_189_535 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        Solution1 solution1 = new Solution1();
        solution1.rotate(nums, 3);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

}

class Solution1 {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        //反转整个数组。
        reverse(nums, 0, nums.length - 1);
        //反转前k个元素
        reverse(nums, 0, k - 1);
        //反转后n-k个元素
        reverse(nums, k, nums.length - 1);

    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }

    }
}