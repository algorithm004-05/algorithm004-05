//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针

public class Leetcode_283_480 {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 3, 12};
        Solution2 solution = new Leetcode_283_480().new Solution2();
        solution.moveZeroes(arr);
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }


    /**
     * 暴力法，通过数组拷贝，将所有的0移到最后
     */
    class Solution {
        public void moveZeroes(int[] nums) {
            // 计算有n个0
            int countZero = 0;
            // 将非0按照顺序输出
            int index = 0;
            int[] arr = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    countZero++;
                } else {
                    arr[index] = nums[i];
                    index++;
                }
            }
            // int默认末尾是0 补全n个0到末尾
            for (int i = 0; i < nums.length; i++) {
                nums[i] = arr[i];
            }
        }
    }

    /**
     * 双指针法
     */
    class Solution2 {
        public void moveZeroes(int[] nums) {
            //通过指针i 表示当前需要插入的位置
            //通过指针j 查找下一个待移动的元素（非0)
            int i = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] != 0) {
                    nums[i] = nums[j];
                    i++;
                }
            }
            //移动完成，补0
            for (int l = i; l < nums.length; l++) {
                nums[l] = 0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}