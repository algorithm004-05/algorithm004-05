// Author: liuwufang
// Date: 2019/12/08

#include <map>
#include <string>
#include <algorithm>
using namespace std;

// https://leetcode-cn.com/problems/string-to-integer-atoi/
// https://leetcode.com/problems/string-to-integer-atoi/

// Question:
// 8. 字符串转换整数 (atoi)
// 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
// 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
// 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
// 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
// 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
// 在任何情况下，若函数不能进行有效的转换时，请返回 0。

// 说明：
// 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31,  2^31 − 1]。如果数值超过这个范围，请返回  INT_MAX (2^31 − 1) 或 INT_MIN (−2^31) 。


// Solution:
// 1.去空格
// 2.判断正负号
// 3.判断是否是数字字符
// 4.判断是否越界

// 时间复杂度:O(N)
// 空间复杂度:O(1)
int myAtoi(string str) {
    bool bNeg = false;
    int num = 0;
    int len = str.length();
    int i = 0;
    if (len == 0) return 0;
    // 1.process ' '
    while (i < len) {
        if (str[i] != ' ') break;
        i++;
    }

    // 2.process bNeg
    if (str[i] == '+' || str[i] == '-') {
        bNeg = str[i] == '-' ? true : false;
        i++;
    }

    // 3.process digit
    while (i < len) {
        int digit = str[i] - '0';
        if (digit < 0 || digit > 9) break;
        // 越界处理，尤其需要注意
        if (num > INT_MAX / 10 || (num == INT_MAX / 10 && digit > INT_MAX % 10) ) {
            return bNeg ? INT_MIN : INT_MAX;
        }

        num = num * 10 + digit;
        i++;
    }

    return bNeg ? -num : num;
}

void leetcode_test_008(void) {
    string str = "-2147483648";
    myAtoi(str); // 2147483648
}
