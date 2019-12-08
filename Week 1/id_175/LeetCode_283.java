/**
 * @Auther: shizeying
 * @Date: 19-10-20 20:22
 * @Description:
 */
public class LeetCode_283 {
	public void moveZeroes(int[] nums) {
		if (nums.length == 0) return;
		int slow = 0;
		for (int num : nums) {
			if (num != 0) {
				nums[slow] = num;
				
				slow++;
			}
		}
		while (slow < nums.length) {
			nums[slow] = 0;
			slow++;
		}
	}
}
