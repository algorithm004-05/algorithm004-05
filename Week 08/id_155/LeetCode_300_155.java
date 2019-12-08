class Solution {
    public int lengthOfLIS(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int[] seq = new int[nums.length];
        int result = 0;
        for (int num : nums) {
            int i = 0, j = result;
            while (i < j) {
                int mid = (i + j) >>> 1;
                if (seq[mid] < num) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            seq[j] = num;
            if (result == j) {
                result++;
            }
        }
        return result;
    }
}