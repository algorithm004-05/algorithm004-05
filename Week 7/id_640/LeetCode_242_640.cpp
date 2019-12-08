/*
 * @lc app=leetcode.cn id=242 lang=cpp
 *
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
        unordered_map<char, int> count;  //定义map
        for (int i = 0; i < n; ++i) {
            count[s[i]]++;  //s中的元素+1
            count[t[i]]--;  //t中的元素-1
        }
        for (auto j : count) {  //迭代器遍历
            if (j.second) {     //访问map中的第二个对象（int)，检查所有的char对应的int是否为0
                return false;
            }
        }
        return true;
    }
};
/*
Accepted
34/34 cases passed (12 ms)
Your runtime beats 81.64 % of cpp submissions
Your memory usage beats 5.14 % of cpp submissions (9.6 MB)
*/


/*
 * @lc app=leetcode.cn id=242 lang=cpp
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public:
    bool isAnagram(string s, string t)
    {
        sort(s.begin(), s.end());
        sort(t.begin(), t.end());
        if (s == t) {
            return true;
        }
        else {
            return false;
        }
    }
};
/*
Accepted
34/34 cases passed (24 ms)
Your runtime beats 41.98 % of cpp submissions
Your memory usage beats 8.52 % of cpp submissions (9.5 MB)
*/


/*
 * @lc app=leetcode.cn id=242 lang=cpp
 *
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
        int counts[26] = {0};
        for (int i = 0; i < n; i++) {
            counts[s[i] - 'a']++;
            counts[t[i] - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (counts[i]) {
                return false;
            }
        }
        return true;
    }
};
/*
Accepted
34/34 cases passed (4 ms)
Your runtime beats 99.88 % of cpp submissions
Your memory usage beats 27.74 % of cpp submissions (9.3 MB)
*/