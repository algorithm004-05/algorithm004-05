class Solution {
    public int majorityElement(int[] nums) {
        return search(nums, 0 , nums.length-1);
    }

    private int search(int[] nums, int lo, int hi) {
        if(lo == hi) {
            return nums[lo];
        }

        int middle = (hi-lo)/2 + lo;
        int left = search(nums, lo, middle);
        int right = search(nums, middle+1, hi);

        if( left == right) {
            return left;
        }

        int countLeft = count(left,nums, lo, hi);
        int countRight = count(right, nums, lo ,hi);

        return countLeft > countRight ? left: right;
    }

    private int count(int value, int[] nums, int lo, int hi) {
        int count = 0;
        for(int num: nums){
            if(num == value) {
                count++;
            }
        }
        return count;
    }
}