import java.util.Arrays;

public class Leetcode_26_RemoveDuplicatesfromSortedArray {

    public static void main(String[] args) {
        int[] aaa = new int[]{1,1,2,3,4,4,5,5,6,6,7,8,9,9,9};

        int i = removeDuplicates(aaa);
        System.out.println(i);
    }


    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                index++;
                // TODO：如果索引值相等说明是同一个值不用交换
                if (index != i) {
                    nums[index] = nums[i];
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        return index;
    }

}
