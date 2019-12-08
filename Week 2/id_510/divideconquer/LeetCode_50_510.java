import java.util.HashMap;
import java.util.Map;

/**
 *实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_50_510 {

    public static void main(String[] args) {
        int a = Integer.MIN_VALUE;
        int a2 = 0x80000000;
        int a3 = 0x7fffffff;
        int b = 1<<31;
        int a1 = Integer.MAX_VALUE;
        int b1 = - (1<<31) -1 ;
       System.out.println(new LeetCode_50_510().myPow(2, -2147483648));
    }

    /**
     *  递归  边界问题整死人
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if(0 == x){
            return 0;
        }
        if(n == 0x80000000){
            if(-1 == x || 1 == x){
                return 1;
            }
            return 0;
        }
        if(0 == n){
            return 1;
        }

        if(n < 0){
            n = -n;
            x = 1/x;
        }

        // 指数为偶数时 直接相乘  奇数时 需要乘自己一次
        if (n % 2 == 0){
            return myPow(x * x, n/2);
        } else {
            return myPow(x * x, n/2) * x;
        }
    }
}
