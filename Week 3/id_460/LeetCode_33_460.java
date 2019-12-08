package week3.Homework.Question33Search;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * <p>
 * 示例 2:
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class Search {
    int[] nums;
    int target;

    public static void main(String[] args) {
        Search s = new Search();
        s.nums = new int[]{4, 5, 6, 7, 0, 1, 2, 3};
        s.target = 1;
        System.out.println(s.search(s.nums, s.target));
    }

    public int search(int[] nums, int target) {
        //二分查找
        this.nums = nums;
        this.target = target;

        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return this.nums[0] == target ? 0 : -1;

        //寻找旋转的数
        int rotate_index = findRotateIndex(0, n - 1);

        //如果key值是最小元素
        if (nums[rotate_index] == target) return rotate_index;
        //如果数组不能被旋转，就去整个数组中搜索
        if (rotate_index == 0) return search(0, n - 1);
        if (target < nums[0]) return search(rotate_index, n - 1);
        else return search(0, rotate_index);
    }

    private int findRotateIndex(int left, int right) {
        if (nums[left] < nums[right]) {
            return 0;
        }
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] > nums[pivot + 1])
                return pivot + 1;
            else {
                if (nums[pivot] < nums[left]) right = pivot - 1;
                else left = pivot + 1;
            }
        }
        return 0;
    }

    public int search(int left, int right) {
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] == target) return pivot;
            else {
                if (target < nums[pivot])
                    right = pivot - 1;
                else
                    left = left + 1;
            }
        }
        return -1;
    }
}


























