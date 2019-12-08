public class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0) {
            return -1;
        }
        
        int l = 0;
        int r = nums.length - 1;
        
        while(l < r - 1){
            int m = l + (r - l) / 2;
            if(nums[m] == target){
                return m;
            }
            
            if(nums[l] < nums[m]){
                if(target > nums[m] || target < nums[l]){
                    l = m;
                } else {
                    r = m;
                }
            } else {
                if(target > nums[m] && target <= nums[r]){
                    l = m;
                } else {
                    r = m;
                }
            }
        }
        
        if(nums[l] == target){
            return l;
        }
        
        if(nums[r] == target){
            return r;
        }
        
        return -1;
        
    }
}
