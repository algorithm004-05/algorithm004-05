from typing import List


# 189.旋转数组
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k %= n
        # 利用了python切片的特性
        nums[:] = nums[::-1]
        nums[:k] = nums[:k][::-1]
        nums[k:] = nums[k:][::-1]

        print("方法1 : %s" % nums)

    # 从末尾开始移动到头
    def rotate2(self, nums: List[int], k: int) -> None:
        k %= len(nums)
        for i in range(k):
            nums.insert(0, nums[len(nums) - 1])
            nums.pop(len(nums) - 1)

        print("方法2 : %s" % nums)

    # 利用一个额外数组
    def rotate3(self, nums: List[int], k: int) -> None:
        tmp = list()
        nums_len = len(nums)
        for i in range(nums_len):
            tmp.insert((i + k) % nums_len, nums[i])
        for i in range(nums_len):
            nums[i] = tmp[i]

        print("方法3 : %s" % nums)


if __name__ == '__main__':
    s = Solution()
    b = [1, 2, 3, 4, 5, 6, 7, 8]
    k = 3
    # s.rotate(b, k)
    # s.rotate2(b, k)
    s.rotate3(b, k)

