/*
 * @lc app=leetcode.cn id=22 lang=cpp
 *
 * [22] 括号生成
 *
 * https://leetcode-cn.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (72.07%)
 * Likes:    581
 * Dislikes: 0
 * Total Accepted:    49.1K
 * Total Submissions: 68K
 * Testcase Example:  '3'
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 
 * 例如，给出 n = 3，生成结果为：
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 * 
 */

// @lc code=start
# if 0
class Solution {
public:
    vector<string> ret;
    vector<string> generateParenthesis(int n) {
        int l=1,r=0;
        string s = "(";
        backTrack(s,l,r,n);
        return ret;
    }
    void backTrack(string s, int l, int r, int n){
        if(s.size() == 2*n){
            ret.push_back(s);
            return ;
        }
        if (l<n){
            backTrack(s+"(",l+1,r,n);
        }
        if (r<l){
            backTrack(s+")",l,r+1,n);
        }
    }
};
#elif 1
//暴力法，暴力法更容易理解题意
class Solution {
public:
    vector<string> ret; 
    vector<string> generateParenthesis(int n) {
        string s;
        int r=0,l=0;
        generateall(s,r,l,n);
        return ret;
    }
    void generateall(string s, int r, int l, int n){
        if(s.size()==2*n){
            if(isok(s,r,l,n)) ret.push_back(s);
        }
        generateall(s+"(",r,l+1,n);
        generateall(s+")",r+1,l,n);
    }
    bool isok(string s,int l, int r, int n){
        if(s[0] == '('){
            if (l==r && l+r==n)
            return true;
        }
        return false;
    }
};
//超出内存限制
#else 0
#endif
// @lc code=end

