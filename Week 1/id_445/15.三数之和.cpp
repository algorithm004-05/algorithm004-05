/*
 * @lc app=leetcode.cn id=15 lang=cpp
 *
 * [15] 三数之和
 */
#include <vector>
#include <algorithm>
using namespace std;
// @lc code=start

class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> res;
        int sum;
       sort(nums.begin(),nums.end());
       for (int i = 0; i < nums.size(); i++)
       {
          int target=-nums[i];
          int first=i+1;
          int last=nums.size()-1;

          while (first<last)
          {
              sum=nums[first]+nums[last];
              if(target==sum){
                 vector<int> sumNum(3,0);
                 sumNum[0]=nums[i];
                 sumNum[1]=nums[first];
                 sumNum[2]=nums[last];
                 res.push_back(sumNum);
                 while (first<last&&nums[first]==sumNum[1])first++;
                 while (first<last &&nums[last]==sumNum[2]) last--;
              }else if (target>sum)
              {
                  first++;
              }else  last--;
              while (i+1<nums.size()&&nums[i+1]==nums[i])i++;
              
              
          }
          
       }
       return res;
       
    }
};
// @lc code=end

