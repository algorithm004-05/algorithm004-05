/*
 * @lc app=leetcode.cn id=367 lang=cpp
 *
 * [367] 有效的完全平方数
 */

// @lc code=start
class Solution {
public:
    bool isPerfectSquare(int num) {
        int start=0,end=num/2+1;
        long mid=0;
        while (start<=end)
        {
            mid=(start+end)/2;
            long long res=mid*mid;
            if(res==num) return true;
            if(start==end) return false;
            if(num>res) start=mid+1;
            else end=mid-1;
        }
        return false;
        
    }
};
// @lc code=end

