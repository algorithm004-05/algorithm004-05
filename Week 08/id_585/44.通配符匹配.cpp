/*
 * @lc app=leetcode.cn id=44 lang=cpp
 *
 * [44] 通配符匹配
 */

// @lc code=start
class Solution {
public:
    bool isMatch(string s, string p) {
        int s_size = s.size();
        int p_size = p.size();
        vector<vector<bool>> help(s_size+1,vector<bool>(p_size+1,false));
        
        help[0][0] = true;
        for(int j=1;j<p_size+1;j++){
            if(p[j-1] == '*')
                help[0][j] = help[0][j-1];
        }
        
        for(int i=1;i<s_size+1;i++){
            for(int j=1;j<p_size+1;j++){
                if(p[j-1] == '?' || p[j-1] == s[i-1])
                    help[i][j] = help[i-1][j-1];
                else if(p[j-1] == '*')
                    help[i][j] = help[i-1][j] || help[i][j-1];
            }
        }
        return help[s_size][p_size];
    }
};
// @lc code=end

