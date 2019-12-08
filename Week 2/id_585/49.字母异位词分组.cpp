/*
 * @lc app=leetcode.cn id=49 lang=cpp
 *
 * [49] 字母异位词分组
 */

// @lc code=start
//
//map是建立在一个sorted string 与一个vector<string> 之间的
class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>>  mymap;
       // for ( int i = 0; i < strs.size() ; i ++){
        for ( auto i : strs) {
            string temp = i;
            sort(temp.begin(), temp.end());
            mymap[temp].push_back(i);
        }
        vector<vector<string>> res;
        for (auto  x : mymap){
            res.push_back(x.second);
        }
        return res;
        
    }
};
// @lc code=end

