/*
 * @lc app=leetcode.cn id=51 lang=cpp
 *
 * [51] N皇后
 */
#include <vector>
#include <string>
using namespace std;
// @lc code=start
class Solution {
    void solve(vector<vector<string>> &res,vector<string> &tmp,vector<bool> &cols,vector<bool> &diags,vector<bool> &diags2,int n, int row){
        if(row==n){
            res.push_back(tmp);
            return;
        }
for(int col=0;col<n;col++){
    int ll=row+col;
    int rr=row-col+n-1;
    if(cols[col]&&diags[ll] && diags2[rr]){
        tmp[row][col]='Q';
        cols[col]=false;
        diags[ll]=false;
        diags2[rr]=false;
        solve(res,tmp,cols,diags,diags2,n,row+1);
        tmp[row][col]='.';
        cols[col]=true;
        diags[ll]=true;
        diags2[rr]=true;
    }
}
    }
public:
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> res;
        vector<string> tmp(n,string(n,'.'));
        vector<bool> cols(n,true);
        vector<bool> diags(2*n-1,true);
        vector<bool> diags2(2*n-1,true);
        solve(res,tmp,cols,diags,diags2,n,0);
        return res;
    }
};
// @lc code=end

