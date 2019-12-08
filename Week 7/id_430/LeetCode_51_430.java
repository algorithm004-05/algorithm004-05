import java.util.ArrayList;
import java.util.List;

/**
 * Created by panda on 2019/12/1.
 */
public class LeetCode_51_430 {
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> res = new ArrayList(n);
            solve(res, new ArrayList(), n, 0, 0, 0);
            return res;
        }

        private void solve(List<List<String>> res, List<String> list, int n, int pie, int na, int col) {
            if (list.size() == n) {
                res.add(list);
                return;
            }
            // 可用的列
            int cols = (~(pie | na | col)) & ((1 << n) - 1);
            while (cols != 0) {
                // 当前使用列
                int c = cols & (-cols);
                // 移除可用列
                cols = cols & (cols - 1);
                // list必须使用新的List
                List<String> temp = new ArrayList(list);
                temp.add(generateRow(c, n));
                solve(res, temp, n, (pie | c) << 1, (na | c) >> 1, col | c);
            }

        }

        private String generateRow(int c, int n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                int b = c & (1 << (n - 1 - i));
                sb.append(b == 0 ? '.' : 'Q');
            }
            return sb.toString();
        }
    }
}
