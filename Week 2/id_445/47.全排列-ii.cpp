/*
 * @lc app=leetcode.cn id=47 lang=cpp
 *
 * [47] 全排列 II
 */
#include <vector>
#include <algorithm>
using namespace std;
// @lc code=start
class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        int len=nums.size();
        int used[len];
        vector<vector<int>> res;
        vector<int> path;
        for (int i = 0; i < len; i++)
        {
            used[i]=0;
        }
        if (len==0)return res;
        
        sort(nums.begin(),nums.end());
        
        recur(nums,used,0,len,path,res);
        return res;

    }

     void recur(vector<int>& nums,int used[],int curSize, int len,vector<int> & path,vector<vector<int>>& res){
if(path.size()==len){
res.push_back(path);
return;
}
for (int i = 0; i < len; i++)
{
    if(!used[i]){
        if(i>0&&nums[i]==nums[i-1]&&used[i-1]!=1)continue;
        path.push_back(nums[i]);
        used[i]=1;
        recur(nums,used,curSize+1,len,path,res);
        path.pop_back();
        used[i]=0;
    }
}


    }
};
// @lc code=end

