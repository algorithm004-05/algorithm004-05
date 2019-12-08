class Solution(object):
    def relativeSortArray(self, arr1, arr2):
        """
        :type arr1: List[int]
        :type arr2: List[int]
        :rtype: List[int]
        """
        arr = [0 for _ in range(1001)]
        res = []
        for i in arr1:
            arr[i] +=1
        for i in arr2:
            while arr[i] > 0:
                res.append(i)
                arr[i] -=1
        for i in range(len(arr)):
            while arr[i] > 0:
                res.append(i)
                arr[i] -=1
        return res