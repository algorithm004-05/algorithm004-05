class Solution {
    public int maxSubArray(int[] nums) {
        int an = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            an = Math.max(an, sum);
        }
        return an;
    }
}

