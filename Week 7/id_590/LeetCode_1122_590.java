package homework.week7;

import java.util.*;

//https://leetcode-cn.com/problems/relative-sort-array/
public class LeetCode_1122_590 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr2.length == 0) {
            Arrays.sort(arr1);
            return arr1;
        }

        if (arr1.length == arr2.length) {
            return arr2;
        }
        int[] result = new int[arr1.length];
        HashMap<Integer, Integer> haven_dic = new HashMap();

        PriorityQueue<Integer> not_haven = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2 <= 0 ? -1 : 1;
            }
        });
        //初始化字典
        for (int j = 0; j < arr2.length; j++) {
            haven_dic.put(arr2[j], 0);
        }

        //遍历arr1,对于arr1的每个元素进行判断,如果字典中有该元素,字典统计+1,如果没有,放入not_haven中
        for (int i = 0; i < arr1.length; i++) {
            if (haven_dic.containsKey(arr1[i])) {
                haven_dic.put(arr1[i], haven_dic.get(arr1[i]) + 1);
            } else {
                not_haven.add(arr1[i]);
            }
        }

        //设置指针,遍历arr2,拿到字典中arr2中的每个数值,放入result中,最后从优先队列中取元素放入result中
        int index = 0;

        for (int i = 0; i < arr2.length; i++) {
            Integer count = haven_dic.get(arr2[i]);
            for (int p = index; p < index + count; p++) {
                result[p] = arr2[i];
            }
            index += count;
        }

        for (int m = index; m < result.length; m++) {
            result[m] = not_haven.poll();
        }
        return result;
    }
}
