package lsn16_bit;


/**
 * 190. 颠倒二进制位
 *
 * https://leetcode-cn.com/problems/reverse-bits/
 */
public class LeetCode_190_555 {

	public static void main(String[] args) {
		LeetCode_190_555 leetcode = new LeetCode_190_555();
		int n = 10;
		int ans = leetcode.reverseBits(n);
		System.out.println(ans);
		int ans2 = leetcode.reverseBits2(n);
		System.out.println(ans2);

	}

	/**
	 * 位移 + 拼接
	 * 
	 * https://leetcode-cn.com/problems/reverse-bits/solution/190-dian-dao-er-jin-zhi-wei-by-alexer-660/
	 */
	public int reverseBits(int n) {
		int ans = 0;
		for (int i = 0; i < 32; i++) {
			ans = (ans << 1) + (n & 1);
			n >>= 1;
		}
		return ans >>> 0;
	}

	/**
	 * 从最低位到最高位逐位检查n的第i位是不是为1. 如果是, 就把（31-i）位设为1
	 */
	public int reverseBits2(int n) {
		int ans = 0;
		int mask = 1;
		for (int i = 0; i < 32; i++) {
			if ((n & mask) != 0) {
				ans |= 1 << (31 - i);
			}
			mask <<= 1;
		}
		return ans;
	}



}
