import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Auther: 封玉书 FYS
 * @Date: 2019.11.24 19:09
 * @Description:
 */
public class A37 {

    private List<Set<Character>> row = new ArrayList<>();
    private List<Set<Character>> col = new ArrayList<>();
    private List<Set<Character>> sqr = new ArrayList<>();
    private Set<Integer> set = new HashSet<>();

    public void solveSudoku(char[][] board) {


        for (int i = 0; i < 9; i++) {
            row.add(new HashSet<>());
            col.add(new HashSet<>());
            sqr.add(new HashSet<>());
        }

        // 把里面存在的数字放入
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                int index = (i / 3) * 3 + j / 3;
                if (c != '.') {
                    row.get(i).add(c);
                    col.get(j).add(c);
                    sqr.get(index).add(c);
                    set.add(i * 9 + j);
                }
            }
        }

        traceBack(board, 0);

    }

    private boolean traceBack(char[][] board, int index) {
        if (index >= 81)
            return true;

        int i = index / 9;
        int j = index % 9;

        // 如果存在元素 则下一个
        if (set.contains(index)) {
            return traceBack(board, index + 1);
        }


        int cellNum = (i / 3) * 3 + j / 3;
        for (char c = '1'; c <= '9'; c++) {
            // 数据校验
            if (validChar(c, i, j)) {
                //维护数据结构
                row.get(i).add(c);
                col.get(j).add(c);
                sqr.get(cellNum).add(c);

                board[i][j] = c;
                // 失败 回退
                if (!traceBack(board, index + 1)) {
                    row.get(i).remove(c);
                    col.get(j).remove(c);
                    sqr.get(cellNum).remove(c);
                    board[i][j] = '.';
                } else {
                    // 成功 返回
                    return true;
                }
            }
        }
        return false;
    }

    // 校验合法性
    private boolean validChar(char c, int i, int j) {
        int index = (i / 3) * 3 + j / 3;
        if (row.get(i).contains(c) || col.get(j).contains(c) || sqr.get(index).contains(c))
            return false;
        return true;
    }

}
