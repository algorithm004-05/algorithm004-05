/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 *
 * https://leetcode.com/problems/perfect-squares/description/
 *
 * algorithms
 * Medium (43.26%)
 * Likes:    1849
 * Dislikes: 156
 * Total Accepted:    221.7K
 * Total Submissions: 510.2K
 * Testcase Example:  '12'
 *
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * Example 1:
 * 
 * 
 * Input: n = 12
 * Output: 3 
 * Explanation: 12 = 4 + 4 + 4.
 * 
 * Example 2:
 * 
 * 
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
       if(n == 0) return -1;
       if(n == 1) return 1;
       int x = (int)Math.sqrt(n);
       int list[] = new int[x];
       for(int i = 0; i < x; i++) {
           list[i] = (i+1) * (i+1);
       }

       return BFS(n,list);
    }

    private int BFS(int n, int[] list) {

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(n);
        int level = 0;
        while (!q.isEmpty()) {
            level++;
            int l = q.size();

            for (int j = 0; j < l; j++) {
                int temp = q.poll();
                for(int i = 0; i < list.length; i++ ){
                    int ca = temp - list[i];
                    if(ca == 0) return level;
                    if(ca > 0) q.offer(ca);
                }

            }
        }
        return level;


    }
}

// @lc code=end

