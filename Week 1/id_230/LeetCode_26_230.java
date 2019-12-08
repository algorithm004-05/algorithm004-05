//1,remove-duplicates-from-sorted-array
    /*
     * 把重复的数字，用数组中的最大值加一替换
     * */
    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int k = 0, max = nums[nums.length - 1] + 1, time = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    nums[j] = max;
                    max++;
                    time++;
                }
            }
        }
        Arrays.sort(nums);
        return nums.length - time;
    }
