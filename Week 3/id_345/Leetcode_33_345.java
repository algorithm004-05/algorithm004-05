package xyz.isok.algorithm.leetcode.medium;

public class No33SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums0 = {4,5,6,7,0,1,2};
        int target0 = 0;
        int target1 = 3;

        int[] nums1 = {1};
        int target2 = 1;
        int target3 = 0;

        int[] nums2 = {1,3,5};
        int target4 = 1;

        int[] nums3 = {5,1,3};
        int target5 = 5;

        No33SearchInRotatedSortedArray search = new No33SearchInRotatedSortedArray();
        System.out.println(search.search(nums0, target0));
        System.out.println(search.search(nums0, target1));
        System.out.println(search.search(nums1, target2));
        System.out.println(search.search(nums1, target3));
        System.out.println(search.search(nums2, target4));
        System.out.println(search.search(nums3, target5));
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] >= nums[left]){
                if (target >= nums[left] && target <= nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else {
                if (target >= nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
