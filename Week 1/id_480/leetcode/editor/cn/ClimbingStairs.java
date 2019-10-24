package leetcode.editor.cn;//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {
    public static void main(String[] args) {
        Solution3 solution = new ClimbingStairs().new Solution3();
        long startTime = System.currentTimeMillis();
        int count = solution.climbStairs(4);
        System.out.println(count);
        System.out.println(System.currentTimeMillis() - startTime);
    }


    /**
     * 暴力法
     */
    class Solution {
        public int climbStairs(int n) {
            return climbDetailStairs(0, n);
        }

        private int climbDetailStairs(int currentStair, int targetStair) {
            if (currentStair > targetStair) {
                return 0;
            }
            if (currentStair == targetStair) {
                return 1;
            }
            return climbDetailStairs(currentStair + 1, targetStair) + climbDetailStairs(currentStair + 2, targetStair);
        }
    }

    /**
     * 暴力法 + 结果缓存
     */
    class Solution2 {

        private final Map<Integer, Integer> resultMap = new HashMap<>();

        public int climbStairs(int n) {
            return climbDetailStairs(0, n);
        }

        private int climbDetailStairs(int currentStair, int targetStair) {
            if (currentStair > targetStair) {
                return 0;
            }
            if (currentStair == targetStair) {
                return 1;
            }
            Integer resultCache = resultMap.get(currentStair);
            if (resultCache != null) {
                return resultCache;
            }
            resultCache = climbDetailStairs(currentStair + 1, targetStair) + climbDetailStairs(currentStair + 2, targetStair);
            resultMap.put(currentStair, resultCache);
            return resultCache;
        }
    }

    /**
     * 斐波那契数列
     */
    class Solution3 {
        public int climbStairs(int n) {
            if (n == 1) {
                return 1;
            }
            int first = 1;
            int second = 2;
            for (int i = 3; i <= n; i++) {
                int third = first + second;
                first = second;
                second = third;
            }
            return second;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}