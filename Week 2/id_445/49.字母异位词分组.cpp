/*
 * @lc app=leetcode.cn id=49 lang=cpp
 *
 * [49] 字母异位词分组
 */
#include <vector>
#include <algorithm>
#include <map>
using namespace std;
// @lc code=start
class Solution {
public:
// sulution 1
    // vector<vector<string>> groupAnagrams(vector<string>& strs) {
    //     map<string,vector<string>> m;
    //     vector<vector<string>> r;
        
    //     string temp=s;
    //     sort(temp.begin(),temp.end());
          
    //       m[temp].push_back(s);

    //     }
    //     for (auto mv:m)
    //     {
    //         r.push_back(mv.second);
    //     }
        

    //     return r;
    // }

    // solution 2
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> r;
        map<string,vector<string>> ma;
        for (auto s:strs)
        {
            string hash(26,'0');
            for(auto c : s){
                hash[c-97]=(hash[c-97]+1);
                }
            ma[hash].push_back(s);
        }
        for(auto &m : ma){
            r.push_back(m.second);
        }
        
        return r;
    }
};
// @lc code=end

