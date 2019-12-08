//给定一个可包含重复数字的序列，返回所有不重复的全排列。
//
//示例:
//
//输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/permutations-ii
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_47_295 {
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        List<List<Integer>> list = new ArrayList<>();
//        Arrays.sort(nums);
//        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
//        return list;
//    }
//
//    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
//        if (tempList.size() == nums.length) {
//            list.add(new ArrayList<>(tempList));
//        } else {
//            for (int i = 0; i < nums.length; i++) {
//                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
//                used[i] = true;
//                tempList.add(nums[i]);
//                backtrack(list, tempList, nums, used);
//                used[i] = false;
//                tempList.remove(tempList.size() - 1);
//            }
//        }
//    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        _generate(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    // 1. 排序
    // 2. 使用 boolean 数组 used 来判断当前 index 所指元素是否被用过
    // 3. 判断当前元素是否与前一元素相同，以及前一元素是否被用过
    private void _generate(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] used) {
        if (temp.size() == nums.length) res.add(new ArrayList<>(temp));
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;
            used[i] = true;
            temp.add(nums[i]);
            _generate(res, temp, nums, used);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}
