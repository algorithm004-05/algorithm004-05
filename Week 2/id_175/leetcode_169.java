//给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
//
// 你可以假设数组是非空的，并且给定的数组总是存在众数。
//
// 示例 1:
//
// 输入: [3,2,3]
//输出: 3
//
// 示例 2:
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
//
// Related Topics 位运算 数组 分治算法


//leetcode submit region begin(Prohibit modification and deletion)
class leetcode_169 {
	/**
	 * 暴力法
	 *
	 * @param nums
	 * @return
	 */
	public int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		if (nums == null) {
			return 0;
		}
		int maxNum = 0, maxCount = 0;
		for (int num : nums) {
			int count = map.getOrDefault(num, 0) + 1;
			map.put(num, count);
			if (count > maxCount) {
				maxCount = count;
				maxNum = num;
			}
		}
		return maxNum;
	}
	
	/**
	 * 1, 将第一个数保存在condidate中,且count为1
	 * 2.遍历这个数组
	 * 3.当数字和之前保存的数字相同的时候就count+1;否则count-1
	 * 4.当count为0的时候,condidate进行变化,且count重置为1
	 *
	 * @param nums
	 * @return
	 */
	public int majorityElement(int[] nums) {
		int candidate = nums[0], count = 1;
		for (int i = 0; i < nums.length; i++) {
			if (count == 0) {
				candidate = nums[i];
				count = 1;
			} else if (nums[i] == candidate) {
				count++;
			} else {
				count--;
			}
		}
		return candidate;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
