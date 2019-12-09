//给出一个区间的集合，请合并所有重叠的区间。 
//
// 示例 1: 
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
// Related Topics 排序 数组


import java.util.ArrayList;
import java.util.Collections;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class Interval {
        public int start;
        public int end;
        public Interval (int[] nums) {
            this.start = nums[0];
            this.end = nums[1];
        }
    }
    class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare (Interval a, Interval b) {
            return Integer.compare(a.start, b.start);
        }
    }
    public int[][] merge(int[][] intervals) {
        List<Interval> list = new ArrayList<Interval>();
        for (int[] nums : intervals) {
            list.add(new Interval(nums));
        }
        Collections.sort(list, new IntervalComparator());
        List<Interval> merged = new ArrayList<Interval>();
        for (Interval interval : list) {
            if (merged.isEmpty() || merged.get(merged.size() - 1).end < interval.start) {
                merged.add(interval);
            } else {
                merged.get(merged.size() - 1).end = Math.max(merged.get(merged.size() - 1).end, interval.end);
            }
        }
        int[][] result = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); i++) {
            result[i][0] = merged.get(i).start;
            result[i][1] = merged.get(i).end;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
