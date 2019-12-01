// Author: liuwufang
// Date: 2019/11/24

#include <vector>
#include <algorithm>
using namespace std;

// https://leetcode-cn.com/problems/number-of-1-bits/
// https://leetcode.com/problems/number-of-1-bits/

// Question:
// 191. 位1的个数
// 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
// 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。

// 示例 1：
// 输入：00000000000000000000000000001011
// 输出：3
// 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。

// Solution:
int hammingWeight(uint32_t n) {
    int cnt = 0;
    while (n) {
        cnt++;
        n &= (n - 1);
    }

    return cnt;
}

int hammingWeight2(uint32_t n) {
    int cnt = 0;
    while (n) {
        if (n & 1) cnt++;
        n >>= 1;
    }

    return cnt;
}

void leetcode_test_191(void) {
    // 00000000000000000000000000001011
    hammingWeight(11); // 3
    hammingWeight2(11); // 3
}
