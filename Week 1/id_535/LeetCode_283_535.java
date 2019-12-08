package id_535;

/**
 * 移动零
 * created by lchen on 2019/10/20
 */
public class LeetCode_283_535 {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 0, 3, 12};
        Solution3 solution3 = new Solution3();
        solution3.moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}

class Solution3 {

    public void moveZeroes(int[] nums) {
        int p1 = 0;
        int p2 = 0;
        while (p2 < nums.length) {
            if (nums[p1] == 0) {
                if (nums[p2] != 0) {
                    nums[p1] = nums[p2];
                    nums[p2] = 0;
                } else {
                    p2++;
                }
            } else {
                p1++;
                p2++;
            }
        }


    }
}
