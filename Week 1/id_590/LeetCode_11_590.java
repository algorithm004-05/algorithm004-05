package homework.week1;

//https://leetcode-cn.com/problems/container-with-most-water/
public class LeetCode_11_590 {
    public int maxArea_1(int[] height) {
        //想法一:暴力破解
        //1.遍历height的索引(0-length-2),不断计算其面积,维护一个最大面积变量,时间复杂度是O(n2)
        int max_area = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                if (area > max_area) {
                    max_area = area;
                }
            }
        }
        return max_area;
    }

    public int maxArea_2(int[] height) {
        //想法二:夹逼法
        //1.维护一个最大面积的变量,用两个指针分别指向头和尾进行夹逼
        int max_area = 0;
        int j = height.length - 1;
        for (int i = 0; i < height.length - 1 && j > i; ) {
            int area = 0;
            if (height[i] <= height[j]) {
                area = (j - i) * Math.min(height[i++], height[j]);
            } else {
                area = (j - i) * Math.min(height[i], height[j--]);
            }

            if (area > max_area) {
                max_area = area;
            }
        }

        return max_area;
    }
}
