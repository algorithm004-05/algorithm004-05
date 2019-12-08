package geektime.dfs;

public class IslandNum {
    //小tip：用两个数组建模方向，同时可以结合一个变量，建模向量。
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public int numIslands(char[][] grid) {
        int isIlandsNum = 0;
        if (grid == null || grid.length == 0) return 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                //发现陆地，即将连接的陆地全部沉掉，该处即用到了搜索
                if (grid[i][j] == '1') {
                    isIlandsNum += helper(i, j, grid);
                }
            }
        }
        return isIlandsNum;
    }
//重复的步骤是：
// 1、找到陆地，然后以所在陆地为中心，上下左右四个方向做沉岛操作；
// 2、下转的时点是在上下左右移动中遇到陆地时
//感悟：递归的关键之一：找到重复的步骤，同时确定好下转的节点（即重复步骤中，哪一步是下转的时机）
//下转时，需要考虑带什么参数（之前的总结：主要是三类参数：层级参数、返回上一层梦境需要借助的参数、梦境主角参数）
    public int helper(int row, int column, char[][] grid) {
        if (grid[row][column] == '0') return 0;
        grid[row][column] = '0';
        for (int i = 0; i < dx.length; i++) {
            int x = row + dx[i];
            int y = column + dy[i];
            if (x >= 0 && y >= 0 && x < grid.length && y < grid[x].length) {
                if (grid[x][y] == '0') continue;
                helper(x, y, grid);
            }
        }
        return 1;
        }
}
