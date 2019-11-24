package week5;

/**
 * @author shizeying
 * @date 2019/11/16 09:16
 * @description
 */
public class Leetcode_70 {

  public int climbStairs1(int n) {
    return n <= 2 ? n : climbStairs1(n - 1) + climbStairs1(n - 2);
  }

  

  public int climbStairs(int n) {
	  int[] memo=new int[n];
    return fib(n, memo);
  }

  private int fib(int n, int[] memo) {
    if (n <= 2) {
      return n;
    }
    if (memo[n] == 0) {
      memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
    }
    return memo[n];
  }
}
