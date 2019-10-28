import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */

// @lc code=start
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    public void putElementToList(int n, int k ,int begin, Stack<Integer> stack){
        if(stack.size()==k){
            result.add(new ArrayList<>(stack));
            return;
        }
        for(int i = begin;i<= n;i++){
            stack.add(i);
            putElementToList(n, k, i +1, stack);
            stack.pop();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) {
            return result;
        }
        putElementToList(n, k, 1, new Stack<>());
        return result;
    }
}
// @lc code=end

