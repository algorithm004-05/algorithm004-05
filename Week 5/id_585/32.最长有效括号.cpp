/*
 * @lc app=leetcode.cn id=32 lang=cpp
 *
 * [32] 最长有效括号
 */

// @lc code=start

class Solution
{
public:
    int longestValidParentheses(string s)
    {
        int max = 0;
        vector<int> nvc(s.size(), 0);
        int nlp = 0;
        if (s[0] == '(')  nlp = 1;
        for (int i = 1; i < s.size(); i++)
        {
            if (s[i] == '(')
            {
                nlp++;
                nvc[i] =0 ;
            }
            else 
            {
                if (nlp > 0 )
                {
                    nlp--;
                    nvc[i] = nvc[i - 1] + 2;
                    if(i-nvc[i] >= 0 && nvc[i-nvc[i]] != 0 )
                    nvc[i] = nvc[i] + nvc[i-nvc[i]] ;
                    if (nvc[i] > max)
                        max = nvc[i];
                }
                else
                {
                    nvc[i] = 0;
                }
            }
        }
        return max;
    }
};
// @lc code=end
