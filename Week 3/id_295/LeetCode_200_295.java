//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
//
//示例 1:
//
//输入:
//11110
//11010
//11000
//00000
//
//输出: 1
//示例 2:
//
//输入:
//11000
//11000
//00100
//00011
//
//输出: 3
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/number-of-islands
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class LeetCode_200_295 {

    char[][] g;

    public int numIslands(char[][] grid) {
        int islands = 0;
        g = grid;
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                if (g[i][j] == '0') continue;
                islands += sink(i, j);
            }
        }
        return islands;
    }

    int sink(int i, int j) {
        // 如果超出边界或者为水则返回0
        if (i < 0 || i == g.length || j < 0 || j == g[i].length || g[i][j] == '0')
            return 0;
        g[i][j] = '0';

        // 继续下探，看左右上下是否为岛
        sink(i + 1, j);
        sink(i - 1, j);
        sink(i, j + 1);
        sink(i, j - 1);

        return 1;
    }
}
