/*
 * @lc app=leetcode.cn id=69 lang=cpp
 *
 * [69] x 的平方根
 */

// @lc code=start
class Solution {
public:
//solution 1
    // int mySqrt(int x) {
    //     int i=0,j=x/2+1,mid=0;
    //     long res;

    //     while (i<=j)
    //     {
    //        long  long mid=(i+j)/2;

    //         res=mid*mid;
    //         if(res==x) return mid;
    //         if(res>x)
    //             j=mid-1;
    //         else i=mid+1;
    //     }
    //     return j;
        

    // }

        int mySqrt(int x) {
        if(x==0) return 0;
        double res=1,last=0;

        while (last != res)
        {
            last=res;
         res=(last+x/res)/2;
        }
        return res;
        

    }
};
// @lc code=end

