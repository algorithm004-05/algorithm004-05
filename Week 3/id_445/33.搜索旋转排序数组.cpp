/*
 * @lc app=leetcode.cn id=33 lang=cpp
 *
 * [33] 搜索旋转排序数组
 */
#include <vector>
using namespace std;
// @lc code=start
class Solution
{
public:
//solution 1 time limit exceeded
    // int search(vector<int> &nums, int target)
    // {
        // int len = nums.size();
        // int start = 0, end = len, mid = len / 2;
        // while (start < end)
        // {
            // if (nums[mid] == target)
                // return mid;
            // if (nums[mid] > target )//&& nums[mid] >= nums[start])
            // {
                // if(nums[start]>target){
                    // start=mid+1;
                    // mid = (end - start) / 2+start;
                // }else{
                // end = mid;
                // mid = (end - start) / 2+mid;
                // }
            // }
            // else if (target>nums[mid]   )//&& nums[mid] >= nums[start])
            // {
                // if(target>nums[end-1]){
                    // end=mid;
                    // start=(end-start)/2+start;
                // }else{
                // start=mid+1;
                // mid=(end-start)/2+mid;
                // }
            // }
        // }
        // return -1;
    // }
    //solution 2
    int search(vector<int> &nums, int target){
        int low=0,high=nums.size()-1,mid=0;
        while (low<high)
        {
            mid=(low+high)/2;
            if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid]))
                low= mid + 1;
            else
                high = mid;
        }
        return low==high && nums[low]==target ? low:-1;
        
    }
};
// @lc code=end
