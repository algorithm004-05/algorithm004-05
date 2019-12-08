/*
 * @lc app=leetcode.cn id=46 lang=cpp
 *
 * [46] 全排列
 */
#include <vector>
#include <stack>
using namespace std;
// @lc code=start
class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> res;
        int len=nums.size();
        int used[len];
        for (int i = 0; i < len; i++)
        {
            used[i]=0;
        }
        
        if(len==0) return res;
        vector<int> path;
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

