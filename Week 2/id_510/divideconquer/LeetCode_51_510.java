

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
*n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_51_510 {

    public static void main(String[] args) {
       
        System.out.println(new LeetCode_51_510().solveNQueens(12).size());
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        
        // 定义空间结构
        char[][] c = new char[n][n];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                c[i][j] = '.';
            }
        }
        dfs(c,0,list);
        return list;
    }

    /**
     * 深度遍历
     * @param c
     * @param clo
     * @param list
     */
    private void dfs(char[][] c, int clo,List<List<String>> list){
        // 结束
        if (clo == c.length) {
            List<String> l = new LinkedList<>();
            for (int i = 0; i < c.length; i++) {
                l.add(new String(c[i]));
            }
            list.add(l);
            return;
        }

        for (int i = 0; i < c.length; i++) {
            if(check(c, i, clo)){
                c[i][clo] = 'Q';
                dfs(c,clo+1,list);
                // 回溯
                c[i][clo] = '.';
            }
        }

    }

    private boolean check(char[][] c, int x, int y){
        for (int i = 0; i < c.length; i++) {
            // 遍历到y的上一列结束 
            for (int j = 0; j < y; j++) {
                /**
                 * 横向 坐标轴 x == i 
                 * 对角线 函数y = x+常量 或 y =x-常量
                 *      x+y = i+j   x-y = i - j
                 */
                if(c[i][j] == 'Q' && (x == i ||( x -y == i - j )|| (x + y) ==  (i + j))){
                    return false;
                }
            }
        }
        return true;
    }
}
