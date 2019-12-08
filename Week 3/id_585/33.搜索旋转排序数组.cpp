/*
 * @lc app=leetcode.cn id=33 lang=cpp
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public:
    int search(vector<int>& nums, int target) {
        if (nums.empty()) return -1;
        if (target < nums[0] && target > nums.back()) return -1;
        int inversePoint  = 0 ;
        int left = 0, right = nums.size() - 1;
        while(left <= right){
            int mid = left + (right -left)/2;
            if (nums[mid] <= nums[right] && nums[mid] >= nums[left]){
                inversePoint = left;
                break;
            }
            if (nums[mid] >= nums[left] )
                left = mid + 1;
            else
                right = mid ;
        }
           cout<< "inverP " << inversePoint << endl;
        if(target >= nums[inversePoint] &&  target < nums[0] ){
            left =  inversePoint;
            right = nums.size() - 1; 
        }
        else if  (inversePoint != 0){ 
            left = 0;
            right = inversePoint  - 1;
        }
        else{
            left = 0;
            right = nums.size()-1;
        }
        while(left <= right){
            int mid = left + (right -left)/2;
           cout<< "left " << left << " right "<< right<< " mid "<<mid<< endl;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > target )
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
};
// @lc code=end

