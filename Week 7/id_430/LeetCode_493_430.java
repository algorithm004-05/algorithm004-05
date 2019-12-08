/**
 * Created by panda on 2019/12/1.
 */
public class LeetCode_493_430 {
    class Solution {
        public int reversePairs(int[] nums) {
            return mergeSort(nums, 0, nums.length - 1);
        }

        private int mergeSort(int[] nums, int l, int r) {
            int count = 0;
            if (l >= r) {
                return 0;
            }
            int mid = l + (r - l) / 2;
            int c1 = mergeSort(nums, l, mid);
            int c2 = mergeSort(nums, mid + 1, r);
            for (int i = l, j = mid + 1; i <= mid; i++) {
                while (j <= r && nums[i] / 2.0 > nums[j])
                    j++;
                count += j - (mid + 1);
            }
            merge(nums, l, mid, r);
            return c1 + c2 + count;
        }

        private void merge(int[] nums, int l, int mid, int r) {
            int[] arr = new int[r - l + 1];
            int k = 0;
            int i = l, j = mid + 1;
            while (i <= mid && j <= r) {
                if (nums[i] <= nums[j]) {
                    arr[k++] = nums[i++];
                } else {
                    arr[k++] = nums[j++];
                }
            }
            while (i <= mid) {
                arr[k++] = nums[i++];
            }
            while (j <= r) {
                arr[k++] = nums[j++];
            }
            System.arraycopy(arr, 0, nums, l, r - l + 1);
        }
    }
}
