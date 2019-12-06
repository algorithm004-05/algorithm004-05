/*
 * @lc app=leetcode.cn id=387 lang=cpp
 *
 * [387] 字符串中的第一个唯一字符
 */
#include <string>
#include <map>
using namespace std;
// @lc code=start
class Solution {
public:
//solution 1 fast
    // int firstUniqChar(string s) {
    //     int len=s.length();
    //     int hash[26]={0};
    //     if (len<1)
    //         return -1;
    //     for (int i=0; i < len; i++)
    //     {
    //         hash[s[i]-97]++;
    //     }
      
    //     for (int i = 0; i < len; i++)
    //     {
    //         if(hash[s[i]-97]==1) return i;
    //     }
        
    //     return -1;
    // }
    //solution 2
     int firstUniqChar(string s) {
         int len=s.length();
         if(len<1) return -1;
         map<char,int> ss;
         for (int i = 0; i < len; i++)
         {
             ss[s[i]]++;
         }

         for (int i = 0; i < len; i++)
         {
             if(ss[s[i]]==1) return i;
         }
         return -1;

         

     }
};
// @lc code=end

