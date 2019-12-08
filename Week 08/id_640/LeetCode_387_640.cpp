/*
 * @lc app=leetcode.cn id=387 lang=cpp
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
class Solution {
    public:
    int firstUniqChar(string s)
    {
        unordered_map<char, int> m;
        for (auto& c : s) {
            m[c]++;
        }
        for (int i = 0; i < s.size(); i++) {
            if (m[s[i]] == 1) {
                return i;
            }
        }
        return -1;
    }
};
/*
Accepted
104/104 cases passed (76 ms)
Your runtime beats 36.71 % of cpp submissions
Your memory usage beats 79.96 % of cpp submissions (13 MB)
*/

/*
 * @lc app=leetcode.cn id=387 lang=cpp
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
class Solution {
    public:
    int firstUniqChar(string s)
    {
        unordered_map<char, pair<int, int>> m;
        int idx = s.size();
        for (int i = 0; i < s.size(); i++) {
            m[s[i]].first++;
            m[s[i]].second = i;
        }
        for (auto& p : m) {
            if (p.second.first == 1) {
                idx = min(idx, p.second.second);
            }
        }
        return idx == s.size() ? -1 : idx;
    }
};
/*
Accepted
104/104 cases passed (80 ms)
Your runtime beats 33.63 % of cpp submissions
Your memory usage beats 82.77 % of cpp submissions (12.9 MB)
*/