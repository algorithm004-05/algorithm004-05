package lsn12_dynamic_programming;

/**
 * 509. 斐波那契数
 *
 * https://leetcode-cn.com/problems/fibonacci-number/
 */
public class LeetCode_509_555 {

	public static void main(String[] args) {
		LeetCode_509_555 leetcode = new LeetCode_509_555();
		int n = 10;
//		int res = leetcode.fib(n,new int[n+1]);
		int res = leetcode.fib(n);
		System.out.println(res);

	}

	/**
	 * 时间复杂度2^n
	 */
//	int fib(int n) {
//		if (n <= 0) {
//			return 0;
//		} else if (n == 1) {
//			return 1;
//		} else {
//			return fib(n - 1) + fib(n - 2);
//		}
//	}
//
//	int fib(int n) {
//		if (n <= 1) {
//			return n;
//		} else {
//			return fib(n - 1) + fib(n - 2);
//		}
//	}

	/**
	 * 写成三目，简化代码
	 */
//	int fib(int n) {
//		return (n <= 1) ? n : fib(n - 1) + fib(n - 2);
//	}

	/**
	 * 添加缓存
	 */
//	int fib(int n, int[] mem) {
//		if (n <= 1) {
//			return n;
//		}
//		if (mem[n] == 0) {
//			mem[n] = fib(n - 1,mem) + fib(n - 2,mem);
//		}
//		return mem[n];
//	}

	/**
	 * 自底向上
	 */
//	int fib(int n) {
//		int[] a = new int[n+1];
//		a[0] = 0;
//		a[1] = 1;
//		for (int i = 2; i <= n; ++i) {
//			a[i] = a[i - 1] + a[i - 2];
//		}
//		return a[n];
//	}

	/**
	 * 消除数组
	 */
//	int fib(int n) {
//		if (n < 2)
//			return n;
//		int prev = 0, curr = 1;
//		for (int i = 0; i < n - 1; i++) {
//			int sum = prev + curr;
//			prev = curr;
//			curr = sum;
//		}
//		return curr;
//	}

	/**
	 * 消除数组
	 */
	public int fib(int N) {
		int curr = 0, next = 1;
		while (N-- > 0) {
			next = next + curr;
			curr = next - curr;
		}
		return curr;
	}

}
