package homework.week1;

import java.util.Arrays;
import java.util.HashMap;

//https://leetcode-cn.com/problems/two-sum/
public class LeetCode_1_590 {
    public int[] twoSum_1(int[] nums, int target) {
        //解法一:暴力法
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public int[] twoSum_2(int[] nums, int target) {
        //解法二:使用HashMap
        //1.遍历nums,每次从map中查询是否有该元素,如果有返回map中的value及该索引,如果没有,则把target-该数和索引存入map->时间复杂度O(n)
        int[] result = new int[2];
        HashMap<Integer, Integer> dic = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (dic.containsKey(nums[i])) {
                result[0] = dic.get(nums[i]);
                result[1] = i;
            } else {
                dic.put(target - nums[i], i);
            }
        }
        return result;
    }

    public int[] twoSum_3(int[] nums, int target) {
        //解法三:将数组排序,然后夹逼 时间复杂度,O(nlogn)+O(n)->O(nlogn)
        int[] result = new int[2];
        int[] clone = nums.clone();
        Arrays.sort(clone);
        int j = clone.length - 1;
        for (int i = 0; i < clone.length -1 && j > i; ) {
            if ((clone[i]+clone[j])>target){
                j--;
            }else if ((clone[i]+clone[j])<target){
                i++;
            }else{
                int count =0;
                for (int z = 0; z < nums.length; z++) {
                    if (clone[i] == clone[j]){
                        if (nums[z]==clone[i]&&count==0){
                            result[0]=z;
                            count++;
                        }else if (nums[z] == clone[j]){
                            result[1]=z;
                        }
                    }else{
                        if (nums[z]==clone[i]){
                            result[0]=z;
                        }else if (nums[z] == clone[j]){
                            result[1]=z;
                        }
                    }
                }
                break;
            }
        }
        return result;
    }
}
