// Author: liuwufang
// Date: 2019/10/20

#include <vector>
using namespace std;

// https://leetcode-cn.com/problems/sqrtx/
// https://leetcode.com/problems/sqrtx/

// Question:
// 69. x 的平方根
// 实现 int sqrt(int x) 函数。
// 计算并返回 x 的平方根，其中 x 是非负整数。
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去

// Solution:
// 思路1: 二分法 
// 要注意边界条件，当left >= right的时候终止返回right（向下取整）的答案
// 时间复杂度：O(logN)
// 空间复杂度：O(1)

int mySqrt(int x) {
    if (0 == x || 1 > x) return 0;
    int left = 1;
    int right = x / 2 + 1;

    while (left <= right) {
        long long mid = left + (right - left + 1) / 2;
        long long sqrt = mid * mid;
        if (sqrt == x) return mid;
        else if (sqrt < x) left = mid + 1;
        else right = mid - 1; 
    }
    
    return right; // 向下取整
}

// 思路2:牛顿迭代法（ (x, f(x))(x,f(x)) 的切线来逼近方程 x^2-a=0的根）newton's method
// (x+a/x)/2
int mySqrt2(int x) {
    long long ans = x;
    while ( ans * ans > x) {
        ans = (ans + x / ans) / 2;
    }

    return ans;
}

void leetcode_test_069(void) {
    mySqrt(7); // 2
    mySqrt2(7); // 2
}

int main() {
    leetcode_test_069();
    return 0;
}