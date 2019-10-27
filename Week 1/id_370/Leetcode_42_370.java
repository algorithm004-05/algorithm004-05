package id_370;

public class Leetcode_42_370 {
    public int trap(int[] height) {
	int i = 0;
	int j = height.length - 1;
	int sum = 0;
	int leftMax = 0;
	int rightMax = 0;

	while (i < j) {
	    if (height[i] < height[j]) {
		if ((height[i] >= leftMax)) {
		    leftMax = height[i];
		} else {
		    sum += leftMax - height[i];
		}
		i++;
	    } else {
		if (height[j] >= rightMax) {
		    rightMax = height[j];
		} else {
		    sum += rightMax - height[j];
		}
		j--;
	    }
	}
	return sum;

    }

}

