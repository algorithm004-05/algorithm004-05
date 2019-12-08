import java.util.*;
/**
 * Leetleetcode-cn.com/problems/valid-sudoku/
 */
public class LeetCode_36_100 {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] row = new HashSet[9];
        Set<Character>[] col = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                if (!row[i].contains(c)) {
                    row[i].add(c);
                } else {
                    return false;
                }

                if (!col[j].contains(c)) {
                    col[j].add(c);
                } else {
                    return false;
                }
                
                int boxIndex = (j/3) + (i/3)*3;
                if (!boxes[boxIndex].contains(c)) {
                    boxes[boxIndex].add(c);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}