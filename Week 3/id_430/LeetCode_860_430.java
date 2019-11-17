
// Copyright(c) 2019 Mobvoi Inc. All Rights Reserved.

import java.util.Arrays;

/**
 * @Author Shuangshuang Wang, <shshwang@mobvoi.com>
 * @Date 2019/11/3
 */
public class LeetCode_860_430 {

  /**
   * 较慢的排序+贪心
   */
  class Solution1 {
    public boolean lemonadeChange(int[] bills) {
      int n = bills.length;
      for (int i = 0; i < n; i++) {
        Arrays.sort(bills, 0, i);
        if (!change(bills[i] - 5, bills, i)) {
          return false;
        }
      }
      return true;
    }

    /**
     * 是否可找零，end是不包含的
     */
    private boolean change(int change, int[] bills, int end) {
      if (change == 0) {
        return true;
      }
      for (int i = end - 1; i >= 0; i--) {
        if (bills[i] <= change) {
          change = change - bills[i];
          bills[i] = 0;
          return change(change, bills, i);
        }
      }
      return false;
    }
  }

  /**
   * 最优，枚举+贪心，比较适合限制条件较多，可能情况较少的场景
   */
  class Solution2 {
    public boolean lemonadeChange(int[] bills) {
      int n = bills.length;
      int five = 0;
      int ten = 0;
      for (int i = 0; i < n; i++) {
        int bill = bills[i];
        // 只买一杯，只有三种情况，枚举比排序快
        // 收5块，无需找零
        if (bill == 5) {
          five++;
          // 收10块，无需找零
        } else if (bill == 10) {
          ten++;
          if (five > 0) {
            five--;
          } else {
            return false;
          }
          // 收20，找15
        } else if (bill == 20) {
          // 20不用记录，其不用于找零
          if (five > 0 && ten > 0) {
            five--;
            ten--;
          } else if (five >= 3) {
            five -= 3;
          } else {
            return false;
          }
        }
      }
      return true;
    }
  }
}
