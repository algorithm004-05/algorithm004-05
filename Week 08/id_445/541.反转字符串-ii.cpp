/*
 * @lc app=leetcode.cn id=541 lang=cpp
 *
 * [541] 反转字符串 II
 */
#include <string>
using namespace std;
// @lc code=start
class Solution {
public:
    string reverseStr(string s, int k) {
        if(s.length()<=1 ) return s;
        if(k<2) return s;
        int mid=k/2,end=0;
        char temp;
        for (int i = 0; i < s.length(); i=i+2*k)
        {
            
            if(s.length()-i<k) k=s.length()-i;
            end=i+k;
            mid=i+k/2;
            
            for(int j=i;j<mid;j++){
                temp=s[j];
                s[j]=s[end-j+i-1];
                s[end-j+i-1]=temp;
            }
        }
        return s;
        
    }
};
// @lc code=end

