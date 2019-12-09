/*
 * @lc app=leetcode.cn id=17 lang=cpp
 *
 * [17] 电话号码的字母组合
 */
#include <vector>
#include <map>
using namespace std;
// @lc code=start
class Solution {
public:
    vector<string> letterCombinations(string digits) {
        map<char,string> phone;
        vector<string> res;
        string str;
        int len=digits.length();
        if(len==0) return res;
        phone['2']="abc";
        phone['3']="def";
        phone['4']="ghi";
        phone['5']="jkl";
        phone['6']="mno";
        phone['7']="pqrs";
        phone['8']="tuv";
        phone['9']="wxyz";
         
        recur(phone,digits,0,str,res);
        return res;
        
    }
    void recur(map<char,string> &phone,string digits,int index,string s ,vector<string> &res){
if(index==digits.length()){
    res.push_back(s);
    return ;
}
string str=phone[digits[index]];
for (int i = 0; i < str.length(); i++)
{
    s.push_back(str[i]);
   recur(phone,digits,index+1,s,res);
   s.pop_back();
}

    }
};
// @lc code=end

