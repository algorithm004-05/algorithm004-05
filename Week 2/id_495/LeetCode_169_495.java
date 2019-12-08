/**
* 给定一个大小为 n 的数组，
* 找到其中的众数。
* 众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素
*/
public class LeetCode_169_495 {

  public static void main(String[] args) {
    System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
  }

  public static int majorityElement(int[] num) {

    int ret = 0;

    for (int i = 0; i < 32; i++) {

        int ones = 0, zeros = 0;

        for (int j = 0; j < num.length; j++) {
            if ((num[j] & (1 << i)) != 0) {
                ++ones;
            }
            else
                ++zeros;
        }

        if (ones > zeros)
            ret |= (1 << i);
    }

    return ret;
  }
}
