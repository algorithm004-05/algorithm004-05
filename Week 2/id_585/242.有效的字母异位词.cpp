/*
 * @lc app=leetcode.cn id=242 lang=cpp
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
/*    
//sort
class Solution {
public:
    bool isAnagram(string s, string t) { 
        sort(s.begin(), s.end());
        sort(t.begin(), t.end());
        return s == t; 
    }
};
// map
class Solution {
public:
    bool isAnagram(string s, string t)
        unordered_map<char, int> mymap;
        if (s.size() != t.size())
            return false;
   //     for (int i = 0; i < s.size(); i++)
   //     {
   //         if (mymap.count(s[i]))
   //             mymap[s[i]]++;
   //         else
   //             mymap[s[i]] = 1;
   //     }
   //     for (int i = 0; i < t.size(); i++)
   //     {
   //         if (mymap.count(t[i]) && mymap[t[i]] > 0)
   //             mymap[t[i]]--;
   //         else
   //             return false;
   //     }
   //map初始化value默认为0或空，且新插入key值不存在自动新建 无需count判断，效率由33%到66%
        for (int i = 0; i < s.size(); i++)
        {
                mymap[s[i]]++;
                mymap[t[i]]--;
        }
        for (auto &x : mymap)
        {
            if (x.second != 0)
                return false;
        }
        return true;
    }
};
*/
//use array to simulate the map and speed up the code.
class Solution {
public:
    bool isAnagram(string s, string t){
        if (s.size() != t.size())
            return false;
        int alpha[26] = {0};
        for (int i = 0; i < s.size(); i++)
        {
            alpha[s[i] - 'a']++;
            alpha[t[i] - 'a']--;
        }
        for (int i = 0; i < s.size(); i++)
        {
            if (alpha[i] != 0)
                return false;
        }
        return true;
    }
};

        // @lc code=end
