public class LeetCode_189_495 {

  public static void main(String[] args) {
    int[] nums = {1,2,3,4,5,6,7};
    nums = rotate(nums, 3);
    for (int a: nums) {
      System.out.print(a);
    }
  }

  public static int[] rotate(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
    return nums;
  }

  public static void reverse(int[] nums, int start, int end) {
    while (start < end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }
  }
}
