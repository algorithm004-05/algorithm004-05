
class Solution:
    def rotate_1(self, nums, k) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        for i in range(k):
            tmp = nums[-1]
            for j in range(len(nums) - 1, 0, -1):
                nums[j] = nums[j-1]
            nums[0] = tmp

    def rotate_2(self, nums, k) -> None:
        length = len(nums)
        k %= length
        count = start = 0 #start 是最开始的点
        while count < length:
            target = start
            tmp = nums[start]
            while True:
                target = (target + k)%length
                tmp, nums[target] = nums[target], tmp
                count += 1
                if count > length or target == start:
                    break
            start += 1

    def rotate_3(self, nums, k) -> None:
        k %= len(nums)
        self.reverse(nums, 0, len(nums) - 1)
        self.reverse(nums, 0, k-1)
        self.reverse(nums, k, len(nums) - 1)
    def reverse(self, nums, start, end) -> None:
        while start < end:
            nums[start], nums[end] = nums[end], nums[start]
            start += 1
            end -= 1

    def rotate(self, nums, k) -> None:
        return self.rotate_3(nums, k)

if __name__ == '__main__':
    testCase = [1, 3, 4, 5, 6]
    k = 6
    print("Origin: ", testCase, " k:", k)
    solution = Solution()
    solution.rotate(testCase, k)
    print("Rotated: ", testCase)