//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
//示例:
//
//输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/combinations
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


import java.util.ArrayList;
import java.util.List;

public class LeetCode_77_295 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        _generate(1, n, k, new ArrayList<Integer>(), res);
        return res;
    }

    private void _generate(int start, int n, int k, ArrayList<Integer> temp, List<List<Integer>> res) {
        // terminator
        if (k == temp.size()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        // process logic
        for (int i = start; i <= n - (k - temp.size()) + 1; i++) {
            temp.add(i);
            _generate(i + 1, n, k, temp, res);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        LeetCode_77_295 solution = new LeetCode_77_295();
        System.out.println(solution.combine(4, 2));
    }
}