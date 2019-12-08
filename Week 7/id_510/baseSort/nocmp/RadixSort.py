"""
基数排序
div=1开始 然后div*=10递增  mod = div * 10
先获取余数%mod   然后获取商//div
"""


def radixSort(arr):
    # 将正负数 分开
    left, right = 0, len(arr) - 1
    while left < right:
        if arr[right] < 0:
            arr[left], arr[right] = -arr[right], arr[left]
            left += 1
        right -= 1

    radixSort1(arr, 0, left, maxLength(max(arr[0:left])))
    radixSort1(arr, left, len(arr), maxLength(max(arr[left:])))
    for i in range(((left + 1) >> 1)):
        arr[i], arr[left - 1 - i] = -arr[left - 1 - i], -arr[i]
    return arr


def radixSort1(arr, left, right, _maxLen):
    if left >= right: return
    i,div = 0, 1
    mod = div * 10
    while i <= _maxLen: # 从个位开始处理
        counter = [[] for _ in range(10)]
        for j in range(left, right):
            counter[(arr[j] % mod) // div].append(arr[j])
        index = left
        for j in range(len(counter)):
            for k in range(len(counter[j])):
                arr[index] = counter[j][k]
                index += 1
        i += 1

        div *= 10
        mod = div*10


def maxLength(value):
    if value < 0:
        value = -value
    _len = 0
    while value != 0:
        _len += 1
        value //= 10
    return _len


# print(maxLength(-8))
a = [2, 3, 9123, 4, 31, 121322, 13, -142432424, 153432, -5656,0,0, 7, 6, 46, 52, 41, 82, 4, 21, 431, 21212, 3, 23, 119]
print(a)
print(radixSort(a))
