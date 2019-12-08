/*
 * @lc app=leetcode.cn id=22 lang=cpp
 *
 * [22] 括号生成
 */
#include <vector>
#include <string>
using namespace std;
// @lc code=start
class Solution {
public:
vector<string> res;
    vector<string> generateParenthesis(int n) {
        recur(0,0,n,"");
        return res;
    }
    void recur(int lcount,int rcount,int depth,string str){
if(lcount>depth)return;
if(rcount>depth) return;
if(rcount>lcount)return;
if(lcount==rcount&&lcount==depth){
    res.push_back(str);
    return;
}
recur(lcount+1,rcount,depth,str+"(");
recur(lcount,rcount+1,depth,str+")");

    }
};
// @lc code=end

