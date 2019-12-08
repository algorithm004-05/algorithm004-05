## 合并区间

# class Solution:
#     # 快排
#     def quickSort(self, arr, begin, end):
#         def partition(arr, begin, end):
#             pivot, counter = end, begin
#             for i in range(begin, end):
#                 if arr[i][0] < arr[pivot][0]:
#                     arr[counter], arr[i] = arr[i], arr[counter]
#                     counter += 1
#             arr[pivot], arr[counter] = arr[counter], arr[pivot]
#             return counter
#         if end <= begin: return
#         pivot = partition(arr, begin, end)
#         self.quickSort(arr, begin, pivot-1)
#         self.quickSort(arr, pivot+1, end)

#     def merge(self, intervals: List[List[int]]) -> List[List[int]]:
#         if not intervals: return
#         self.quickSort(intervals, 0, len(intervals) - 1)
#         result = [intervals[0]]
#         for i in range(1, len(intervals)):
#             if result[-1][1] >= intervals[i][0]:
#                 result[-1][1] = max(intervals[i][1], result[-1][1])
#             else:
#                 result.append(intervals[i])

#         return result


class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if not intervals: return
        mergeInter = []
        sort_intervals = sorted(intervals)
        for inter in sort_intervals:
            if mergeInter and inter[0] <= mergeInter[-1][1]:
                mergeInter[-1][1] = max(mergeInter[-1][1], inter[1])
            else:
                mergeInter.append(inter)

        return mergeInter