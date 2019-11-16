/*
 * @lc app=leetcode.cn id=169 lang=cpp
 *
 * [169] 求众数
 */

// @lc code=start
class Solution {
    public:
    int majorityElement(vector<int>& nums)
    {
        int half_falg = nums.size() / 2;  //判断是否出现的次数超过一半
        for (int i : nums) {              //遍历数组
            int count = 0;
            for (int j : nums) {  //遍历数组，找到元素i在数组中出现的次数
                if (j == i) {
                    count++;
                }
            }
            if (count > half_falg) {  //如果次数大于一半，则将该数返回，结束程序
                return i;
            }
        }
        return -1;
    }
};
/*
Time Limit Exceeded
42/44 cases passed (N/A)
暴力循环，时间复杂度较高O(n^2)
*/