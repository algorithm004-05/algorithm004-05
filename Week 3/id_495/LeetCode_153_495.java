class LeetCode_153_495 {
    public static void main(String[] args) {
        System.out.println(findMin(new int[] {4,5,6,7,1,2,3}));
    }

    public static int findMin(int[] nums) {
      int left = 0;
      int right = nums.length - 1;
      while (left < right) {
          int mid = left + (right - left) / 2;
          if (nums[mid] > nums[right]) left = mid + 1;
          else right = mid;
      }
      return nums[left];
    }
}
