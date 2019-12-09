/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 朋友圈
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] M) {
        int count=0;
        int n=M.length;
        int m=M[0].length;
        //朋友队列
        Queue<Integer> queue=new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (M[i][j]==1)
                {
                    queue.add(i);
                    while (queue.size()>0)
                    {
                        Integer index=((LinkedList<Integer>) queue).pop();
                        M[index][index]=0;
                            for (int k = 0; k < m; k++) {
                                if (M[index][k]==1)
                                {
                                    queue.add(k);
                                    M[index][k]=0;
                                    M[k][index]=0;
                                }
                            }
                    }
                    count++;
                }
            }
        }
        return count;
    }
}
// @lc code=end

