#给你两个数组，arr1 和 arr2，
#
#
# arr2 中的元素各不相同
# arr2 中的每个元素都出现在 arr1 中
#
#
# 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
#
#
#
# 示例：
#
# 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
#输出：[2,2,2,1,4,3,3,9,6,7,19]
#
#
#
#
# 提示：
#
#
# arr1.length, arr2.length <= 1000
# 0 <= arr1[i], arr2[i] <= 1000
# arr2 中的元素 arr2[i] 各不相同
# arr2 中的每个元素 arr2[i] 都出现在 arr1 中
#
# Related Topics 排序 数组



#leetcode submit region begin(Prohibit modification and deletion)
from typing import List

class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        """ 缓存 """
        a = [0 for _ in range(max(arr1)+1)]
        for i in arr1:
            a[i] += 1

        rdata = []
        for j in arr2:
            rdata.extend([j for _ in range(a[j])])
            a[j] = 0


        for i, n in enumerate(a):
            if n != 0:
                rdata.extend([i for _ in range(n)])

        return rdata




#leetcode submit region end(Prohibit modification and deletion)
if __name__ == '__main__':
    s = Solution()
    arr1 = [2,3,1,3,2,4,6,7,9,2,19, 0, 8]
    arr2 = [2,1,4,3,9,6]

    print(s.relativeSortArray(arr1, arr2))