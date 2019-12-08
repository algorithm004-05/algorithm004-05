package lsn16_bit;

import java.util.Arrays;

/**
 * 338. 比特位计数
 * 
 * https://leetcode-cn.com/problems/counting-bits/
 */
public class LeetCode_338_555 {

	public static void main(String[] args) {
		LeetCode_338_555 leetcode = new LeetCode_338_555();

		int num = 5;
		int[] ans = leetcode.countBits(num);
		System.out.println(Arrays.toString(ans));
	}

	public int[] countBits(int num) {
		int[] ans = new int[num + 1];
		for (int i = 0; i <= num; ++i)
			ans[i] = popcount(i);
		return ans;
	}

	private int popcount(int x) {
		int count;
		for (count = 0; x != 0; ++count)
			x &= x - 1; // zeroing out the least significant nonzero bit
		return count;
	}

}
