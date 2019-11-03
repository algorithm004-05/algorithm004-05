/**
 * @Auther: shizeying
 * @Date: 19-10-20 20:22
 * @Description:
 */
public class LeetCode_26 {
	public int removeDuplicates(int[] nums) {
		if (nums == null) return Integer.parseInt(null);
		int j = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[j]) {
				j++;
				nums[j] = nums[i];
			}
		}
		
		return j + 1;
	}
}
