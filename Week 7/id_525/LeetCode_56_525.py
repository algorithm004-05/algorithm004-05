class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: List[List[int]]
        """
        intervals.sort(key=lambda x: x[0])
        n = len(intervals)
        i = 0
        res = []
        while i < n:
            left = intervals[i][0]
            right = intervals[i][1]
            while i < n - 1 and intervals[i + 1][0] <= right:
                right = max(right, intervals[i + 1][1])
                i += 1
            res.append([left, right])
            i += 1
        return res

