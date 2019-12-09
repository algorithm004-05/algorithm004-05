class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        def return_first(lst):
            return lst[0]
        intervals.sort(key=return_first)
        n_intervals = len(intervals)
        if n_intervals == 0:
            return []
        res_lst = [intervals[0]]
        for i in range(1, n_intervals):
            lower = intervals[i][0]
            higher = intervals[i][1]
            if lower <= res_lst[-1][1]:
                res_lst[-1][1] = max(res_lst[-1][1], higher)
            else:
                res_lst.append(intervals[i])
        return res_lst