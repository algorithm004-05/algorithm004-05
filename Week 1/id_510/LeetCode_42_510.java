package algorithm00405test.week1.job.done;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_42_510 {

    public static void main(String[] args) {
        int[] aa = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        new LeetCode_42_510().trap(aa);
    }

    public int trap(int[] height) {
        if (null == height || 0 == height.length){
            return 0;
        }
        int area = 0;
        int left = 0; // 左边界
        int next = left;
        int right = height.length - 1; // 右边界
        int pre = right;

        while (left < right) {
            next = left + 1;
            while (left < right && next < right) {
                // 1:从左边找next值小于了left值
                if (height[left] <= height[next] || height[left] == 0) {
                    left++;
                    next++;
                    continue;
                }
                break;
            }
            //  next向后遍历 寻找大于等于left的值计算面积 找不到 则向下执行 从右向左找
            int areatemp = 0;
            while (next <= right) {
                if (height[left] <= height[next]) {
                    area += areatemp;
                    left = next;
                    break;
                } else {
                    areatemp += height[left] - height[next];
                }
                next++;
            }

            pre = right - 1;
            // 从右边找pre值小于了right值
            while (right > left && pre > left) {
                if (height[right] <= height[pre] || height[right] == 0) {
                    right--;
                    pre--;
                    continue;
                }
                break;
            }

            //  pre向前遍历 寻找大于等于right值计算面积 找不到 则执行下一轮循环 然后从左向右找
            areatemp = 0;
            while (pre >= left) {
                if (height[right] <= height[pre]) {
                    area += areatemp;
                    right = pre;
                    break;
                } else {
                    areatemp += height[right] - height[pre];
                }
                pre--;
            }

        }
        return area;
    }

    public int trap1(int[] height) {
        if (null == height || 0 == height.length){
            return 0;
        }
        int area = 0;
        int left = 0; // 左边界
        int right = height.length - 1; // 右边界
        int left_max = height[left];
        int right_max = height[right];
        while (left <= right) {
            // 左边低于右边 则从左边开始计算
            if (left_max <= right_max){
                // 没有高于左边最大值 则可以蓄水
                if (left_max >= height[left]){
                    area += (left_max - height[left]);
                } else {
                    left_max = height[left];
                }
                left++;
            } else {
                // 从右边开始计算
                // 没有高于右边最大值 则可以蓄水
                if (right_max >= height[right]){
                    area += (right_max -height[right]) ;
                } else {
                    right_max  = height[right];
                }
                right--;
            }
        }
        return area;
    }
}
