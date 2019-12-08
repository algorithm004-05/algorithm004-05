#!/anaconda3/bin/python

class LeetCode_88_495(object):
    """
    这个太骚了
    """

    @staticmethod
    def merge(nums1, m, nums2, n):
        while n > 0:
            if m <= 0 or nums2[n-1] >= nums1[m-1]:
                nums1[m+n-1] = nums2[n-1]
                n -= 1
            else:
                nums1[m+n-1] = nums1[m-1]
                m -= 1
        return nums1

if __name__ == '__main__':
    print(LeetCode_88_495.merge([1,2,3,4,5,0,0,0,0,0,0,0,],5,[0,2,12,32,33,55,66],7))
