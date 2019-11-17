public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        //利用快慢游标进行遍历：时间复杂度O(n)，空间复杂度O(1)
        int slowIdx = 0;
        for (int fastIdx = 1; fastIdx < nums.length; fastIdx++) {
            //如果慢游标对应数组值不等于快游标对应数组值，那么慢游标应该加一往下走一位，将快游标的值赋值给慢游标的值，记录的数组长度加一，最后快游标加一往下走一位
            if (nums[slowIdx] != nums[fastIdx]) {
                slowIdx++;
                nums[slowIdx] = nums[fastIdx];
            }
        }

        return slowIdx + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(nums));
    }

}
