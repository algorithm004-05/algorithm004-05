package lsn01.array.homework;

public class LeetCode_189_555 {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;

		LeetCode_189_555 leetCode = new LeetCode_189_555();
//		leetCode.rotate(nums, k);
//		leetCode.rotate2(nums, k);
//		leetCode.rotate3(nums, k);
		leetCode.rotate4(nums, k);
	}

	public void rotate4(int[] nums, int k) {
		k %= nums.length;// 防止k大于nums.lengt的情况
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);

		print(nums);

	}

	public void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

	public void rotate3(int[] nums, int k) {
		int[] a = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
//			a[(i+k) % nums.length] = nums[i];
			a[i] = nums[(i + k) % nums.length];
		}

		for (int i = 0; i < a.length; i++) {
			nums[i] = a[i];
		}

		print(nums);

	}

	public void rotate2(int[] nums, int k) {
		int temp, previous;

		previous = nums[nums.length - 1];

		for (int j = 0; j < nums.length; j++) {
			temp = nums[j];
			nums[j] = previous;
			previous = temp;
		}

		print(nums);

	}

	public void rotate(int[] nums, int k) {
		int temp, previous;

		for (int i = 0; i < k; i++) {

			previous = nums[nums.length - 1];

			for (int j = 0; j < nums.length; j++) {
				temp = nums[j];
				nums[j] = previous;
				previous = temp;
			}

		}

		print(nums);

	}

	public void print(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}

}
