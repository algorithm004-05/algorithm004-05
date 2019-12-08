package xyz.isok.algorithm.leetcode.easy;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/two-sum/
 */
public class No1TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer key = nums[i];
            List<Integer> list = map.get(key);
            if (list != null) {
                list.add(i);
            }else {
                list = new ArrayList<>();
                list.add(i);
                map.put(key, list);
            }
        }
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            Integer matchKey = target - key;
            if (map.containsKey(matchKey)){
                List<Integer> list = map.get(key);
                result[0] = list.get(0);
                list = map.get(matchKey);
                result[1] = list.get(list.size()-1);
                Arrays.sort(result);
                break;
            }
        }
        return result;
    }
}
