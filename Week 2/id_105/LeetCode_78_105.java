package id_105;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_78_105 {


    public static List<List<Integer>> enumerate(int[] nums) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (nums == null || nums.length == 0) return res;

        res.add(new ArrayList<>());
        for (int num : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> list = new ArrayList<>(res.get(i));
                list.add(num);
                res.add(list);
            }
        }
        return res;
    }

    static List<List<Integer>> mres = new ArrayList<List<Integer>>();


    static {
        mres.add(new ArrayList<>());
    }

    public static List<List<Integer>> recursion(int level, int[] nums) {
        //terminator
        if (level == nums.length) {
            return mres;
        }
        //process.

        int size = mres.size();
        for (int i = 0; i < size; i++) {
            ArrayList<Integer> list = new ArrayList<>(mres.get(i));
            list.add(nums[level]);
            mres.add(list);
        }

        //drill down.
        recursion(level + 1, nums);

        return mres;
        //reverse status.
    }


    public static void preOrder(int[] nums, int i, ArrayList<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) return;
        subset = new ArrayList<>(subset);

        res.add(subset);
        preOrder(nums, i + 1, subset, res);
        subset.add(nums[i]);
        preOrder(nums, i + 1, subset, res);

    }


    public static void inOrder(int level, int[] nums, ArrayList<Integer> subSet, List<List<Integer>> res) {
        if (level >= nums.length) return;

        subSet = new ArrayList<>(subSet);

        inOrder(level + 1, nums, subSet, res);
        res.add(subSet);
        subSet.add(nums[level]);
        inOrder(level + 1, nums, subSet, res);
    }

    public static void postOrder(int level, int[] nums, ArrayList<Integer> subSet, List<List<Integer>> res) {
        if (level >= nums.length) return;

        subSet = new ArrayList<>(subSet);

        postOrder(level + 1, nums, subSet, res);
        subSet.add(nums[level]);
        postOrder(level + 1, nums, subSet, res);

        res.add(subSet);
    }

    public static void main(String[] args) {


//        print(enumerate(new int[]{}));
//        print(enumerate(null));
//        print(enumerate(new int[]{1}));
//        print(enumerate(new int[]{1, 2, 3, 4, 5, 6}));
//
//
//        print(recursion(0,new int[]{}));
//        print(recursion(0,null));
//        print(recursion(0,new int[]{1}));
//        print(enumerate(new int[]{1, 2, 3}));
//        System.out.println("=============================");
//        print(recursion(0, new int[]{1, 2, 3}));

        System.out.println("=============================");
//        preOrder(new int[]{1, 2, 3}, 0, new ArrayList<>(), mres);
        postOrder(0, new int[]{1, 2, 3}, new ArrayList<>(), mres);
        print(mres);

    }

    public static void print(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.printf("%d  ", integer);
            }
            System.out.println();
        }
    }

}
