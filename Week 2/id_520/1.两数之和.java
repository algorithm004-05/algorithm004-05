import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // //方法一，两重循环，枚举下标，如果下标对应的内容相加可以达成target，那么完成。
        // //这种方法时间复杂度较大，O(n^2)
        // int[] a = new int[2];
        // int numSize = nums.length;
        // for (int i = 0; i < numSize - 1; i++){
        //     for (int j = i + 1; j < numSize; j++){
        //         if (nums[i] + nums[j] == target){
        //             a[0] = i;
        //             a[1] = j;
        //             return a;
        //         }
        //     }
        // }
        // return new int[0];



        //第二种方法，利用哈希表先把内容存储起来，这样一来查找的过程只需要O(1)了
        //保持数组中的每个元素与其索引相互对应的最好方式是什么？哈希表
        //这个map中，key是nums元素的值，value是该元素的下标    

        //因为要找到a+b = target,所以  a = target - b， 所以查找 target-a 在不在数组里面
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++) {
            if(map.containsKey(target - nums[i])) {
                //key是元素的值，value是元素的下标
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}

