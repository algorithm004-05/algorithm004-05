/*
 * @lc app=leetcode.cn id=455 lang=cpp
 *
 * [455] 分发饼干
 */
#include <vector>
#include <algorithm>
using namespace std;
// @lc code=start
class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        if(g.size()==0 || s.size()==0) return 0;
        sort(g.begin(),g.end());
        sort(s.begin(),s.end());
        int i = 0,j=0;
        for ( ; i < g.size()&&j<s.size(); )
        {
            if(g[i]<=s[j]) i++;
            j++;
        }
        return i;
        

    }
};
// @lc code=end

