import java.util.LinkedList;
import java.util.Queue;

public class Island {

    static int[] dx = new int[]{-1, 1, 0, 0},
            dy = new int[]{0, 0, -1, 1},
            type = new int[2];

    /*
     *
     * 今天想按照自己的思路来实现编码，
     * 可是结果运行的总是不正确，或者总是差那么一点
     * 我就想，运行那些给出的代码能得到正确的结果，
     * 但是自己的得不到，那么是自己的代码写的有问题，
     * 于是自己抛弃了怕麻烦的想法
     * 一点点调试，更改测试的grid数组
     * 最后定位出两个错误
     * 1）get方法的：x与y的位置写反了，更正了
     * if (grid[y][x] == compare) {
     * 2）set.union里的参数
     * 传递的不对，正确的如下
     * set.union(grid[0].length * y + x, grid[0].length * i + j);
     * 之前是
     * set.union(grid.length * y + x, grid.length * i + j);
     *
     * 2，力扣的count老是19，怎么回事
     *
     * 3，用自己的方法，测试还是会出现错误，
     *
     * 4，得出结论，超过一定时间，需要放弃z自己的思路！！！！！
     * */
//==================================================================
//==================================================================
    /*
    *
    * 看题解，收获：
    * 1，
    * 1）并查集，在初始化时，需要做处理，并不是count等于二维数组的元素个数
    * 2）每次访问过的‘1’，赋值为‘0’
    * 思考：为何要赋值为‘0’
    * 解答：不赋值为0也能通过，赋值为0，
    * 可以在两个for循环里加判断grid[i][j]==‘1’过滤掉等于0的情况，减少判断次数，提高效率
    * 3）老师讲过二维数组的上下左右移动，用两个一维数组，加上一个for循环足够了，不用四个if
    * 4）自己的测试count总是19，这个可以使用他人的模板，
    * 5）为何自己的得不到正确结果，count数量初始化错误，加上没有过滤‘0’
    * */
//==================================================================
//==================================================================
    /*
    * DFS题解的思考：
    * 1）上下左右移动，用两个一维数组，加上一个for循环足够了，不用四个if
    * 这种方法自己知道呀，但是就是不知道如何使用DFS，为什么会这样？
    * 思考：
    * 首先，自己比之前有进步了，能够明白这里其实就是递归，也能够看懂了
    * 第二，自己做的题目少了，老师常说：“做题多了就会知道如何去做”
    *

    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }

        return num_islands;
    }
    作者：LeetCode
    链接：https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-shu-liang-by-leetcode/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    * */
//==================================================================
//==================================================================

    /*
    * BFS题解：
    * 1，看到这个题解似乎看不懂，但是想起之前也有题目是这样的解法，一个套路
    * 说明自己对BFS掌握不好，需要加强
    *
    * 2,自己花了点时间，
    * [0,1,2,3]
    * [4,5,6,7]
    * [8,9,10,11]
    * [12,13,14,15]
    * 1）就是对角线，先0，后4，1（改变dx，dy里的顺序，就是1，4）
    * 2）然后注意，下面是debug的输出，可以看到，queue先让1出列，
    * 无论是1或者6或者10，左边和上边都已经添加了，所有只添加下边和右边
    * 下边和右边是不是刚好处于广度线上（这里的1、4和2、5、8都处于同一条线上，
    * 即自己所谓的广度线）
    * ==============
    * [1, 4]
      id==1
      nc==4
      row=id / nc==0
      col=id % nc==1
    * ==============
    * 3）接下来你懂了，4出列，然后添加4的右边和下边，只有是1且未添加的才行
    * 其实未添加和是1，属于同一情况，因为访问过赋值为0.
    *
    *
    * 好了，3种解法分析完毕。


    static int[] dx = new int[]{-1, 1, 0, 0},
            dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '1'},
                {'0', '0', '0', '0', '1'},
                {'0', '0', '0', '0', '1'}
        };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    grid[r][c] = '0'; // mark as visited
                    Queue<Integer> queue = new LinkedList<>();

                    queue.add(r * nc + c);
                    System.out.println(queue);
                    while (!queue.isEmpty()) {
                        System.out.println(queue);
                        int id = queue.remove();
                        System.out.println(id);
                        int row = id / nc;
                        int col = id % nc;

                        for (int k = 0; k < 4; k++) {
                            int x = row + dx[k];
                            int y = col + dy[k];

                            if ((x >= 0 && x < nr) && (y >= 0 && y < nc) && grid[x][y] == '1') {
                                queue.add(x * nc + y);
                                grid[x][y] = '0';
                            }
                        }
//                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
//                            queue.add((row-1) * nc + col);
//                            grid[row-1][col] = '0';
//                        }
//                        if (row + 1 < nr && grid[row+1][col] == '1') {
//                            queue.add((row+1) * nc + col);
//                            grid[row+1][col] = '0';
//                        }
//                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
//                            queue.add(row * nc + col-1);
//                            grid[row][col-1] = '0';
//                        }
//                        if (col + 1 < nc && grid[row][col+1] == '1') {
//                            queue.add(row * nc + col+1);
//                            grid[row][col+1] = '0';
//                        }
                    }
                }
            }
        }

        return num_islands;
    }
    * */
//==================================================================
//==================================================================
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '1'},
                {'0', '0', '0', '0', '1'},
                {'0', '0', '0', '0', '1'}
        };
//        int[][] grid = new int[][]{
//                {1, 1, 1,1, 0},
//                {1, 1, 0,1, 1},
//                {1, 1, 0,0, 1},
//                {0, 0, 0,1, 1}
//        };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int row = grid.length, col = grid[0].length;
        DisjointSet set = new DisjointSet(grid);
//        set.setParent(grid);
        for (int i = 0; i < row; i++) {
//            System.out.println("=================");
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
//                    grid[i][j] = '0';
                    int old = i * col + j;
                    for (int k = 0; k < 4; k++) {
                        int y = i + dy[k];
                        int x = j + dx[k];
                        if ((x >= 0 && x < col) && (y >= 0 && y < row) && grid[y][x] == '1') {
                            set.union(grid[0].length * y + x, grid[0].length * i + j);
                        }
                    }
//                    if(i - 1 >= 0 && grid[i - 1][j] == '1'){
//                        set.union(old, (i - 1) * col + j);
//                    }
//                    if(i + 1 < row && grid[i + 1][j] == '1'){
//                        set.union(old, (i + 1) * col + j);
//                    }
//                    if(j - 1 >= 0 && grid[i][j - 1] == '1'){
//                        set.union(old, i * col + j - 1);
//                    }
//                    if(j + 1 < col && grid[i][j + 1] == '1'){
//                        set.union(old, i * col + j + 1);
//                    }
                }
            }
        }
//        int sub = (type[0] + type[1]) == 2 ? 1 : 0;
        return set.getCount();
    }

//    public static void get(int[][] grid, int i, int j, int m, int n, DisjointSet set) {
//        int compare = grid[i][j];
//
//        for (int k = 0; k < 4; k++) {
//            int y = i + dy[k];
//            int x = j + dx[k];
//            if ((x >= 0 && x < n) && (y >= 0 && y < m)) {
////                System.out.println("[" + y + "]" + "[" + x + "]");
////                System.out.println("[" + i + "]" + "[" + j + "]");
//                if (grid[y][x] == compare) {
//                    System.out.println((grid.length * y + x) + "===grid.length * y + x");
//                    System.out.println((grid.length * i + j) + "===grid.length * i + j");
//                    set.union(grid[0].length * y + x, grid[0].length * i + j);
//                    System.out.println(set);
//                }
//            }
//        }
//
//    }


}
