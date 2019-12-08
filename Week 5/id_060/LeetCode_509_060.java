/*
  509
  The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

  F(0) = 0,   F(1) = 1
  F(N) = F(N - 1) + F(N - 2), for N > 1.
  Given N, calculate F(N). 

  Example 1:
    Input: 2
    Output: 1

  Explanation:
  F(2) = F(1) + F(0) = 1 + 0 = 1.

  Example 2:
    Input: 3
    Output: 2

  Explanation:
    F(3) = F(2) + F(1) = 1 + 1 = 2.

  Example 3:
    Input: 4
    Output: 3

  Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.

  Note:
    0 ≤ N ≤ 30.
*/

public class FibonacciNumber {

  public int fib0(int N) {
    if (N <= 1) {
      return N;
    }
    return fib0(N - 1) + fib0(N - 2);
  }

  private int[] memo;

  public int fib1(int N) {
    memo = new int[N + 1];
    return helper(N);
  }

  private int helper(int N) {
    if (memo[N] != 0) {
      return memo[N];
    }
    if (N <= 1) {
      memo[N] = N;
      return N;
    }
    memo[N] = helper(N - 1) + helper(N - 2);
    return memo[N];
  }

  public int fib2(int N) {
    if (N <= 1) {
      return N;
    }

    int[] DP = new int[N + 1];
    DP[0] = 0;
    DP[1] = 1;

    for (int i = 2; i <= N; i++) {
      DP[i] = DP[i - 1] + DP[i - 2];
    }

    return DP[N];
  }

  public int fib3(int N) {
    if (N <= 1) {
      return N;
    }

    int[] DP = {0, 1};

    for (int i = 2; i <= N; i++) {
      if ((i & 1) == 1) {
        DP[1] = DP[0] + DP[1];
      } else {
        DP[0] = DP[1] + DP[0];
      }
    }

    return ((N & 1) == 1) ? DP[1] : DP[0];
  }

  public int fib4(int N) {
    if (N <= 1) {
      return N;
    }

    int beforeTwoNumber = 0;
    int beforeOneNUmber = 1;

    for (int i = 2; i <= N; i++) {
      int result = beforeOneNUmber + beforeTwoNumber;
      beforeTwoNumber = beforeOneNUmber;
      beforeOneNUmber = result;
    }

    return beforeOneNUmber;
  }

  private final int[][] M = {{1, 1}, {1, 0}};
  private final int[][] BASE = {{1, 0}, {1, 0}};

  public int fib5(int N) {
    if (N == 0 || N == 1) {
      return N;
    }

    return matrixMultiplication0(matrixPow(M, N - 1), BASE)[1][0];
  }

  private int[][] matrixMultiplication0(int[][] p, int[][] q) {
    int[][] temp = new int[p.length][q[0].length];

    temp[0][0] = p[0][0] * q[0][0] + p[0][1] * q[1][0];
    temp[0][1] = p[0][0] * q[0][1] + p[0][1] * q[1][1];
    temp[1][0] = p[1][0] * q[0][0] + p[1][1] * q[1][0];
    temp[1][1] = p[1][0] * q[0][1] + p[1][1] * q[1][1];

    return temp;
  }

  private int[][] matrixMultiplication1(int[][] p, int[][] q) {
    int[][] res = new int[p.length][q[0].length];

    for (int i = 0; i < p.length; i++) {
      for (int k = 0; k < p[0].length; k++) {
        for (int j = 0; j < q[0].length; j++) {
          res[i][j] += p[i][k] * q[k][j];
        }
      }
    }

    return res;
  }

  private int[][] matrixPow(int[][] x, int n) {
    int[][] res = {{1, 0}, {0, 1}};

    while (n != 0) {
      if ((n & 1) == 1) {
        res = matrixMultiplication0(res, x);
      }

      x = matrixMultiplication0(x, x);
      n >>>= 1;
    }

    return res;
  }
}
