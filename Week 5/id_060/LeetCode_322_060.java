/*
  322
  You are given coins of different denominations and a total amount of money amount.
  Write a function to compute the fewest number of coins that you need to make up that amount.
  If that amount of money cannot be made up by any combination of the coins, return -1.

  Example 1:
    Input: coins = [1, 2, 5], amount = 11
    Output: 3

  Explanation:
  11 = 5 + 5 + 1

  Example 2:
    Input: coins = [2], amount = 3
    Output: -1

  Note:
    You may assume that you have an infinite number of each kind of coin.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CoinChange {

  // BFS
  int count;
  boolean isSolution;

  public int coinChange1(int[] coins, int amount) {
    if (amount == 0) {
      return 0;
    }
    count = 0;
    isSolution = false;
    Set<Integer> subAmount = new HashSet<>();
    subAmount.add(amount);

    while (!subAmount.isEmpty() && !isSolution) {
      count++;

      Set<Integer> tempSubAmount = new HashSet<>();
      Iterator<Integer> iterator = subAmount.iterator();

      while (iterator.hasNext() && !isSolution) {
        int newAmount = iterator.next();
        iterator.remove();

        for (int coin : coins) {
          if (newAmount - coin == 0) {
            isSolution = true;
          } else if (newAmount - coin > 0) {
            tempSubAmount.add(newAmount - coin);
          }
        }
      }

      subAmount = tempSubAmount;
    }
    return isSolution ? count : -1;
  }

  // DFS
  // Time limit exceeded
  int result = Integer.MAX_VALUE;

  public int coinChange2(int[] coins, int amount) {
    if (amount == 0) {
      return 0;
    }
    DFS(coins, amount, new ArrayList<>());
    return result == Integer.MAX_VALUE ? -1 : result;
  }

  private void DFS(int[] coins, int amount, List<Integer> tempList) {
    if (amount < 0) {
      return;
    }

    if (amount == 0) {
      result = Math.min(result, tempList.size());
      return;
    }

    for (int coin : coins) {
      List<Integer> nextTempList = new ArrayList<>(tempList);
      nextTempList.add(coin);
      DFS(coins, amount - coin, nextTempList);
    }
  }

  // Memorization DFS
  public int coinChange3(int[] coins, int amount) {
    if (amount < 1) {
      return 0;
    }

    return helper(coins, amount, new int[amount]);
  }

  private int helper(int[] coins, int amount, int[] memo) {
    if (amount < 0) {
      return -1;
    }

    if (amount == 0) {
      return 0;
    }

    if (memo[amount - 1] != 0) {
      return memo[amount - 1];
    }

    int min = Integer.MAX_VALUE;

    for (int coin : coins) {
      int result = helper(coins, amount - coin, memo);

      if ((result == 0 || result > 0) && result < min) {
        min = result + 1;
      }
    }

    memo[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;

    return memo[amount - 1];
  }

  // DP
  public int coinChange0(int[] coins, int amount) {
    if (coins == null || amount == 0) {
      return -1;
    }

    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;

    for (int subAmount = 1; subAmount <= amount; subAmount++) {
      for (int coin : coins) {
        if (subAmount >= coin) {
          dp[subAmount] = Math.min(dp[subAmount], dp[subAmount - coin] + 1);
        }
      }
    }

    return dp[amount] > amount ? -1 : dp[amount];
  }


  // Extra Thinking
  // List all possible solution
  // DFS
  public List<List<Integer>> allCombinations(int[] coins, int amount) {
    Set<List<Integer>> result = new HashSet<>();
    helper(coins, amount, new ArrayList<>(), result);
    return new ArrayList<>(result);
  }

  private void helper(int[] coins, int amount, List<Integer> tempList, Set<List<Integer>> result) {
    if (amount < 0) {
      return;
    }

    if (amount == 0) {
      Collections.sort(tempList);
      result.add(new ArrayList<>(tempList));
      return;
    }

    for (int coin : coins) {
      List<Integer> nextTempList = new ArrayList<>(tempList);
      nextTempList.add(coin);
      helper(coins, amount - coin, nextTempList, result);
    }
  }
}
