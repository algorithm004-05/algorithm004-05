import java.util.ArrayList;
import java.util.List;

/**
 * created by lchen on 2019/10/25
 */
public class LeetCode_78_535 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> subsets = solution.subsets(nums);
        System.out.println(subsets);
    }

}

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> numsList = new ArrayList<>();
        numsList.add(new ArrayList<>());
        for (int num : nums) {
            int size = numsList.size();
            for (int i = 0; i < size; i++) {
                List<Integer> tmpList = new ArrayList<>();
                tmpList.add(num);
                tmpList.addAll(numsList.get(i));
                numsList.add(tmpList);
            }
        }
        return numsList;
    }

}
