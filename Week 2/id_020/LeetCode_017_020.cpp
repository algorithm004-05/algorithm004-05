// Author: liuwufang
// Date: 2019/10/20

#include <algorithm>
#include <string>
#include <vector>
#include <map>
using namespace std;

// https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

// Question:
// 17. 电话号码的字母组合
// 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
// example:
// 输入："23"
// 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]

// Solution:
// 思路1:n叉数的DFS
// 其实这个题目本质是n叉数的DFS，用回溯（递归，个人觉得只是递归而已）

// 时间复杂度：O(3^N * 4^M)
// 空间复杂度：O(3^N * 4^M)

map<char, string> phoneMp = { {'2',"abc" },{'3',"def"},{'4',"ghi"},{'5',"jkl"},{'6',"mno"},{'7',"pqrs"},{'8',"tuv"},{'9',"wxyz"} };
vector<string> ansVec;

void helper(int leval, string subDigits, string digits) {
    // 分治法 若干个数字对应的元素组合问题，
    // 1.terminator 
    if (leval == digits.length()) {
        ansVec.push_back(subDigits);
        return; // 尤其重要！！！
    }

    // 2.prepare data
    string curApp = phoneMp[digits[leval]];
    // 3.conquer subproblems

    // 4.process and generate the final
    for (int i = 0; i < curApp.length(); ++i) {
        helper(leval + 1, subDigits+curApp[i], digits); // append
    }
    // 5.revert the var
}

vector<string> letterCombinations(string digits) {
    if (digits.length() == 0) return {};
    string subDigits = "";
    //helper(leval, digits);
    helper(0, subDigits, digits);
    return ansVec;
}

// Solution2: 多重循环 理解上不如dfs清晰
vector<string> letterCombinations2(string digits) {
    if (digits.empty()) return vector<string>();
    vector<string> ans;
    string v[10] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}; 
    ans.push_back("");  
    for (int i = 0; i < digits.size(); i++) {
        vector<string> tmp;
        string appStr = v[digits[i] - '0'];
        for (int j = 0; j < appStr.size(); j++) {
            for (int k = 0; k < ans.size(); k++) {
                tmp.push_back(ans[k] + appStr[j]);
            }
        }
        
        ans = tmp;
    }
    return ans;
}

void leetcode_test_15(void) {
    letterCombinations("23"); //["ad","ae","af","bd","be","bf","cd","ce","cf"]
    letterCombinations2("23"); // ["ad","ae","af","bd","be","bf","cd","ce","cf"]
}