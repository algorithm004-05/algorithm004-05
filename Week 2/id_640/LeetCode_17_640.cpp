/*
 * @lc app=leetcode.cn id=17 lang=cpp
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
#include <functional>
class Solution {
public:
  vector<string> res; //存放最终结果
  vector<string> letterCombinations(string digits) {
    map<char, string> hash_map; //建立哈希表，方便之后查找
    hash_map['2'] = "abc";
    hash_map['3'] = "def";
    hash_map['4'] = "ghi";
    hash_map['5'] = "jkl";
    hash_map['6'] = "mno";
    hash_map['7'] = "pqrs";
    hash_map['8'] = "tuv";
    hash_map['9'] = "wxyz";
    if (digits.size() == 0) { //判断是否未输入数字
      return {};
    } else {
      search("", digits, 0, hash_map); //调用递归函数
      return res;
    }
  }
  void
  search(string s, string digits, int i,
         map<char, string>
             map) // s是每一次生成的字符串，digits是输入的数字，i是深度（level）
  {
    //终止条件
    if (i == digits.size()) {
      res.push_back(s);
      return;
    }

    string letters = map[digits[i]]; //把字符串从哈希表中取出来
    for (int j = 0; j < letters.size(); ++j) {
      search(s + letters[j], digits, i + 1, map); //本层所做的事以及进入下一层
    }
  }
};
/*
Accepted
25/25 cases passed (4 ms)
Your runtime beats 78.07 % of cpp submissions
Your memory usage beats 5.04 % of cpp submissions (10.2 MB)
*/