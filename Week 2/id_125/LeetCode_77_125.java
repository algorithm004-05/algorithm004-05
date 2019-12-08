import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: 封玉书 FYS
 * @Date: 2019.10.27 13:43
 * @Description:
 */
public class A77 {

    public static void main(String[] args) {
        A77 a77 = new A77();
        System.out.println(a77.combine(4, 2));
    }

    private List<List<Integer>> res = new ArrayList<>();

    private List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n < k) {
            return res;
        }
        findCombinations(n, k, 1, new Stack<>());
        return res;
    }


    /**
     * 穷举法
     * 复杂度？：O(C(k,n))
     *
     * @param n     最大元素
     * @param k     总共取几个
     * @param begin 开始原色
     * @param pre   数据存放
     */
    private void findCombinations(int n, int k, int begin, Stack<Integer> pre) {

        // 1、终止条件，如果当获取元素到达目标时，终止
        if (pre.size() == k) {
            res.add(new ArrayList<>(pre));
            return;
        }

        // 穷举，取第一个元素时，剩下的按照for循环依次取出，如果有满足条件的，则放入栈，最后加入集合
        // 记住，return之后，这里的处理需要把最后一个元素pop出，继续循环，避免后面的元素没有获取
        // 还存在：如果数据已经到末尾了，但是需要取大于k个数字，那么就没有必要循环了，
        // 即：i + 还需要取的个数 - 1 > n
        for (int i = begin; i + (k - pre.size()) - 1 <= n; i++) {
            pre.push(i);
            findCombinations(n, k, i + 1, pre);
            pre.pop();
        }
    }


}
