package Question189RotateArray;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * <p>
 * <p>
 * 要求使用空间复杂度为 O(1) 的 原地算法。
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate1(nums,k);
    }
    /**暴力解法
     * 旋转k次，每次将数组旋转1个元素*/
    private static void rotate1(int[] nums, int k) {
        int temp,previous;
        for (int i =0;i<k;i++){
            previous = nums[nums.length-1];//把最后一个元素存下来
            for (int j=0;j<nums.length;j++){
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }
    /**
     * 使用额外的数组
     * 可以用一个额外的数组来将每个元素放到正确的位置上，
     * 也就是原本数组里下标为i的放到(i+k)%nums.length 的位置上，然后把
     * 新的数组复制到原数组中。
     * */
    private static void rotate2(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            temp[(i+k)%nums.length] =nums[i];
        }
        for(int i=0;i<nums.length;i++){
            nums[i] = temp[i];
        }
    }
    /**
     * 反转
     * 旋转数组k次，k%n个尾部元素会以原来的顺序被放到数组的头部，剩下的元素会被向后移动。
     * 1.把所有的元素反转；
     * 2.反转前k个元素；
     * 3.反转后面n-k个元素-->得到结果
     * 原始数组                  : 1 2 3 4 5 6 7
     * 反转所有数字后             : 7 6 5 4 3 2 1
     * 反转前 k 个数字后          : 5 6 7 4 3 2 1
     * 反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
     * */
    private static void rotate3(int[] nums, int k) {
        k = k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}


















