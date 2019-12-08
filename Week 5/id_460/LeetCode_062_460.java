package week5.Question62UniquePaths;

import java.util.HashMap;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 */
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePathsDPIII(3, 7));
    }
    //递归

    /**
     * 求 ( 0 , 0 ) 点到（ m - 1 , n - 1） 点的走法。
     * （0，0）点到（m - 1 , n - 1） 点的走法等于（0，0）点右边的点 （1，0）到（m - 1 , n - 1）的走法加上（0，0）点下边的点（0，1）到（m - 1 , n - 1）的走法。
     * 而右边的点（1，0）点到（m - 1 , n - 1） 点的走法等于（2，0） 点到（m - 1 , n - 1）的走法加上（1，1）点到（m - 1 , n - 1）的走法。
     * 下边的点（0，1）点到（m - 1 , n - 1） 点的走法等于（1，1）点到（m - 1 , n - 1）的走法加上（0，2）点到（m - 1 , n - 1）的走法。
     * 然后一直递归下去，直到 （m - 1 , n - 1） 点到（m - 1 , n - 1） ，返回 1
     */
    public static int uniquePaths(int m, int n) {
        HashMap<String, Integer> visited = new HashMap<>();
//        return getPaths(0,0,m-1,n-1,0);
        return getMethods(0, 0, m - 1, n - 1, 0, visited);
    }

    //用HashMap保存已经计算过的走法
    private static int getMethods(int x, int y, int m, int n, int num, HashMap<String, Integer> visited) {
        if (x == m && y == n) {
            return 1;
        }
        int n1 = 0;
        int n2 = 0;
        String key = (x + 1) + "@" + y;
        if (!visited.containsKey(key)) {
            if (x + 1 <= m) {
                n1 = getMethods(x + 1, y, m, n, num, visited);
            }
        } else {
            n1 = visited.get(key);
        }
        key = x + "@" + (y + 1);
        if (!visited.containsKey(key)) {
            if (y + 1 <= n) {
                n2 = getMethods(x, y + 1, m, n, num, visited);
            }
        } else {
            n2 = visited.get(key);
        }
        key = x + "@" + y;
        visited.put(key, n1 + n2);
        return n1 + n2;
    }

    private static int getPaths(int x, int y, int m, int n, int num) {
        if (x == m && y == n) {
            return 1;
        }
        int n1 = 0;
        int n2 = 0;
        if (x + 1 <= m) {
            n1 = getPaths(x + 1, y, m, n, num);
        }
        if (y + 1 <= n) {
            n2 = getPaths(x, y + 1, m, n, num);
        }
        return n1 + n2;
    }


    //分治的子问题：只需要初始化最后一列为 1 ，然后 1 列，1 列的向前更新就可以了。有一些动态规划的思想了。
    //DP方程：dp[i][j]= dp[i+1][j]+dp[i][j+1]

    public static int uniquePathsDP(int m, int n) {
        int[] dp = new int[m];
        for (int i = 0; i < m; i++) {
            dp[i] = 1;
        }
        //从右向左更新所有列
        for (int i = n - 2; i >= 0; i--) {
            //从下向上更新所有行
            for (int j = m - 2; j >= 0; j--) {
                dp[j] = dp[j] + dp[j + 1];

            }
        }
        return dp[0];
    }

    //分治的子问题：只需要初始化第一行为 1 ，然后 1行1行向下更新。
    //DP方程：dp[i][j]= dp[i-1][j]+dp[i][j-1]
    public static int uniquePathsDPII(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        //从左到右更新所有行
        for (int i = 1; i < m; i++) {
            //从上到下更新每一列
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    //      组合数公式
//        假设一开始我们是一直向下走的，总共需要（m - 1） + （n - 1）步。
//        由于需要达到指定终点，中途我们需要向右拐（n - 1）步，右拐的步数随机选择。
//        即在（m + n -2）中选取（n - 1）步，一共有多少种组合。
//        答案即为C（（m + n - 2）， （n - 1））。
    public static int uniquePathsDPIII(int m, int n) {
       int N = n+m-2;
       int K = n-1;
       long res = 1;
        for (int i = 1; i <=K; i++) {
            res = res * (N-K+i)/i;
        }
        return (int)res;
    }
}
