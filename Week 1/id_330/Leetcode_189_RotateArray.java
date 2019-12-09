import java.util.Arrays;
import java.util.Stack;

public class Leetcode_189_RotateArray {
    public static void main(String[] args) {

        int[] ints = {1, 2, 3, 4};
        rotate3(ints,2);


    }
// TODO: 每次挪动一格，k次
    public static void rotate1(int[] nums, int k) {
        int temp, pre;
        for (int i = 0; i < k; i++) {
            pre = nums[nums.length -1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = pre;
                pre = temp;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
// TODO： 使用额外的数组，再放回去
    public static void rotate2(int[] nums, int k) {
        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[(i+k)%nums.length] = nums[i];
        }
        System.arraycopy(newNums, 0, nums, 0, nums.length);
        System.out.println(Arrays.toString(nums));
    }
//    TODO: 反转数组三次
    public static void rotate3(int[] nums, int k) {
        reverse(nums, 0, nums.length-1);
        reverse(nums, k, nums.length-1);
        reverse(nums, 0, k-1);
        System.out.println(Arrays.toString(nums));

    }
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
