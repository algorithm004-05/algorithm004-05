/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N皇后 II
 */

// @lc code=start
class Solution {
    int size;
    int count;

    public void solve(int row, int pie, int na) {
        //terminator
        if(row == size) {
            count++;
            return ;
        }
        //当前得到的所有空位
        int pos = size & (~(row | pie | na));
        while(pos != 0) {
            // p 为当前pos最低位的1
            int p = pos & (-pos);
            //更新pos，把pos最低位的1置零，代表在这上面放了皇后
            pos &= pos - 1;
            // drill down
            solve(row | p, (pie | p) << 1, (na | p) >> 1 );
        }

    }
    public int totalNQueens(int n) {
        count = 0;
        // size表示n位前面都置零的一个算子，但是这里也用于了终止循环，很巧妙
        size = ( 1 << n) - 1;
        solve(0, 0, 0);
        return count;
    }
}
// @lc code=end

