package com.geek.lee.leetcode.easy;

public class MoveZeroes283 {
    public void moveZeroes(int[] nums) {

        /**
         * 看到题后,自己从纸上分析后写出此解法
         * 思路:
         *  1.定义一个0的位置游标, 定为-1,如果为-1, 表示未遇到为0的元素.当遇到第一个0时, 将游标更新为0所在的数组下标
         *  2.当元素不为0, 并且该元素前面有0,则进行替换. 如何判断当前元素前面的元素有0, 游标位置>0(不是-1了)
         *  3.对两个位置的元素进行替换, 替换后将游标位置+1. (为什么+1而不是设置到最后一次替换元素的下标位置. 此处为了防止当前0位置后续还是0.)
         *
         */
        // 记录数组0的游标
//        int cur = -1;
//        for (int i = 0; i < nums.length; i ++) {
//            if (nums[i] != 0 && cur >= 0) {
//                nums[cur] = nums[i];
//                nums[i] = 0;
//                cur += 1;
//            }
//            if (nums[i] == 0 && cur < 0) {
//                cur = i;
//            }
//        }

        /**
         * 双指针解法.
         * 该解法与上面自行分析的方法类似.不过从代码上更简洁,更优于上面的解法.
         * 用了一个更巧妙的判断来优化了上面复杂的判断.当遇到元素非0时,并且非0元素位置和游标位置不等,才进行移动.
         * 当元素是0,继续遍历即可
         * 此方法相当于上面方法的优化.
         *
         */
//        int j = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != 0) {
//                if(i!=j) {
//                    nums[j] = nums[i];
//                    nums[i] = 0;
//                }
//                j++;
//            }
//        }

        /**
         * 两次遍历法
         * 思路:
         *  第一次遍历计算出数组中非0元素个数
         *  第二次遍历根据第一次遍历计算出的0的个数,遍历将0填充到后续的数组元素位置上
         */
        int index = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index ++;
            }
        }

        for (int i = index; i < nums.length; i ++) {
            nums[i] = 0;
        }

    }

    public static void main(String[] args) {
        new MoveZeroes283().moveZeroes(new int[] {1, 0, 1, 0, 0, 2, 3, 4, 0});
    }
}
