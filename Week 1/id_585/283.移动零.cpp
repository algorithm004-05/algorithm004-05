/*
 * @lc app=leetcode.cn id=283 lang=cpp
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
public:
    void moveZeroes(vector<int>& nums) {
      
    int snowBall = 0;
    
    for (int i = 0; i < nums.size() ; i++){
        if(nums[i] == 0){
            snowBall++;
        }
        else{
            swap(nums[i-snowBall],nums[i]);
        }
    }
    }
};
//相比两个指针指出0所在位置+swap（）的方法显著慢了 为什么？
// @lc code=end

