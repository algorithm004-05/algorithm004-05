/*
  56
  Given a collection of intervals, merge all overlapping intervals.

  Example 1:
    Input: [[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]

  Explanation:
    Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

  Example 2:
    Input: [[1,4],[4,5]]
    Output: [[1,5]]

  Explanation: Intervals [1,4] and [4,5] are considered overlapping.

  NOTE: 
    input types have been changed on April 15, 2019.
    Please reset to default code definition to get new method signature.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
  public int[][] merge(int[][] intervals) {
    if (intervals.length <= 1) {
      return intervals;
    }

    Arrays.sort(intervals, (p, q) -> Integer.compare(p[0], q[0]));

    List<int[]> result = new ArrayList<>();
    int[] newInterval = intervals[0];

    for (int[] interval : intervals) {
      if (interval[0] <= newInterval[1]) {
        newInterval[0] = Math.min(interval[0], newInterval[0]);
        newInterval[1] = Math.max(interval[1], newInterval[1]);
      } else {
        result.add(newInterval);
        newInterval = interval;
      }
    }

    result.add(newInterval);

    return result.toArray(new int[result.size()][]);
  }
}


