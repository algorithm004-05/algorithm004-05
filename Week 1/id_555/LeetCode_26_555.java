package lsn01.array.homework;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 
 * 26. 删除排序数组中的重复项
 *
 */
public class LeetCode_26_555 {

	public static void main(String[] args) {
		LeetCode_26_555 leetCode = new LeetCode_26_555();
		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
//		int[] nums = {};
		int length = leetCode.removeDuplicates(nums);
		System.out.println(length);
	}

	/**
	 * 双指针法：时间复杂度：O(n)，空间复杂度：O(1)。
	 */
	public int removeDuplicates(int[] nums) {

		if (nums.length == 0)
			return 0;// 注意边界条件

		int i = 0;// i是慢指针

		for (int j = 1; j < nums.length; j++) {// j是快指针
			if (nums[i] != nums[j]) {
				i++;
				nums[i] = nums[j];// 设置当前需要查重的数字
			}
		}

		return i + 1;

	}

}
