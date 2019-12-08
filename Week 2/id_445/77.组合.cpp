/*
 * @lc app=leetcode.cn id=77 lang=cpp
 *
 * [77] 组合
 */
#include<vector>
using namespace std;
// @lc code=start
class Solution {
public:
///solution O(n^2)
    vector<vector<int>> combine(int n, int k) {
        vector<vector<int>>  res;
        if(n<=0 || k<=0|| k>n) return res;
        vector<int> path;
        recur(n,k,1,res,path);
        
return res;
        
    }
    void recur(int n,int k ,int start,vector<vector<int>> &res,vector<int> &path){
        if(path.size()==k){
            res.push_back(path);
            return ;
        }
        for (int i = start; i <=n-(k-path.size())+1; i++)
        {
            path.push_back(i);
            recur(n,k,i+1,res,path);
            path.pop_back();

        }
        
}


};
// @lc code=end

