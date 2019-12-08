package homework.week6;

import java.util.HashMap;

//https://leetcode-cn.com/problems/climbing-stairs/
public class LeetCode_70_590 {
    /**
     * 爬楼梯问题回顾
     */

    //数学通项公式
    public int climbStairs_1(int n) {
        double sqrt5 = Math.sqrt(5);

        double temp = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);

        return (int) (temp / sqrt5);
    }

    //动态规划
    public int climbStairs_2(int n) {
        int[] results = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            if (i < 2) {
                results[i] = 1;
            } else {
                results[i] = results[i - 1] + results[i - 2];
            }
        }

        return results[n];
    }


    private HashMap<Integer, Integer> visited = new HashMap<>();
    //递归
    public int climbStairs_3(int n) {
        visited.put(0,1);
        visited.put(1,1);
       if (n<2){
           return 1;
       }

       if (visited.containsKey(n)){
           return visited.get(n);
       }

       int result = climbStairs_3(n-1)+climbStairs_3(n-2);

       visited.put(n, result);

       return result;
    }

}
