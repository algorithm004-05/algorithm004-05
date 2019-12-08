import java.util.Arrays;
import java.util.stream.Stream;

public class A200 {
    public static void main(String[] args) {
        A200 a200 = new A200();
        String a = "11000";
        String b = "11000";
        String c = "00100";
        String d = "00011";

        char[][] grid = new char[][]{
                a.toCharArray(),
                b.toCharArray(),
                c.toCharArray(),
                d.toCharArray(),};

        Arrays.stream(grid).flatMap(Stream::of).map(Arrays::toString).forEach(System.out::println);
//        System.out.println("岛屿数量：" + a200.numIslands(grid));
        System.out.println("岛屿数量：" + a200.numIslands2(grid));
        System.out.println("-------------------------");
        Arrays.stream(grid).flatMap(Stream::of).map(Arrays::toString).forEach(System.out::println);
    }

    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    grid[r][c] = '0';
                    if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                        uf.union(r * nc + c, (r - 1) * nc + c);
                    }
                    if (r + 1 < nr && grid[r + 1][c] == '1') {
                        uf.union(r * nc + c, (r + 1) * nc + c);
                    }
                    if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                        uf.union(r * nc + c, r * nc + c - 1);
                    }
                    if (c + 1 < nc && grid[r][c + 1] == '1') {
                        uf.union(r * nc + c, r * nc + c + 1);
                    }
                }
            }
        }

        return uf.count;
    }


    static class UnionFind {
        int[] parent;
        int m, n;
        int count = 0;

        UnionFind(char[][] grid) {
            m = grid.length;
            n = grid[0].length;
            parent = new int[m * n];

            // 初始化，把有值的初始化为自己本身
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        int id = i * n + j;
                        parent[id] = id;
                        count++;
                    }
                }
            }
            System.out.println();
        }

        public void union(int node1, int node2) {
            int find1 = find(node1);
            int find2 = find(node2);
            if (find1 != find2) {
                parent[find1] = find2;
                count--;
            }
        }

        /**
         * 不断寻找顶层
         *
         * @param node
         * @return
         */
        public int find(int node) {
            if (parent[node] == node) {
                return node;
            }
            parent[node] = find(parent[node]);
            return parent[node];
        }
    }


    /**
     * 沉岛算法
     * 每发现一个数字为1的地方，那么把其周围连着的1都化为0，并且岛屿数量++
     * 深度优先 dfs
     * 时间复杂度：应该是：log(n)
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int count = 0;

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                if (grid[y][x] != '0') {
                    setZero(grid, x, y);
                    count++;
                }
            }
        }


        return count;
    }

    /**
     * 遍历某个点四周，将连着的所有1，都改为0
     *
     * @param grid 二维数组
     * @param x    x轴
     * @param y    y轴
     */
    private void setZero(char[][] grid, int x, int y) {
        int col = grid.length - 1;
        int row = grid[0].length - 1;

        // 越界，或者已经为0的就不在考虑了
        if (x > row || x < 0 || y > col || y < 0 || grid[y][x] == '0') {
            return;
        }

        grid[y][x] = '0';
//        System.out.println("-------------------------");
//        Arrays.stream(grid).flatMap(Stream::of).map(Arrays::toString).forEach(System.out::println);
        setZero(grid, x - 1, y);
        setZero(grid, x + 1, y);
        setZero(grid, x, y - 1);
        setZero(grid, x, y + 1);
    }
}
