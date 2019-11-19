


/**
 * 搜索旋转排序数组
 *
 *假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_33_510 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_33_510().search(new int[]{4,5}, 5));
    }

    /**
     * 左右边界的值变化应该一直 不然会出现死循环
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if(null == nums || 0 == nums.length){
            return -1;
        }
        int left = 0;
        int right = nums.length-1;
        while (left < right){
            int mid = left + ((right- left)>> 1);
            if(nums[left] <= nums[mid]){
                // 左边单调判断是否在左边
                if(nums[left] <= target && nums[mid] >= target){
                    right = mid;
                }  else {
                    left = mid+1;
                }
                
            } else {
                // 右边单调 判断是否在右边
                if(nums[mid] <= target && nums[right] >= target){
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
        }
        if(nums[left] == target){
            return left;
        }
        return -1;
    }
}
