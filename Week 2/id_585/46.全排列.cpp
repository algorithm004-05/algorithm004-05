/*
 * @lc app=leetcode.cn id=46 lang=cpp
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
public:
    vector<vector<int>> res; 
    vector<vector<int>> permute(vector<int>& nums) {
        recursion(0, nums.size(), nums);
        return res;
    }
public:
//这里如果不用nums的引用，下面可以省略swap对应的reverse 的过程
    void recursion(int level, int size, vector<int> &nums) {
        if(level == size -1) {
            res.push_back(nums);
            return;
        }
        for( int i = level; i < size; i++){
            swap(nums[i], nums[level]);
            recursion(level+1, size, nums);
            swap(nums[i], nums[level]);
        }
    }
};
// @lc code=end

