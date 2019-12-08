class LeetCode_26_105 {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for(int fast = 1; fast < nums.length ; fast++){
            if(nums[fast] != nums[slow]){
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1 ;
    }
}