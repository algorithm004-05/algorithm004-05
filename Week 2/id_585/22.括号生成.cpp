/*
 * @lc app=leetcode.cn id=22 lang=cpp
 *
 * [22] 括号生成
 */

// @lc code=start
//class Solution {
//public:
//    vector<string> generateParenthesis(int n) {
//        int i = 1;
//        string str;
//        vector<string> res = generateParenthesis( i, n, str);
//        return res;
//private:
//        string generateParenthesis(int i, int n, string res) {
//            if (i == n)
//                return res;
//            res.push_back('(');
//            res.push_back(')');
//        generateParenthesis(int i + 1, int n, string res) {
//    }
//};
class Solution {
public:
    vector<string> generateParenthesis(int n) {
        generate(0, 0, n, "");
        return result;
    }
private:
    void generate(int left, int right, int n, string s){
        //terminator
        if (left == n && right == n){
            result.push_back(s);
            return;
        }
        //process
        //drill down
        if (left < n)
            generate(left + 1, right, n, s + '(' );
        if (right < left)
            generate(left, right + 1, n, s + ')');
        //reverse state
    }
    vector<string> result;
};
// @lc code=end

