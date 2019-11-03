/*
 * @lc app=leetcode.cn id=47 lang=cpp
 *
 * [47] 全排列 II
 */

// @lc code=start
//class Solution {
//public:
//    vector<vector<int>> result; 
//    vector<vector<int>> permuteUnique(vector<int>& nums) {
//        vector<bool> used(nums.size(),false); 
//        vector<int> temp; 
//        sort(nums.begin(),nums.end());
//        permuteUnique(0,nums.size(), used, temp, nums);
//        return result;
//    }
//private:
//    void permuteUnique(int curr,  int size, vector<bool> &used, vector<int> &temp, vector<int>& nums) {
//        if(curr == size  ){
//            result.push_back(temp);
//            return;
//        }
//        for(int i = 0; i < size; i++){
//            if(!used[i]){
//                if(i > 0 && nums[i] == nums[i-1] && used[i-1])
//                    continue;
//                used[i] = true;
//                temp.push_back(nums[i]);
//                //必须为+1 ++不好用
//                permuteUnique(curr + 1, size, used, temp, nums);
//                temp.pop_back();
//                used[i] = false;
//            }
//        }
//         //   return;
//    }
//};
class Solution {
        vector<vector<int>> res;
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        permuteUnique(0,nums.size(),  nums);
        return res;
    }
private:
//这里的nums 如果用引用会引起重复,不使用引用可以不用reverse？ backtracking?
    void permuteUnique(int curr,  int size,  vector<int> nums ) {
        if(curr == size - 1){
            res.push_back(nums);
            return;
        }
        for(int k =  curr ; k < size; k++){
            if(curr != k && nums[curr] == nums[k]) continue;
                swap(nums[curr],nums[k]);
                permuteUnique(curr + 1, size, nums);
            }
        }
};
// @lc code=end

