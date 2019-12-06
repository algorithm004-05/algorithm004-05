/*
 * @lc app=leetcode.cn id=8 lang=cpp
 *
 * [8] 字符串转换整数 (atoi)
 */
#include <string>
#include <limits>
using namespace std;
// @lc code=start
class Solution {
public:
///ascii '0'-48  '9'-57   '-'-45  ' '-32 '+'-43
    int myAtoi(string str) {
        
        int len=str.length(),end=0,res=0,num=0;
        long max=2147483647;
        int sign=1;
        if(len<1) return 0;
        int i=0;
        //delete space
        while (str[i]==32)i++;
        
        ///identify sign
        if(str[i]==45) {
            sign=-1;
            max=max+1;
            i++;
            }else if(str[i]==43)
            {
                i++;
            }
            
        ///skip 0 from starting  position
        while (str[i]==48)i++;
        // if(str[i]==43) i++;
        if(str[i]<48 || str[i]>57) return 0;
        end=i;
        while (str[end]>=48 && str[end]<=57)
        {
            if(end-i>9) return max*sign;
            res=res+num;
            num=str[end]-48;
            if(end-i == 9){
                if(res>max/10) return max*sign;
                if(res==max/10&&(max%10<(num))) return max*sign;
                
            }
            res=res*10;
            end++;
        }
        return res*sign+sign*num;
        
        
    }
};
// @lc code=end

