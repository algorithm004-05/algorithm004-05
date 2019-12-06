package lsn16_bit;

/**
 * 231. 2的幂
 * 
 * https://leetcode-cn.com/problems/power-of-two/
 * 
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * 
 */
public class LeetCode_231_555 {

	public static void main(String[] args) {
		LeetCode_231_555 leetcode = new LeetCode_231_555();

		int n = 8;
		boolean bol = leetcode.isPowerOfTwo(n);
		System.out.println(bol);

	}

	public boolean isPowerOfTwo(int n) {
		return n > 0 && (n & (n - 1)) == 0;
	}

}
