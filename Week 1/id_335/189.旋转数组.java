/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
	public void rotate(int[] nums, int k) {
        for(int i=1;i<=k;i++){
        	int m =nums[nums.length-1];
        	for(int j=nums.length-2;j>=0;j--){
        		nums[j+1] = nums[j];
        	}
        	nums[0] = m;
        }
        

    }
}
// @lc code=end

