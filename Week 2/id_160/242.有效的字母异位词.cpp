/*
 * @lc app=leetcode.cn id=242 lang=cpp
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
public:
    bool isAnagram(string s, string t) {
          int *data = new int[26]();
          int n = s.length();
          int m = t.length();
          int temp;
          if(n!=m) return false;
          for(int i = 0;i<m;i++)
          {
              temp = s.at(i);
              data[temp-'a']++;
          }

          for(int i = 0;i<n;i++){
              temp = t.at(i);
              data[temp-'a']--;
              if(data[temp-'a']<0) return false;
          }
        return true;
    }
};

// class Solution {
// public:
//     bool isAnagram(string s, string t) {
//         if (s.length() != t.length()) return false;
//         int n = s.length();
//         int counts[26] = {0};
//         for (int i = 0; i < n; i++) { 
//             counts[s[i] - 'a']++;
//             counts[t[i] - 'a']--;
//         }
//         for (int i = 0; i < 26; i++)
//             if (counts[i]) return false;
//         return true;
//     }
// };

// sort 
// class Solution {
// public:
//     bool isAnagram(string s, string t) { 
//         sort(s.begin(), s.end());
//         sort(t.begin(), t.end());
//         return s == t; 
//     }
// };

// class Solution {
// public:
//     bool isAnagram(string s, string t) {
//         if (s.length() != t.length()) return false;
//         int n = s.length();
//         unordered_map<char, int> counts;
//         for (int i = 0; i < n; i++) {
//             counts[s[i]]++;
//             counts[t[i]]--;
//         }
//         for (auto count : counts)
//             if (count.second) return false;
//         return true;
//     }
// };
// @lc code=end

