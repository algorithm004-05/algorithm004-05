/**
 * @Auther: 封玉书 FYS
 * @Date: 2019.11.3 15:34
 * @Description:
 */
public class A33 {
    public static void main(String[] args) {
        A33 a33 = new A33();
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 3;

        System.out.println(a33.search(nums, target));
    }

    /**
     * 二分查找
     * 1、当数组为[0 1 2 3 4 5 6] mid值为 3，目标值为 2。
     * 往前查找的条件应该为： nums[0] <= tar <= nums[mid]
     * <p>
     * 2、当数组为[5 6 0 1 2 3 4] mid值为 1，目标值为 6
     * 往前查找的条件应该为： nums[mid] <= nums[0] <= tar
     * <p>
     * 3、当数组为[5 6 0 1 2 3 4] mid值为 1，目标值为 0
     * 往前查找的条件应该为： nums[mid] <= nums[0] <= tar
     * <p>
     * 其余条件都应该往后查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;

        while (begin < end) {
            int mid = (begin + end) / 2;

            if ((nums[0] <= target && target <= nums[mid]) ||
                    (target <= nums[mid] && nums[mid] < nums[0]) ||
                    (nums[mid] < nums[0] && nums[0] <= target)) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return begin == end && nums[begin] == target ? begin : -1;
    }
}
