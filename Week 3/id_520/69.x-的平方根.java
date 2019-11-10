/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */

// @lc code=start



//y = x^2

class Solution {
    public int mySqrt(int x) {

        //方法一，二分查找
        // if (x == 0 || x == 1) {
        //     return x;
        // }

        // int left = 1;
        // int right = x;
        // while (left < right) {
        //     //防止mid值越数组界，所以用了这个方法而不是模板中的(left + right)/2
        //     int mid = left + (right - left) / 2;
        //     if (mid * mid > x) {
        //         right = mid - 1; 
        //     } else {
        //         left = mid + 1;
        //     }
        // }
        // return right;


        //方法二，牛顿迭代法。这个类似纯数学的思路,使用牛顿迭代法数学公式
        long r = x;
        while (r*r > x) {
            r = (r + x/r) /2;
        }
        return (int)r;
    }
}
// @lc code=end

