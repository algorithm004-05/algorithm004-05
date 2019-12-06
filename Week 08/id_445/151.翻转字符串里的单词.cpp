/*
 * @lc app=leetcode.cn id=151 lang=cpp
 *
 * [151] 翻转字符串里的单词
 */
#include <string>
#include <vector>
using namespace std;
// @lc code=start
class Solution
{
private:
    vector<vector<int>> strPosi;
    int newLen = 0;

public:
    void mySplit(string s, int start, int len)
    {
        int end = 0, cstri = 0;
        bool isStart = false;

        for (int i = start; i < len; i++)
        {

            if (s[i] != 32 && !isStart)
            {
                start = i;
                strPosi.push_back(vector<int>(2));
                strPosi[cstri][0] = start;
                // start=end+1;
                isStart = true;
                // isEnd=false;
            }
            else if ((s[i] == 32 && isStart))
            {
                isStart = false;
                // isEnd=true;
                end = i;
                strPosi[cstri][1] = end;
                newLen = newLen + end - start;
                cstri++;
            }
        }

        end = len ;
        strPosi[cstri][1] = end;
        newLen = newLen + end - start;
        newLen = newLen + strPosi.size() - 1;
    }

    ///' '-32
    string reverseWords(string s)
    {
        if (s.length() < 1)
            return s;

        int start = 0, end = 0;
        int len = s.length();
        while (s[start] == 32)
        {
            start++;
            if (start == len)
            {
                return "";
            }
        }

        while (s[len - 1] == 32)
            len--;

        mySplit(s, start, len);

        // if (newLen == -1)
        //     newLen = 0;
        string res(newLen, ' ');
        int resi = 0;
        for (int i = strPosi.size() - 1; i >= 0; i--)
        {
            for (int j = strPosi[i][0]; j < strPosi[i][1]; j++)
            {
                res[resi++] = s[j];
            }
            resi++;
        }

        return res;
    }
};
// @lc code=end
