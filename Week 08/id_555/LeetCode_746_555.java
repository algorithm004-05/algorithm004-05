package lsn19_high_dp;

/**
 * 746. 使用最小花费爬楼梯
 *
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 */
public class LeetCode_746_555 {

	public static void main(String[] args) {
		LeetCode_746_555 leetcode = new LeetCode_746_555();
		int[] cost = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
		System.out.println(leetcode.minCostClimbingStairs(cost));
	}

	public int minCostClimbingStairs(int[] cost) {
		int[] a = new int[cost.length];// 记录每个台阶最小花费
		a[0] = cost[0];
		a[1] = cost[1];
		for (int i = 2; i < a.length; i++) {
			a[i] = Math.min(a[i - 1] + cost[i], a[i - 2] + cost[i]);
		}
		return Math.min(a[a.length - 1], a[a.length - 2]);// 在最后两个台阶中选个最小的登顶，结束
	}

	public int minCostClimbingStairs2(int[] cost) {
		int f1 = 0, f2 = 0;
		for (int i = cost.length - 1; i >= 0; --i) {
			int f0 = cost[i] + Math.min(f1, f2);
			f2 = f1;
			f1 = f0;
		}
		return Math.min(f1, f2);
	}

	public int minCostClimbingStairs3(int[] cost) {
		for (int i = 2; i < cost.length; i++) {
			cost[i] += Math.min(cost[i - 1], cost[i - 2]);
		}
		return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
	}

}
