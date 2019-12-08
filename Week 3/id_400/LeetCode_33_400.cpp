class Solution {
public:
    int search(vector<int>& nums, int target) {
        //不是严格的单调，但存在一定的单调性
        //首先看左边界和中间值是否单调递增，然后查找目标值是否在该单调区间之内
        //如果左边不是单调递增的，那么右边是单调递增的。
        int low = 0; 
        int high = nums.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[0] <= nums[mid] && (nums[0] > target || nums[mid] < target)) {
                low = mid + 1;
            } else if (target < nums[0] && target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
};
