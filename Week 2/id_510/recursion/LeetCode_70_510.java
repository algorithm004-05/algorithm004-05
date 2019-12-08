import java.util.HashMap;
import java.util.Map;

/**
*假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_70_510 {

    private Map<Integer,Integer> map = new HashMap<>();
    /**
     * 递归
     */
    public int climbStairs(int n) {
        if(2 >= n){
            return n;
        }
        if(map.containsKey(n)){
            return map.get(n);
        }
        int temp =climbStairs(n-1) + climbStairs(n-2);
        map.put(n, temp);
        return temp;
    }

    /**
     * 递归可替换为循环
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        if(2 >= n){
            return n;
        }
        int a = 1,b=2, res;
        for (int i = 3; i <= n; i++) {
            res = a+b;
            a=b;
            b=res;
        }
        return b;
    }
}
