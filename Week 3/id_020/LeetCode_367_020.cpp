// Author: liuwufang
// Date: 2019/10/20

#include <vector>
using namespace std;

// https://leetcode-cn.com/problems/valid-perfect-square/
// https://leetcode.com/problems/valid-perfect-square/

// Question:
// 367. 有效的完全平方数
// 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
// 说明：不要使用任何内置的库函数，如  sqrt


// Solution:
// 思路1: 二分法 
// 要注意边界条件，当left >= right的时候终止返回 
// 时间复杂度：O(logN)
// 空间复杂度：O(1)

bool isPerfectSquare(int num) {
    if (num == 1 || num == 0) return true;
    int left = 1;
    int right = num / 2 + 1;
    while (left <= right) {
        long long mid = left + (right - left + 1) / 2;
        long long sqrt = mid * mid;
        if (sqrt == num) return true;
        else if (sqrt < num) left = mid + 1;
        else right = mid - 1;
    }

    return false;
}

// 思路2:牛顿迭代法（ (x, f(x))(x,f(x)) 的切线来逼近方程 x^2-a=0的根）newton's method
// (x+a/x)/2
// 时间复杂度：O(1) 待研究
bool isPerfectSquare2(int num) {
    long x = num;
    while (x * x > num) {
        x = (x + num / x) >> 1;
    }
    
    return x * x == num;
}

void leetcode_test_367(void) {
    isPerfectSquare(16); // true
    isPerfectSquare2(7); // false
}

int main() {
    leetcode_test_367();
    return 0;
}