/*
  42
  Given n non-negative integers representing an elevation map
  where the width of each bar is 1,
  compute how much water it is able to trap after raining.

  The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
  In this case, 6 units of rain water (blue section) are being trapped.
  Thanks Marcos for contributing this image!

  Example:
    Input: [0,1,0,2,1,0,1,3,2,1,2,1]
    Output: 6
*/

import java.util.Stack;

public class TrappingRainWater {
  public int trap0(int[] height) {
    int res = 0;
    for (int i = 0; i < height.length - 1; i++) {
      int maxLeft = 0;
      for (int j = i - 1; j >= 0; j--) {
        if (height[j] > maxLeft) {
          maxLeft = height[j];
        }
      }

      int maxRight = 0;
      for (int j = i + 1; j < height.length; j++) {
        if (height[j] > maxRight) {
          maxRight = height[j];
        }
      }

      int minHeight = Math.min(maxLeft, maxRight);

      if (minHeight > height[i]) {
        res += (minHeight - height[i]);
      }
    }
    return res;
  }

  public int trap1(int[] height) {
    int maxHeight = _maxHeight(height);
    int res = 0;
    for (int standerHeight = 1; standerHeight <= maxHeight; standerHeight++) {
      boolean isStarted = false;
      int temp = 0;
      for (int currentHeight : height) {
        if (isStarted && currentHeight < standerHeight) {
          temp++;
        }

        if (currentHeight >= standerHeight) {
          isStarted = true;
          res += temp;
          temp = 0;
        }
      }
    }
    return res;
  }

  private int _maxHeight(int[] height) {
    int maxHeight = Integer.MIN_VALUE;
    for (int value : height) {
      maxHeight = Math.max(value, maxHeight);
    }
    return maxHeight;
  }

  public int trap2(int[] height) {
    int sum = 0;
    Stack<Integer> stack = new Stack<>();
    int current = 0;

    while (current < height.length) {
      while (!stack.empty() && height[current] > height[stack.peek()]) {
        int bottom = height[stack.pop()];
        if (stack.empty()) {
          break;
        }
        int right = current, left = stack.peek();
        int minHeight = Math.min(height[left], height[right]);
        int distance = right - left - 1;
        sum += distance * (minHeight - bottom);
      }
      stack.push(current);
      current++;
    }
    return sum;
  }
}
