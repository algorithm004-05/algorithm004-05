package week2.Lesson8.Question169MajorityElement;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 1, 4, 5, 2, 3, 6, 2, 2, 2};
        MajorityElement me = new MajorityElement();
        System.out.println(me.majorityElement2(nums));
    }
    //使用哈希表来存储每个元素，再用一个循环在线性时间内遍历nums，然后我们只需要返回有最大值的键

    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num) + 1);
            }
        }
        return counts;
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);

        Map.Entry<Integer, Integer> majorityEnter = null;
        for (Map.Entry<Integer, Integer> entry1 : counts.entrySet()) {
            if (majorityEnter == null || entry1.getValue() > majorityEnter.getValue()) {
                majorityEnter = entry1;
            }
        }
        return majorityEnter.getKey();
    }


    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    private int majorityElementec(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority element.
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        int mid = (hi - lo) / 2 + lo;
        int left = majorityElementec(nums, lo, mid);
        int right = majorityElementec(nums, mid + 1, hi);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    public int majorityElement2(int[] nums) {
        return majorityElementec(nums, 0, nums.length - 1);
    }
}
