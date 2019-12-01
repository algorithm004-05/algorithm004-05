import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by panda on 2019/11/24.
 */
public class LeetCode_51_430 {
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            boolean[] lie = new boolean[n];
            boolean[] pie = new boolean[n * 2];
            boolean[] na = new boolean[n * 2];
            List<List<String>> res = new ArrayList();
            // 从第一行开始放
            solve(lie, pie, na, 0, n, new ArrayList(), res);
            return res;
        }

        private void solve(boolean[] lie, boolean[] pie, boolean[] na, int i, int n, List<String> queens, List<List<String>> res) {
            // 皇后已找全
            if (queens.size() == n) {
                res.add(queens);
                return;
            }
            // 尝试在本行找到皇后
            for (int j = 0; j < n; j++) {
                // 有位置被占
                // +n防止复数
                if (lie[j] || pie[j + i] || na[i - j + n]) {
                    continue;
                }
                lie[j] = true;
                pie[i + j] = true;
                na[i - j + n] = true;
                List<String> list = new ArrayList(queens);
                list.add(newQueen(j, n));
                // 找下一行皇后
                solve(lie, pie, na, i + 1, n, list, res);
                // 尝试完成，恢复现场，尝试另一皇后位置
                lie[j] = false;
                pie[i + j] = false;
                na[i - j + n] = false;
            }
        }

        private String newQueen(int j, int n) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[j] = 'Q';
            return new String(row);
        }
    }
}
