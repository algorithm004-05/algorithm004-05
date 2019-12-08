/*
  70
  You are climbing a stair case. It takes n steps to reach to the top.

  Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

  Note: Given n will be a positive integer.

  Example 1:
    Input: 2
    Output: 2

  Explanation:
    There are two ways to climb to the top.
      1.  1 step + 1 step
      2.  2 steps

  Example 2:
    Input: 3
    Output: 3

  Explanation:
    There are three ways to climb to the top.
      1.  1 step + 1 step + 1 step
      2.  1 step + 2 steps
      3.  2 steps + 1 step
*/

public class ClimbingStairs {

  public int climbStairs0(int n) {
    return climbStairs0Helper(n);
  }

  private int climbStairs0Helper(int n) {
    if(n<=0) return 0;
    if (n <= 2) {
      return n;
    }
    return climbStairs0Helper(n - 1) + climbStairs0Helper(n - 2);
  }

  public int climbStairs1(int n) {
    int[] memorization = new int[n + 1];
    return climbStairs1Helper(0, n, memorization);
  }

  private int climbStairs1Helper(int i, int n, int[] memorization) {
    if (i > n) {
      return 0;
    }
    if (i == n) {
      return 1;
    }
    if (memorization[i] != 0) {
      return memorization[i];
    }
    memorization[i] = climbStairs1Helper(i + 1, n, memorization) + climbStairs1Helper(i + 2, n, memorization);
    return memorization[i];
  }

  public int climbStairs2(int n) {
    if (n == 1) {
      return 1;
    }
    int[] dp = new int[n + 1];
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  public int climbStairs3(int n) {
    if (n == 1) {
      return 1;
    }
    int oneStepBefore = 1;
    int twoStepBefore = 2;
    for (int i = 3; i <= n; i++) {
      int allStep = oneStepBefore + twoStepBefore;
      oneStepBefore = twoStepBefore;
      twoStepBefore = allStep;
    }
    return twoStepBefore;
  }

  private final int[][] M = {{1, 1}, {1, 0}};
  private final int[][] BASE = {{1, 0}, {1, 0}};

  public int climbStairs4(int n) {
    if (n == 1) {
      return 1;
    }

    return matrixMultiplication(matrixPow(M, n), BASE)[1][0];
  }

  private int[][] matrixMultiplication(int[][] p, int[][] q) {
    int[][] temp = new int[p.length][q[0].length];

    temp[0][0] = p[0][0] * q[0][0] + p[0][1] * q[1][0];
    temp[0][1] = p[0][0] * q[0][1] + p[0][1] * q[1][1];
    temp[1][0] = p[1][0] * q[0][0] + p[1][1] * q[1][0];
    temp[1][1] = p[1][0] * q[0][1] + p[1][1] * q[1][1];

    return temp;
  }

  private int[][] matrixPow(int[][] x, int n) {
    int[][] res = {{1, 0}, {0, 1}};

    while (n != 0) {
      if ((n & 1) == 1) {
        matrixMultiplication(res, x);
      }

      x = matrixMultiplication(x, x);
      n >>>= 1;
    }

    return res;
  }
}
