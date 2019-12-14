class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (right - left == 1) {
                return Math.min(nums[left], nums[right]);
            }
            int mid = (left + right) / 2;
            if (nums[left] < nums[mid] && nums[mid] < nums[right]) {
                right--;
            } else if (nums[left] > nums[mid]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid;
            }
        }
        return Math.min(nums[left], nums[right]);
    }
}
