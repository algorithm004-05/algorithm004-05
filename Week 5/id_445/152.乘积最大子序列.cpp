/*
 * @lc app=leetcode.cn id=152 lang=cpp
 *
 * [152] 乘积最大子序列
 */
#include <vector>
#include <limits.h>
using namespace std;
// @lc code=start
class Solution {
public:
    int maxNum(int a,int b){
        return a>b?a:b;
    }
    int minNum(int a,int b){
        return a>b?b:a;
    }
    int maxProduct(vector<int>& nums) {
        int min=1,max=1,res=INT_MIN,temp=0; 
        for(auto num:nums){
            if(num<0){
                temp=min;
                min=max;
                max=temp;
            }
        
            max=maxNum(max*num,num);
            min=minNum(min*num,num);
            res=maxNum(res,max);
        }
        return res;
    }
};
// @lc code=end

