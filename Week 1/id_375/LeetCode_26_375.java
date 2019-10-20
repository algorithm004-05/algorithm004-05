class Solution {
    
    public int removeDuplicates(int[] nums) {
        if (true)
            return withoutLastVal(nums);
        Integer lastVal = null;
        int endIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (lastVal == null) {
                endIndex++;
            } else if (nums[i] != lastVal) {
                if (endIndex < i) {
                    nums[endIndex] = nums[i];
                }
                endIndex++;
            }
            lastVal = nums[i];
        }
        return endIndex;
    }
    
    // optimize : remove lastVal
    private int withoutLastVal(int[] nums) {
        if (nums.length == 0) return 0;
        int endIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[endIndex]) {
                endIndex++;
                nums[endIndex] = nums[i];
            }
        }
        return endIndex + 1;
    }
    
}
