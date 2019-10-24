package id_370;

public class Leetcode_26_370 {
    public int removeDuplicates(int[] nums) {
	int i = 0;
	int j = 0;
	while (++j < nums.length) {
	    if (nums[i] != nums[j])
		nums[++i] = nums[j];
	}
	return ++i;
    }
}