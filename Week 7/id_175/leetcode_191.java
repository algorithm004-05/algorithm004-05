package week7;

/**
 * @author shizeying
 * @date 2019/12/1 23:03
 * @description
 */
public class leetcode_191 {
  public int hammingWeight(int n) {
    int bits = 0;
    int m = 1;
    for (int i = 0; i < 32; i++) {
      if ((n & m) != 0) {
        bits++;
      }
      m <<= 1;
    }
    return bits;
  }
}
