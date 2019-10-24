class LeetCode_189_105 {
    public void rotate(int[] nums, int k) {
        for(int i =  0; i < k ; i++){
            int j = nums.length - 1;
            int temp = nums[j];
            for(; j > 0; j--){
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }
    }
}