// Author: liuwufang
// Date: 2019/10/20

#include <vector>
#include <string>

using namespace std;

// https://leetcode-cn.com/problems/majority-element/
// https://leetcode.com/problems/majority-element/

// Question:
// 169. 求众数
// 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
// 你可以假设数组是非空的，并且给定的数组总是存在众数。

// Solution:
// 思路1:hash表记录法
// 1.create a hash table
// 2.for 0->nums.size() 
// 2.1 count the num

// 时间复杂度：O(N^N)
// 空间复杂度：O(1)

bool isVaild(vector<string> &nQueens, int row, int col, int &n) {
    // 所在行或者列只有一个Q
    for (int i = 0; i != row; ++i)
        if (nQueens[i][col] == 'Q')
            return false;
    // 左斜线
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; --i, --j)
        if (nQueens[i][j] == 'Q')
            return false;
    // 右斜线
    for (int i = row - 1, j = col + 1; i >= 0 && j < n; --i, ++j)
        if (nQueens[i][j] == 'Q')
            return false;
    return true;
}

void helper(vector<vector<string>>& ans, vector<string>& nQueens,int row, int n) {
    // 1.terminator
    if (row == n) ans.push_back(nQueens);
    // 2.prepare data

    // 3.conquer subproblem

    // 4.process and generate ret
    for (int i = 0; i < n; i++) {
        if(isVaild(nQueens, row, i, n)) {
            nQueens[row][i] = 'Q'; // set 'Q'
            helper(ans, nQueens, row + 1, n);
            nQueens[row][i] = '.'; // reset '.'
        }
    }

    // 5.revert this leval
}

vector<vector<string>> solveNQueens(int n) {
    vector<vector<string> > ans;
    vector<string> nQueens(n, string(n, '.'));

    int count = 0;
    // helper(ans, level, n);
    helper(ans, nQueens, 0, n);

    return ans;
}

void leetcode_test_51(void) {
    int n = 4;
    solveNQueens(n);
}