// Author: liuwufang
// Date: 2019/11/24

#include <vector>
#include <algorithm>
using namespace std;

// https://leetcode-cn.com/problems/number-of-1-bits/
// https://leetcode.com/problems/number-of-1-bits/

// Question:
// 190. 颠倒二进制位
// 颠倒给定的 32 位无符号整数的二进制位。

// 示例 1:
// 输入: 00000010100101000001111010011100
// 输出: 00111001011110000010100101000000
// 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
// 因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。


// Solution:

// n >> i & 1      // get the i index value
// n &= ~(1 << i)  // set 0 
// n |= (1 << i)   // set 1
uint32_t reverseBits(uint32_t n) {
    int i = -1;
    int j = 32;

    while (++i < --j) {
        if ((n >> i & 1) ^ (n >> j & 1)) {
            if (n >> i & 1) {
                n &= ~(1 << i);
                n |= (1 << j);
            } else {
                n |= (1 << i);
                n &= ~(1 << j);
            }
        }
    }
    return n;
}

uint32_t reverseBits2(uint32_t n) {
    uint32_t ans=0;
    //进制的本质
    int i=32;
    while(i--)
    {
        ans <<= 1;
        ans += n & 1;
        n >>= 1;
    }
    return ans; 
}


void leetcode_test_231(void) {
    // 00000010100101000001111010011100
    int n = 1111;
    reverseBits(1111); // 964176192 (00111001011110000010100101000000)
    reverseBits2(1111); // 964176192 (00111001011110000010100101000000)
}
