/**
 * @Auther: 封玉书 FYS
 * @Date: 2019.10.17 21:49
 * @Description:
 */
public class A189 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate0(arr, 3);
        rotate1(arr, 3);
        rotate2(arr, 3);
    }

    /**
     * 使用额外的数组，依次把数组赋值到新的数组中。
     * 老数组A的指针i从0开始，新数组指针j从K开始
     * 当j超过数组大小，则重新置位0即可。
     * 但是使用了新的数组。
     * 时间：O(n)
     * 空间：O(n)
     */
    private static void rotate0(int[] nums, int k) {
        int[] newNum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int j = i + k;
            if (j >= newNum.length) {
                j -= nums.length;
            }
            newNum[j] = nums[i];
        }
    }

    /**
     * 最简单粗暴的办法，每次只移动一个位置，循环k次
     * 空间：O(1)
     * 时间：O(n*k)
     *
     * @param nums
     * @param k
     */
    private static void rotate1(int[] nums, int k) {
        for (int times = 0; times < k; times++) {
            int last = nums[nums.length - 1];
            System.arraycopy(nums, 0, nums, 1, nums.length - 1);
            nums[0] = last;
        }
    }

    /**
     * 反转方法
     * 空间：O(1)
     * 时间：O(n)
     * 示意图：[1,2,3,4,5,6,7] k=3
     * 三次反转图：
     * 7,6,5,4,3,2,1
     * 5,6,7,4,3,2,1
     * 5,6,7,1,2,3,4
     *
     * @param nums
     * @param k
     */
    private static void rotate2(int[] nums, int k) {

        int length = nums.length;

        // 只有一个数值，或者不需要移动的情况
        if (length < 2 || k == 0) {
            return;
        }

        // 如果移动的长度超过了数组，则取余
        k %= nums.length;

        // 做第一次反转，所有值反转
        int j = length - 1;
        for (int i = 0; i < nums.length / 2; i++) {
            reverse(nums, i, j--);
        }

        // 反转前K位，
        j = k - 1;
        for (int i = 0; i < k / 2; i++) {
            reverse(nums, i, j--);
        }

        // 反转K位后面的值
        j = length - 1;
        for (int i = k; i < (nums.length - k) / 2 + k; i++) {
            reverse(nums, i, j--);
        }
    }

    private static void reverse(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
