class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        vector<unordered_set<int>> row(9), col(9), block(9);
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board[0].size(); j++) {
                int cur = board[i][j];
                int index = (i / 3) * 3 + j / 3;
                if (cur == '.') {
                    continue;
                }
                if (row[i].count(cur) || col[j].count(cur) || block[index].count(cur)) {
                    return false;
                }
                row[i].insert(cur);
                col[j].insert(cur);
                block[index].insert(cur);
            }
        }
        return true;
    }
};
