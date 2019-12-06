package week7;

/**
 * @author shizeying
 * @date 2019/12/1 23:04
 * @description
 */
public class Leetcode_338 {
  public int[] countBits(int num) {
    int[] ans = new int[num + 1];
    for (int i = 0; i <= num; ++i) ans[i] = getPopCount(i);
    return ans;
  }

  private int getPopCount(int x) {
    int count;
    for (count = 0; x != 0; ++count) x &= x - 1; // zeroing out the least significant nonzero bit
    return count;
  }
}
