/*
 * @lc app=leetcode.cn id=242 lang=cpp
 *
 * [242] 有效的字母异位词
 */
#include <string>
#include <map>
#include <algorithm>
using namespace std;
// @lc code=start
class Solution {
public:
//solution 1 : there are 25 alpha total , mod 26 
    // bool isAnagram(string s, string t) {
    //     int c[26];
    //     int size=0;
    //     for (int i = 0; i < 26; i++)
    //     {
    //         c[i]=0;
    //     }
        
    //     while ( s[size] !='\0')
    //     {
    //         c[s[size]%26]++;
    //         size++;
    //     }
    //     size=0;
    //     while (t[size]!='\0')
    //     {
    //         ///
    //         if(c[t[size]%26]==0) return false;
    //         c[t[size]%26]--;
    //         size++;

    //     }

    //      for (int i = 0; i < 26; i++)
    //     {
    //         if(c[i]>0)return false;
    //     }

    //     return true;
        
        
        
    // }

    //solution2 'a'==97  ,each char minus 97  fastest
    //     bool isAnagram(string s, string t) {
    //     int c[26];
    //     int size=0;
    //     if(s.length()!=t.length()) return false;
    //     for (int i = 0; i < 26; i++)
    //     {
    //         c[i]=0;
    //     }
        
        
    //     while ( s[size] !='\0')
    //     {
    //         c[s[size]-97]++;
    //         // if(t[size]=='\0')return 
    //         c[t[size]-97]--;
    //         size++;
    //     }

    //      for (int i = 0; i < 26; i++)
    //     {
    //         if(c[i]!=0)return false;
    //     }

    //     return true;
        
        
        
    // }
    // //solution 3 use stl map very slow
    //         bool isAnagram(string s, string t) {
    //     map<char,int> c;
    //     int size=0;
    //     if(s.length()!=t.length()) return false;
    //     while ( s[size] !='\0')
    //     {
    //         c[s[size]]++;
    //         // if(t[size]=='\0')return 
    //         c[t[size]]--;
    //         size++;
    //     }

    //     map<char ,int>::iterator ite=c.begin();
    //     while (ite!=c.end())
    //     {
    //         if(ite->second!=0) return false;
    //         ite++;
    //     }
        

    //     return true;
        
    // }


    //    //solution 4 use stl map very slow
    //         bool isAnagram(string s, string t) {
    //     map<char,int> c;
    //     int size=0;
    //     if(s.length()!=t.length()) return false;
    //     while ( s[size] !='\0')
    //     {
    //         c[s[size]]++;
    //         // if(t[size]=='\0')return 
    //         c[t[size]]--;
    //         size++;
    //     }

    //  for(auto cc : c) if(cc.second!=0) return false;
        

    //     return true;
        
    // }

           //solution 5 sorting first  slowest
            bool isAnagram(string s, string t) {
        sort(t.begin(),t.end());
        sort(s.begin(),s.end());
        

        return s==t;
        
    }
};
// @lc code=end

