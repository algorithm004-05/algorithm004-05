package com.neutorn.algorithm;

/**
 * 删除排序数组中的重复项
 *
 * @author zhanght
 */
public class LeetCode_26_315 {
    // 第一步:花上1分钟时间仔细审题,分析要实现的关键内容
    // 题目内容:给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
    // 题目内容:不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
    // 要点分析:给定排序的数字,在原地删除重复元素,使得每个元素出现一次,返回一出数组的新长度,不要使用额外数组空间,原地修改空间复杂读是O(1).
    // 可能存在的场景:两个相同的,三个相同的,多个相同的数据情况.
    // 第二步,可能的解法:
    // 1.是否存在暴力破解法 2.数组存在的特殊解法(左右遍历中间靠拢,哈希表处理,双指针处理)
    // 第三步:如果已经有思路,那么就开始进行编写代码 (第一步的各个解法时间复杂度分析不出来),如果没有思路,直接看其他人的处理方式
    // 暴力法没有想到,查看Leet Code中官方解决方案(双指针处理方案)

    public static int removeDuplicates(int[] nums) {
        // 思考0个,1个,多个数据情况的数据情况(是否1个包含在多个中呢)
        if (nums.length == 0) {
            return 0;
        }
        // 不需要单独处理1,因为fastIndex < nums.length把1的情况处理掉.
        // 如果fastIndex <= nums.length会出现问题,小于length,那么就可以从0开始.
        if (nums.length == 1) {
            return 1;
        }
        // 慢指针索引记录目标数组长度
        int slowIndex = 0;
        for (int fastIndex = 1; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != nums[slowIndex]) {
                // 快慢指针指向数据不相等,那么慢指针数据加一保存新的数据
                slowIndex++;
                nums[slowIndex] = nums[fastIndex];
            }
        }
        // 满指针是索引位置,数组长度需要加1
        return slowIndex + 1;
    }

    // 第四步,编写特殊的正常的测试案例,进行算法测试
    // [], [1], [1,1,1,2,3,3,4,5,5,5]
}
