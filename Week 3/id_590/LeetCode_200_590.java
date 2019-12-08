package homework.week3;

//https://leetcode-cn.com/problems/number-of-islands/
public class LeetCode_200_590 {
    public int result = 0;

    public int numIslands(char[][] grid) {
        _traverse(grid);
        return result;
    }

    private void _traverse(char[][] grid) {
        //进行遍历数组操作
        for (int x = 0; x < grid.length; ++x) {
            for (int y = 0; y < grid[0].length; ++y) {
                if (grid[x][y] == '1') {
                    result++;
                    _bombing(grid, x, y);
                }
            }
        }

    }


    private void _bombing(char[][] grid, int x, int y) {
        //如果越过边界就返回
        if (x >= grid.length - 1 || x < 0 || y >= grid[0].length - 1 || y < 0) {
            return;
        }
        //如果当前位置为水(0),则没有必要进行任何操作,返回
        if (grid[x][y] == '0') {
            return;
        }

        //当前为陆地,将陆地炸掉
        grid[x][y] = '0';
        //炸掉当前位置之上的位置
        _bombing(grid, x - 1, y);
        //炸掉当前位置左边位置
        _bombing(grid, x, y - 1);
        //炸掉当前位置右边位置
        _bombing(grid, x, y + 1);
        //炸掉当前位置之下的位置
        _bombing(grid, x + 1, y);
    }
}
