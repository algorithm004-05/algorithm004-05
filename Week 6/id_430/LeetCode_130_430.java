/**
 * Created by panda on 2019/11/24.
 */
public class LeetCode_130_430 {
    class Solution {

        class UnionSet {
            int[] parents;
            int count;

            public UnionSet(int n) {
                parents = new int[n];
                for (int i = 0; i < n; i++) {
                    parents[i] = i;
                }
                count = n;
            }

            public void deCount() {
                count--;
            }

            public int find(int x) {
                int p = x;
                while (parents[p] != p) {
                    p = parents[p];
                }
                // 路径压缩
                while (parents[x] != p) {
                    int temp = parents[x];
                    parents[x] = p;
                    x = temp;
                }
                return p;
            }

            boolean connected(int x, int y) {
                return find(x) == find(y);
            }

            public void union(int x, int y) {
                int p1 = find(x);
                int p2 = find(y);
                if (p1 != p2) {
                    count--;
                    parents[p1] = p2;
                }
            }
        }

        public void solve(char[][] board) {
            if (board.length == 0 || board[0].length == 0) {
                return;
            }
            int m = board.length;
            int n = board[0].length;
            // 多余一个节点作为标记
            UnionSet union = new UnionSet(m * n + 1);
            // 左右上下
            int[] dx = new int[]{-1, 1, 0, 0};
            int[] dy = new int[]{0, 0, -1, 1};
            int dummy = m * n;
            // 左右两边
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'O') {
                        // 边缘节点优先合并dummy
                        if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                            union.union(i * n + j, dummy);
                        } else {
                            // 合并临近节点
                            for (int k = 0; k < 4; k++) {
                                int x = i + dx[k];
                                int y = j + dy[k];
                                if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O') {
                                    union.union(i * n + j, x * n + y);
                                }
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 二者父子关系不一定，但find一定相等
                    // 以dummy为父节点的一定不是被包围的
                    if (union.find(dummy) != union.find(i * n + j)) {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }
}
