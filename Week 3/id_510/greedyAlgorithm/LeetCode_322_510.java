import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * 零钱兑换
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_322_510 {

    

    /**
     * 回溯超时
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if( null == coins || 0 == coins.length){
            return -1;
        }
        if(0 == amount){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        Arrays.sort(coins);
        int index = coins.length - 1;
        stack.push(index);
        int temp = amount;
        int min = -1;
        while(stack.size() > 0){
            temp -= coins[stack.peek()];
            if (temp > 0) {
                stack.push(index);
                continue;
            } else if (temp == 0) {
                if (min > stack.size() || -1 == min) {
                    min = stack.size();
                } 
            } 
            temp += coins[stack.peek()];
            index = stack.pop() - 1;
            while (index < 0) {
                if( 0 == stack.size()){
                    return min;
                 }
                temp += coins[stack.peek()];
                index = stack.pop() - 1;
            }
            stack.push(index);
        }
        return min;
    }

    

    static Map<Integer,Integer> map = new HashMap<>();

    /**
     * 有缓存的递归
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange1(int[] coins, int amount) {
        if( null == coins || 0 == coins.length || amount < 0){
            return -1;
        }
        if(0 == amount){
            return 0;
        }
        if(map.containsKey(amount)){
            return map.get(amount);
        }
        int min = amount + 1;
        for (int i = 0; i < coins.length; i++) {
            int temp = coinChange1(coins, amount - coins[i]);
            if(temp >= 0 ){
                min = Math.min(min, temp+1);
            }
        }
        if(min > amount){
            min = -1;
        }
        map.put(amount, min);
        return min;
    }

    /**
     * 动态规划
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        if( null == coins || 0 == coins.length || amount < 0){
            return -1;
        }
        if(0 == amount){
            return 0;
        }

        int[] dq = new int[amount+1];
        for (int i = 1; i <= amount; i++) {
            dq[i] = amount + 1;
            for (int c : coins) {
                if(c <= i){
                    dq[i] = Math.min(dq[i],dq[i - c]+1);
                }
            }
        }
        if(dq[amount] > amount){
            return -1;
        }
        return dq[amount];
    }

    /**
     * 动态规划 优化
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange3(int[] coins, int amount) {
        if( null == coins || 0 == coins.length || amount < 0){
            return -1;
        }
        if(0 == amount){
            return 0;
        }

        int length = coins.length;
        int[] dq = new int[length+1];
        int min = amount + 1;
        for (int i = amount; i > 0; i++) {
            for (int j = 0; j < length; j++) {
                
            }
            
        }
       
        return min;
    }

    public static void main(String[] args) {
        int[] coins = new int[]{3,7,405,436};

        LeetCode_322_510 t = new LeetCode_322_510();
        System.out.println(t.coinChange2(coins, 8839));
    }
}
