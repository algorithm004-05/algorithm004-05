package lsn16_bit;

/**
 * 191. 位1的个数
 * 
 * https://leetcode-cn.com/problems/number-of-1-bits/
 */
public class LeetCode_191_555 {

	public static void main(String[] args) {
		LeetCode_191_555 leetcode = new LeetCode_191_555();
		int n = -3;

		int res = leetcode.hammingWeight(n);
		System.out.println(res);
		int res2 = leetcode.hammingWeight2(n);
		System.out.println(res2);
		int res3 = leetcode.hammingWeight3(n);
		System.out.println(res3);
		int res4 = leetcode.hammingWeight4(n);
		System.out.println(res4);

	}

	public int hammingWeight(int n) {
		int bits = 0;
		int mask = 1;
		for (int i = 0; i < 32; i++) {
			if ((n & mask) != 0) {
				bits++;
			}
			mask <<= 1;
		}
		return bits;
	}

	public int hammingWeight2(int n) {
		int sum = 0;
		while (n != 0) {
			sum++;
			n &= (n - 1);
		}
		return sum;
	}

	public int hammingWeight3(int n) {

		// HD, Figure 5-2
		n = n - ((n >>> 1) & 0x55555555);
		n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
		n = (n + (n >>> 4)) & 0x0f0f0f0f;
		n = n + (n >>> 8);
		n = n + (n >>> 16);
		return n & 0x3f;

//		return Integer.bitCount(n);
	}

	/**
	 * https://leetcode-cn.com/problems/number-of-1-bits/solution/wei-yun-suan-zhong-lowbitxde-ying-yong-javashi-xia/
	 */
	public int hammingWeight4(int n) {
		int ans = 0;
		while (n != 0) {
			ans++;
			n -= lowbit(n);
		}
		return ans;
	}

	private int lowbit(int x) {
		return x & -x;
	}

}
