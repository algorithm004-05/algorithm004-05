/*
 * @lc app=leetcode.cn id=367 lang=cpp
 *
 * [367] 有效的完全平方数
 */

// @lc class Solution {
class Solution
{
public:
    bool isPerfectSquare(int x) {
        long int left = 0, right = x, mid = 0;
        while(right > left){
            mid = (right + left + 1)/2 ;
            if (pow(mid,2) == x){
                return mid;
            }else if(pow(mid,2) < x){
                left = mid ;
            }else{
                right = mid -1;
            }
        }
        if (left^2 < x )
            return false;
        return true;
    }
};

// @lc code=end

