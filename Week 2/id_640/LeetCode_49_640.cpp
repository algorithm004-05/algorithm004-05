/*
 * @lc app=leetcode.cn id=49 lang=cpp
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public:
    vector<vector<string>> groupAnagrams(vector<string>& strs)
    {
        unordered_map<string, vector<string>> hash_map; //建立一个hash_map,key为排序完成的string,value为未排序的string
        for (auto s : strs) { //遍历strs
            string temp = s;
            sort(s.begin(), s.end());
            hash_map[s].push_back(temp);    //s是key，temp是value
        }
        vector<vector<string>> ans; //存储最后的结果
        for (auto i : hash_map) {   //遍历整个hash_map
            ans.push_back(i.second);    //把hash_map中的value(second所指)压入ans中
        }
        return ans;
    }
};
/*
Accepted
101/101 cases passed (84 ms)
Your runtime beats 46.97 % of cpp submissions
Your memory usage beats 40.05 % of cpp submissions (20 MB)
*/