package example;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

import static java.lang.Math.*;

public class trappingRainWater {

    public static int solution(int[] height) {
        Deque<Integer> deque = new LinkedList<Integer>();
        int capacity = 0;
        int heightDifference;
        for (int i = 0; i < height.length; i++) {
            if (deque.size() == 0 || (height[i] <= height[deque.getFirst()])) {
                deque.addFirst(i);
            }
            int minHeight = 0;
            //在数据高度处于上升趋势，则开始出栈内数据，分成多阶段出，以每阶段第一个出栈的高度为标准，连续将高度相同的一次性出完
            //每阶段根据边界的高度最小值、第一个出栈的高度以及边界下标计算面积，直到将所有栈内比当前到的最右边高度小的数据都出栈
             while (deque.size() > 0 && (height[deque.getFirst()] < height[i])) {
                 minHeight = height[deque.getFirst()];
                 deque.pollFirst();
                while (deque.size() > 0 && minHeight == height[deque.getFirst()]){
                    deque.pollFirst();
                }
                heightDifference = 0;
                if (deque.size() > 0) {
                    heightDifference = Math.min(height[i],height[deque.getFirst()]) - minHeight;
                }
                if (heightDifference > 0) {
                    capacity += (i - 1 - deque.getFirst()) * heightDifference;
                    System.out.println("capacity:" + capacity + "  i:" + i + "  heightDifference:" + heightDifference + "  deque.first:" + deque.getFirst());
                }
            }
            deque.addFirst(i);
        }
        return capacity;
  }

//多重最近相关性的问题也可以使用栈
  public static void main(String[] arg) throws Exception {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        solution(height);

  }

}
