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




/*
 * @lc app=leetcode.cn id=242 lang=cpp
 *哈希
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public:
    bool isAnagram(string s, string t)
    {
        if (s.length() != t.length()) {
            return false;
        }
        int n = s.length();
        unordered_map<char, int> count; //定义map
        for (int i = 0; i < n; ++i) {
            count[s[i]]++;  //s[i]是key，s[i]对应的value++
            count[t[i]]--;  //t[i]是key，t[i]对应的value++
        }
        for (auto j : count) {  //迭代器遍历
            if (j.second) { //访问map中的第二个对象（int)，检查所有的char对应的int是否为0
                return false;
            }
        }
        return true;
    }
};
/*
Accepted
34/34 cases passed (16 ms)
Your runtime beats 66.75 % of cpp submissions
Your memory usage beats 5.14 % of cpp submissions (9.6 MB)
*/