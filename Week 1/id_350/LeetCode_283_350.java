class Solution {
    public void moveZeroes(int[] nums) {
        int notZeroIndex = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] != 0){
                if(i > notZeroIndex){
                    nums[notZeroIndex] = nums[i];
                    nums[i] = 0 ;
                }
                notZeroIndex++;
            }
        }
    }
}