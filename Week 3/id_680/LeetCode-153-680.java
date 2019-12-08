class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        if(nums.length == 1){
            return nums[0];
        }
        int low = 0, high = nums.length - 1;
        while(nums[low]> nums[high]){
            int mid = (low + high) / 2;
            if(nums[mid] > nums[high]){
                low = mid + 1;
            }else{
                high = mid;
            }

        }
        return nums[low];

    }
}
