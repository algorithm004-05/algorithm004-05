import java.util.Arrays;

public class RotateArray2 {
    //利用替换实现右移，时间复杂度为O(n)，空间复杂度为O(n)
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return;

        //实际移动步骤为k对nums长度取余
        int moveNum = k % nums.length;

        //位移为0则直接返回
        if (moveNum == 0) {
            return;
        }

        //设置初始位置和计数器
        int startIdx = 0, count = 0;

        int curIdx = startIdx, curTmp = nums[startIdx];
        do {
            //找到位移后的坐标targetIdx，并将对应值赋值给targetTmp进行缓存，为下一次替换做准备
            int targetIdx = curIdx + moveNum;
            if (targetIdx >= nums.length)
                targetIdx = targetIdx - nums.length;
            int targetTmp = nums[targetIdx];

            //然后将curTmp赋值给坐标targetIdx
            nums[targetIdx] = curTmp;

            //确定下次替换的curIdx坐标位置，以便下次循环用
            if (targetIdx == startIdx) {
                //如果目标位置和起始位置相同，说明出现了循环，需要从起点的下一个位置继续按照步长k进行遍历调整
                startIdx++;
                curIdx = startIdx;
                curTmp = nums[startIdx];
            } else {
                //如果目标位置和起始位置不相同，说明从当前startIdx出发，按照步长k，还未完成遍历
                //则可将targetTmp赋值给curTmp，同时将targetTdx赋值给curIdx
                curIdx = targetIdx;
                curTmp = targetTmp;
            }

            count++;
        } while (count < nums.length);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 2;
        new RotateArray2().rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
