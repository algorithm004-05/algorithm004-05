import java.lang.Math;

public class LeetCode_42_495 {

  public static void main(String[] args) {
    int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
    int water = trap(heights);
    System.out.println(water);
  }

  public static int trap(int[] height) {
    if (height.length < 3) {
      return 0;
    }
    int leftmax = height[0];
    int rightmax = height[height.length - 1];
    int water = 0;
    int left = 1;
    int right = height.length - 2;
    while (left <= right) {
      if (leftmax <= rightmax) {
        leftmax = Math.max(leftmax, height[left]);
        water +=  leftmax - height[left];
        left++;
      } else {
        rightmax = Math.max(rightmax, height[right]);
        water += rightmax - height[right];
        right--;
      }
    }
    return water;
  }
}
