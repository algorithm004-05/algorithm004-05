/*
 * @lc app=leetcode.cn id=191 lang=cpp
 *
 * [191] 位1的个数
 */

// @lc code=start
class Solution {
    public:
    int hammingWeight(uint32_t n)
    {  //uint32_t是别名，unsigned int
        int ans = 0;
        uint32_t mask = 1;
        for (int i = 0; i < 32; i++) {
            if (mask & n) {     //位运算，当mask为1时取最后一位数
                ans++;
            }
            mask <<= 1;     //左移赋值运算符
        }
        return ans;
    }
};
/*
Accepted
601/601 cases passed (8 ms)
Your runtime beats 36.85 % of cpp submissions
Your memory usage beats 5.21 % of cpp submissions (8.3 MB)
*/

/*
 * @lc app=leetcode.cn id=191 lang=cpp
 *
 * [191] 位1的个数
 */

// @lc code=start
class Solution {
    public:
    int hammingWeight(uint32_t n)
    {  //uint32_t是别名，unsigned int
        int ans(0);
        while (n != 0) {
            ans++;
            n &= (n - 1);  //n与n-1的与会把最后一个1变成0
        }
        return ans;
    }
};
/*
Accepted
601/601 cases passed (8 ms)
Your runtime beats 36.85 % of cpp submissions
Your memory usage beats 5.21 % of cpp submissions (8.3 MB)
*/