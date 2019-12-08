
import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3] 输出: [ [3],   [1],   [2],   [1,2,3],   [1,3],   [2,3],  
 * [1,2],   [] ]
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_78_510 {

    public static void main(String[] args) {
        System.out.println(new LeetCode_78_510().subsets1(new int[] { 1, 2, 3}));
    }

    /**
     * 位掩码
     * 
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int size = nums.length;
        int length = 1 << size;
        /**
         * 每一位有2个状态 0，1 1代表选中
         */
        for (int i = 0; i < length; i++) {
            List<Integer> list1 = new ArrayList<>();
            // 位移数组长度 判断每一位的值 为1则被选中添加
            for (int j = 0; j < size; j++) {
                // 1 向左移动 判断对应位置是否为1
                /**
                 System.out.println((1 & (i >>j)) +"==="+(i & (1 << j)));
                if ((i & (1 << j)) == (1 << j)) {
                    list1.add(nums[j]);
                }
                 */
 
                if ((1 & (i >> j)) == 1) {
                    list1.add(nums[j]);
                }
            }
            list.add(list1);
        }
        return list;
    }

    public List<List<Integer>> subsets(int[] nums) {
        return dfs(nums, 0);
    }

    private List<List<Integer>> dfs(int[] nums, int d) {
        // 空元素时 子集只有空
        if (d == nums.length) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> list1 = new ArrayList<>();
            list.add(list1);
            return list;
        }

        /**
         * 1:在前一个集合的子集基础上 每个子集都加上当前元素， 2:和前一个集合合并
         */
        List<List<Integer>> list = dfs(nums, d + 1);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            List<Integer> list2 = new ArrayList<>();
            list2.addAll(list.get(i));
            list2.add(nums[d]);
            list.add(list2);
        }
        return list;
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs2(nums, 0, temp, list);
        return list;
    }

    /**
     * 回溯
     * 
     * @param nums
     * @return
     */
    private void dfs2(int[] nums, int d, List<Integer> temp, List<List<Integer>> res) {
        res.add(new ArrayList<>(temp)); // 将前一组集合添加
        for (int i = d; i < nums.length; i++) {
            // 选中自己处理
            temp.add(nums[i]); // 当作当前层集合处理
            // 进入下层 注意进入下一层的索引
            dfs2(nums, i + 1, temp, res);
            // 不选中自己处理 回溯
            temp.remove(temp.size() - 1);
        }
    }

    /**
     * 回溯
     * 
     * @param nums
     * @return
     */
    private void dfs3(int[] nums, int d, List<Integer> temp, List<List<Integer>> res) {
        res.add(new ArrayList<>(temp)); // 将前一组集合添加
        for (int i = d; i < nums.length; i++) {
            // 选中自己处理
            temp.add(nums[i]); // 当作当前层集合处理
            // 进入下层 注意进入下一层的索引
            dfs2(nums, i + 1, temp, res);
            // 不选中自己处理 回溯
            temp.remove(temp.size() - 1);
        }
    }
}
