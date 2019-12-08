//给定一个没有重复数字的序列，返回其所有可能的全排列。
//
//示例:
//
//输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/permutations
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.util.ArrayList;
import java.util.List;

public class LeetCode_46_295 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        _generate(res, new ArrayList<>(), nums);
        return res;
    }

    private void _generate(List<List<Integer>> res, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) res.add(new ArrayList<>(temp));
        for (int num : nums) {
            if (temp.contains(num)) continue;
            temp.add(num);
            _generate(res, temp, nums);
            temp.remove(temp.size() - 1);
        }
    }
}
