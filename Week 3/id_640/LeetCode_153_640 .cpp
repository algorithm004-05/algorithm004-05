class Solution {
    public:
    int findMin(vector<int>& nums)
    {
        sort(nums.begin(), nums.end());
        return nums[0];
    }
};
/*
Accepted
146/146 cases passed (8 ms)
Your runtime beats 54.38 % of cpp submissions
Your memory usage beats 5.57 % of cpp submissions (8.9 MB)
先排序，找出排序后的第一个元素，时间复杂度和空间复杂度都较高
*/

class Solution {
    public:
    int findMin(vector<int>& nums)
    {
        int left = 0;
        int right = nums.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return nums[left];
    }
};
/*
Accepted
146/146 cases passed (4 ms)
Your runtime beats 90.67 % of cpp submissions
Your memory usage beats 65.09 % of cpp submissions (8.6 MB)
采用二分查找的方法来寻找最小值。
*/
