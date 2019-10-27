//5,two-sum
    /*
     * 数组没有排序，不能用双指针
     * */
    public static int[] twoSum(int[] nums, int target) {
        int[] num = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j =i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    num[0] = i; num[1] = j;
                }
            }
        }
        return num;
    }
