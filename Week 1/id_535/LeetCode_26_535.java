package id_535;

/**
 * created by lchen on 2019/10/19
 */
public class LeetCode_26_535 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {1,1,2};
        System.out.println(solution.removeDuplicates(nums));
    }
}

class Solution {

    //给定数组 nums = [1,1,2],
    //
    //函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
    //
    //你不需要考虑数组中超出新长度后面的元素。
    public int removeDuplicates(int[] nums) {
        int p1 = 0;
        int p2 = 0;
        while (p2 < nums.length) {
            if (nums[p1] != nums[p2]) {
                nums[++p1] = nums[p2];
            }
            p2++;
        }
        return p1 + 1;
    }
}