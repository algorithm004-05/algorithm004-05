package geektime.recursion;

import java.util.ArrayList;
import java.util.List;

public class Combine {
    /*public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> outerList = new ArrayList<List<Integer>>();
        List<Integer> innerList = new ArrayList<Integer>();
        helper(1, n, k, innerList, outerList);
        return outerList;
    }

    public static void helper(int curr, int n, int k, List<List<Integer>> outerList) {
        if (curr > n - k + 1) {
            System.out.println(outerList.size());
            return;
        }
        List<Integer> innerList = new ArrayList<Integer>();
        int j = 1;
        while ((k == 1 && j == 1) || (k >= 2 && curr + j + k - 2 <= n)) {
            System.out.println(curr);
            innerList.add(curr);
            for (int i = 0; i < k - 1; i++) {
                innerList.add(curr + j + i);
            }
            outerList.add(innerList);
            innerList = new ArrayList<Integer>();
            j++;
        }
        curr++;
        if (curr <= n - k + 1) {
            helper(curr, n, k, outerList);
        }
    }*/

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> outerList = new ArrayList<List<Integer>>();
        if (n < 0 || k < 0 || n < k) {
            return outerList;
        }
        List<Integer> innerList = new ArrayList<Integer>();
        helper(1, n, k, innerList, outerList);
        return outerList;
    }

    public static void helper(int index, int n, int k, List<Integer> innerList, List<List<Integer>> outerList) {
        //First:terminator(从下一层返回上一层的判断和返回前应该做什么)
        if (innerList.size() == k) {
            List<Integer> innerListTemp = new ArrayList<Integer>();
            for (Integer itg : innerList) {
                innerListTemp.add(itg);
            }
            outerList.add(innerListTemp);
            return;
        }

        if (index <= n) {
            //second:process currnet logic(编写当前层逻辑，即问题处理重复性部分逻辑)

            //third:drill down(在当前层调用自己，即返回递归方法的执行起点，进入下一层执行)
            helper(index+1, n, k, innerList, outerList);
            //second:process currnet logic(编写当前层逻辑，即问题处理重复性部分逻辑)
            innerList.add(index);
            //third:drill down(在当前层调用自己，即返回递归方法的执行起点，进入下一层执行)
            helper(index+1, n, k, innerList, outerList);
            //fourth:reverse status(本层执行完后，返回上一层，
            //由于innerList是上一层里面当成参数传入到了本层，
            //同时innerList是当前层重复性逻辑部分的处理对象结果体现,
            // 该对象返回调用点后，在上一层的后续处理必须在是调用前的状态，
            //所以当返回每一层时，必须做当前层变化的还原处理，
            //不同于index层级参数和outerList这些问题处理结果的封装对象参数。
            innerList.remove(innerList.size() - 1);
        }

    }
}
