/*
 * @lc app=leetcode.cn id=26 lang=cpp
 *
 * [26] 删除排序数组中的重复项
 */

//解法：1 数组操作删减 2 插入代替删减提高效率
// @lc code=start
//class Solution {
//public:
//    int removeDuplicates(vector<int>& nums) {
//        int j;
//        for (int i = 1 ; i < nums.size() ; i++)
//            if (nums[i-1] == nums[i]){
//                nums.erase(nums.begin() +i-1);
//                --i;
//            }
//        return nums.size();
//    }
//};
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int j = 0;
        int i = 0;
        if (nums.size()==0)
        return 0;
        for ( i ; i < nums.size() ; i++)
            if (nums[i] != nums[j]){
                j++;
                nums[j]=nums[i];
            }
        return j+1;
    }
};



// @lc code=end

