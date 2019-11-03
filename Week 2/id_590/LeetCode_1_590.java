package homework.week2;

import java.util.Arrays;
import java.util.HashMap;

//https://leetcode-cn.com/problems/two-sum/
public class LeetCode_1_590 {
    public int[] twoSum_1(int[] nums, int target) {
        //思路一,暴力法,两层循环,相当于组合,判断无重复的两个数是否加和是target,时间复杂度->O(n^2)
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public int[] twoSum_2(int[] nums, int target) {
        //思路二,将数组排序,然后夹逼找到相应的索引,时间复杂度->O(nlogn)
        int[] result = new int[2];

        //1.将nums进行克隆,对克隆的新数组进行排序
        int[] new_nums = nums.clone();
        Arrays.sort(new_nums);

        //2.对新数组进行夹逼操作
        for (int i = 0, j = new_nums.length - 1; j > i; ) {
            if (new_nums[i] + new_nums[j] > target) {
                //如果两个指针之和大于target,则后指针--
                j--;
            } else if (new_nums[i] + new_nums[j] < target) {
                //如果小于则前指针++
                i++;
            } else {
                //相等说明找到,则去nums查找相应两个数的索引,放入result
                if (new_nums[i] == new_nums[j]) {
                    //如果两个元素相同,则找第一和第二索引
                    result[0] = findIndex(nums, new_nums[i], false);
                    result[1] = findIndex(nums, new_nums[i], true);
                    break;
                } else {
                    result[0] = findIndex(nums, new_nums[i], false);
                    result[1] = findIndex(nums, new_nums[j], false);
                    break;
                }
            }
        }

        //3.返回结果
        return result;
    }

    private int findIndex(int[] nums, int target, boolean isEqual) {
        int result = 0;
        int count = 0;
        if (!isEqual) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    result = i;
                    break;
                }
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target && count == 0) {
                    count++;
                    continue;
                }
                if (nums[i] == target && count == 1) {
                    result = i;
                    break;
                }
            }
        }
        return result;
    }


    public int[] twoSum_3(int[] nums, int target) {
        //思路三,两次HashMap,时间复杂度-->O(n)
        int[] result = new int[2];
        //1.遍历nums,将nums存入HashMap(key为索引,value为值)
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }

        //2.再次遍历nums,看map的value中是否包含
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsValue(target - nums[i])) {
                result[index++] = i;
            }
            if (index > 1) {
                break;
            }
        }
        return result;
    }

    public int[] twoSum_4(int[] nums, int target) {
        //思路四,一次HashMap,时间复杂度-->O(n)
        //1.遍历nums,如果存在target-nums[i],则返回当前i和nums[i]的value,不然存入target-nums[i]及i的索引
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            } else {
                map.put(target - nums[i], i);
            }
        }
        return new int[2];
    }
}
