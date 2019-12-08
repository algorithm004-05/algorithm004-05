package homework.week1;

//https://leetcode-cn.com/problems/rotate-array/
public class LeetCode_189_590 {
    public void rotate_1(int[] nums, int k) {
        //想法一:每次右移一步,迭代,迭代的终止条件是达到k值,时间复杂度O(nk)->时间复杂度比较高
        for (int i = 0; i < k; i++) {
            _oneStepToRight(nums);
        }
    }

    private void _oneStepToRight(int[] nums) {
        int temp = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; --i) {
            nums[i + 1] = nums[i];
        }
        nums[0] = temp;
    }


    public void rotate_2(int[] nums, int k) {
        //想法二:旋转,先中心旋转一次,然后根据k-1分成两半,两半分别按照中间进行旋转->时间复杂度O(n)

        //如果数组长度只有1,不用旋转
        if (nums.length == 1) {
            return;
        }

        //如果k的值和数组长度相等,相当于平移一轮后回来,依然什么都不用做(归纳~~)
        if (k == nums.length) {
            return;
        }
        //1.先按中间旋转一次
        _indexRotate(nums, 0, nums.length - 1);

        //2.按照k-1划分两半,分别按中间旋转
        _indexRotate(nums, 0, (k - 1) % nums.length);
        _indexRotate(nums, k % nums.length, nums.length - 1);
    }

    private void _indexRotate(int[] nums, int start, int end) {
        int temp = 0;
        int half = start + ((end - start) >>> 1);
        int j = end;
        for (int i = start; i <= half && j > i; i++) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j--] = temp;
        }
    }


    public void rotate_3(int[] nums, int k) {
        //解法三:不符合题目要求,需要重新开一个数组,平移相当于(原索引+k)%nums.length
        int[] clone = nums.clone();
        for (int i = 0; i < clone.length; i++) {
            nums[(i + k) % nums.length] = clone[i];
        }
    }
}
