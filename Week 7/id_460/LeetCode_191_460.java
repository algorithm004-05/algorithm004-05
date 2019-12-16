package week7;

/**
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 * <p>
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-1-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_191_460 {
    public static void main(String[] args) {
        int a = 00000000000000000000000000001011;
        System.out.println(Integer.bitCount(a));
    }

    private static int hammingWeight(int a) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((a & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }
    private static int hammingWeightII(int n){
        int sum =0;
        while (n!=0){
            sum++;
            n &= (n-1);
        }
        return sum;
    }
    public static int bitCount(int i) {
        // HD, Figure 5-2
        i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i + (i >>> 4)) & 0x0f0f0f0f;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        return i & 0x3f;
    }
}
