package id_105;

public class LeetCode_153_105 {


    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= min) {
                min = nums[mid];
            }
            if (left == right) {
                break;
            }

            if (nums[0] <= nums[mid]) {//left ordered.
                if (nums[mid] >= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {//right ordered.
                right = mid;
            }
        }
        return min;
    }


    public static void main(String[] args) {
        LeetCode_153_105 l = new LeetCode_153_105();
        int min = l.findMin(new int[]{7, 8, 0, 1, 2, 3, 4, 5, 6});
        System.out.println(min);
        min = l.findMin(new int[]{3, 4, 5, 1, 2});
        System.out.println(min);

        min = l.findMin(new int[]{4, 5, 6, 7, 0, 1, 2});
        System.out.println(min);
    }
}
