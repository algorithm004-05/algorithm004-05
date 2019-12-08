/**
 * @Auther: 封玉书 FYS
 * @Date: 2019.11.16 22:24
 * @Description:
 */
public class A64 {
    public static void main(String[] args) {
        A64 a64 = new A64();

        int[][] grid = new int[][]{
                {1, 3, 4, 8},
                {3, 2, 2, 4},
                {5, 7, 1, 9},
                {2, 3, 2, 3}};

        System.out.println(a64.minPathSum(grid));
    }


    /**
     * 计算出每一个格子。左、上两个方位的格子到这里的数字总和。
     * 并且选择最小的，这样就可以保证，在最后一个格子，是最小的数值
     * 时间：O(nm)
     * 空间：O(1)
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                // 边界值判断，如果是第一行/第一列，那么，不需要-1，否则越界。则min判断，直接赋予最大值判断即可
                grid[i][j] += Math.min(i == 0 ? Integer.MAX_VALUE : grid[i - 1][j],
                        j == 0 ? Integer.MAX_VALUE : grid[i][j - 1]);
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }

}
