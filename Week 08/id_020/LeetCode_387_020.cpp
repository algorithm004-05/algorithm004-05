// Author: liuwufang
// Date: 2019/12/08

#include <map>
#include <string>
#include <algorithm>
using namespace std;

// https://leetcode-cn.com/problems/first-unique-character-in-a-string/
// https://leetcode.com/problems/first-unique-character-in-a-string/

// Question:
// 387. 字符串中的第一个唯一字符
// 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

// 案例:
// s = "leetcode"
// 返回 0.
// s = "loveleetcode",
// 返回 2.
//  


// Solution:
// 1.遍历一次记录字符个数
// 2.按顺序遍历第二次，返回第一个计数为1的下标

// 时间复杂度:O(N)
// 空间复杂度:O(N)
int firstUniqChar(string s) {
    map<char, int> m;
    for (auto ch : s) {
        if (m.count(ch) == 0) m.insert(pair<char, int> (ch, 1));
        else m[ch]++;
    }
    
    for (int i = 0; i < s.length(); ++i) {
        if (m[s[i]] == 1) return i;
    }

    return -1;
}

void leetcode_test_387(void) {
    string str = "leetcode";
    firstUniqChar(str); // 0
}
