package geektime.recursion;

import java.util.ArrayList;
import java.util.List;

public class Combine {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> outerList = new ArrayList<List<Integer>>();
        helper(1, n, k, outerList);
        return outerList;
    }

    public static void helper(int curr, int n, int k, List<List<Integer>> outerList) {
        if (curr > n - k + 1) {
            System.out.println(outerList.size());
            return;
        }
        List<Integer> innerList = new ArrayList<Integer>();
        int j = 1;
        while (j == 1 || (k >= 2 && curr + j + k - 2 <= n)) {
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
    }

    public static void main(String[] args) throws Exception{
        combine(2,1);
    }

}
