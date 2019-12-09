class Solution {
    //1.暴力解法
    public void rotate(int[] nums, int k) {
        int g;
        for(int i = 0; i<k; i++){
            for(int j = 0 ; j< nums.length; j++) {
                g = nums[j];
                nums[j] = nums[nums.length -1];
                nums[nums.length -1] = g;
            }
        }
    }

    //2.替换
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums,0,nums.length - 1);
        reverse(nums,0,k - 1);
        reverse(nums,k,nums.length - 1);
    }

    public void reverse(int[] nums,int start,int end) {
        int temp;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}