//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 答案列
    List<List<Integer>> res = new ArrayList<>();
    // 每个单独组合
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length <= 0) return res;
        if (nums.length == 1){
            temp.add(nums[0]);
            res.add(temp);
            return res;
        }
        int[] v = new int[nums.length]; // 记录位置是否被使用 0 否, 1 是
        Arrays.sort(nums);// 排序, 避免重复值,但不重复位置
        recur(res, temp, nums, v); // 递归
        return res;
    }

    public void recur(List<List<Integer>> res,List<Integer> temp,int[] nums,int v[]){
        // 1. 函数的终结方式,避免死循环
        if (temp.size() == nums.length){
            res.add(new ArrayList<>(temp)); // 内存指针指向,这里需要new一个
            return;
        }
        // 2. 函数处理当前层
        for(int i = 0; i < nums.length; i++){
            if(v[i] != 1){  //如果改位置已被使用则直接跳过
                // 重复值是上一个值,且被使用过
                if (i > 0 && nums[i] == nums[i - 1] && v[i - 1] != 1){
                    continue;
                }
                temp.add(nums[i]);
                v[i] = 1;
                // 3. 重复调用自身
                recur(res, temp, nums, v); // 递归查找List的下一个位置
                // 4. 资源清理
                v[i] = 0; // 递归完成之后,设置为未使用
                temp.remove(temp.size() -1); // 清空
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
