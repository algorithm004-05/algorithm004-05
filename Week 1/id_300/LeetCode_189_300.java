class Solution {
    public void rotate(int[] nums, int k) {
        // O(N*K) 数组每次移动一步，移动k次
        for(int i = 1;i <= k; i++){
            for (int j = 0; j < nums.length; j++){
                int a = nums[j];
                nums[j] = nums[nums.length-1];
                nums[nums.length-1] = a;
            }
        }
    }
}
