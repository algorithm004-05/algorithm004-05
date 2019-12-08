// Author: liuwufang
// Date: 2019/11/24

#include <vector>
#include <algorithm>
using namespace std;

// https://leetcode-cn.com/problems/number-of-1-bits/
// https://leetcode.com/problems/number-of-1-bits/

// Question:
// 231. 2的幂
// 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。

// 示例 1:

// 输入: 1
// 输出: true
// 解释: 20 = 1

// Solution:
bool isPowerOfTwo(int n) {
    return (n > 0) && (n & n - 1) == 0;
}

void leetcode_test_231(void) {
    isPowerOfTwo(1); // true
}
