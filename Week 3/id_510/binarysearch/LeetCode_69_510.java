

/**
 *  x 的平方根
 *
 *实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_69_510 {

    
    public int mySqrt(int x) {
        if(x <= 0){
            return 0;
        }
        int low = 1;
        int upper = x;
        int mid = 1;
        while(low < upper){
            mid = low + ((upper-low)>>1);
            if(mid > x/mid){
                upper = mid -1;
            } else if(mid == x/mid){
                low = mid;
                break;
            }else {
                // 相等 说明low与upper相邻
                if (low == mid){
                    // 判断upper是否匹配
                    if(upper  <=  x/upper){
                        low = upper;
                    }
                    break;
                }
                low = mid;
            }
        }
        return low;
    }

    /**
     * 
     * @param x
     * @return
     */
    public int mySqrt1(int x) {
        if(x <= 0){
            return 0;
        }
        long low = 1;
        long upper = x;
        while(low < upper){
            long mid = low + ((upper-low)>>1);
            if(mid*mid > x){
                upper = mid -1;
            }else {
                low = mid + 1;
            }
        }
        return (int)(low * low <= x ? low:low-1);
    }

    /**
     * 牛顿迭代法
     * f(x) = x^2 - a
     * 
     * 节点x0的斜率 f‘(x0) = 2x0
     * 
     * f‘(x0) = (f(x) - f(x0))/(x-x0)
     * 
     * 令f(x) = 0; 则 x 就是 a 的平方根
     * 
     * 2x0 = (x^2 - a - (x0 - a))/(x - x0)
     * 
     * x = 1/2(x0 + a/x0)
     *
     * 
     * @param x
     * @return
     */
    public int mySqrt2(int x) {
        if(x <= 0){
            return 0;
        }
        double cur = 1;
        double pre = 1;
        while(pre > 1e-6){
            pre = cur;
            cur = (cur + x/cur)/2;
            pre -=cur;
            if(pre< 0){
                pre = -pre;
            }
        }
        return (int)cur;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_69_510().mySqrt2(2147483647));
    }
}
