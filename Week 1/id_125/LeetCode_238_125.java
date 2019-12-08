/**
 * @Auther: 封玉书 FYS
 * @Date: 2019.10.15 21:41
 * @Description:
 */
public class A283 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        moveZeroes2(nums);
    }


    // 1.暴力求解：遇0删除，末尾补0。 时间复杂度 O(n)
    // 2.新建数组：新建同样大小数组，非0拷贝即可
    private static void moveZeroes(int[] nums) {
        int[] newArr = new int[nums.length];

        int i = 0;
        for (int item : nums) {
            if (item != 0) {
                newArr[i] = item;
                i++;
            }
            nums = newArr;
        }
    }

    // 不另外使用新数组
    private static void moveZeroes2(int[] nums) {
        int j = 0;

            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] != 0) {
                    nums[j] = nums[i];
                    if (i != j) {
                        nums[i] = 0;
                    }
                    j++;
                }
        }
    }
}
