/*
 * @lc app=leetcode.cn id=191 lang=cpp
 *
 * [191] 位1的个数
 */
#include <stdint.h>
using namespace std;
// @lc code=start
class Solution {
public:
//solution 1
    // int hammingWeight(uint32_t n) {
    //     return (n > 0) ? 1 + hammingWeight(n & (n - 1)) : 0;
        
    // }
/// solution 2
//  int hammingWeight(uint32_t n) {
//      int count=0;
//      while (n>0)
//      {
//          n=n & (n - 1);
//          count++;
         
//      }
//      return count;
     
//         // return (n > 0) ? 1 + hammingWeight(n & (n - 1)) : 0;
        
//     }

    //solution 3
    int hammingWeight(uint32_t n) {
        int count=0;
        int mask=1;
        while (n>0)
        {
            if((n&mask)!=0) count++;
            n=n>>1;
        }
        return count;
        
    }
};
// @lc code=end

