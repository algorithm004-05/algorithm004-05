package lsn07.recursion;

public class LeetCode_70_555 {

	public static void main(String[] args) {
		LeetCode_70_555 leetcode = new LeetCode_70_555();

		
		int res = leetcode.climbStairs(30);
		System.out.println(res);
		
	}

	public int climbStairs(int n) {

		if(n==1) return 1;
		if(n==2) return 2;
		
		return climbStairs(n-1) + climbStairs(n-2);
		
	}
}
