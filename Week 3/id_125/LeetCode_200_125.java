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
        System.out.println("岛屿数量：" + a200.numIslands(grid));
        System.out.println("-------------------------");
        Arrays.stream(grid).flatMap(Stream::of).map(Arrays::toString).forEach(System.out::println);
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
