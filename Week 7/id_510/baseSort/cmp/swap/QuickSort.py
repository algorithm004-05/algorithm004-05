"""
找一个临界点
分成2个部分  一部分大于临界点 一部分小于临界点
递归
"""
def quickSort(arr):
    quickSort1(arr, 0, len(arr) - 1)
    return arr


def quickSort1(arr, left, right):
    if left < right:
        pivot = partition(arr, left, right)
        quickSort1(arr, left, pivot - 1)
        quickSort1(arr, pivot + 1, right)


def partition(arr, left, right):
    _len = len(arr)
    pivot = right
    index = left
    for i in range(left, right):
        if arr[i] < arr[pivot]:
            arr[index], arr[i] = arr[i], arr[index]
            index += 1
    arr[index], arr[right] = arr[right], arr[index]
    return index


a = [31, 42, 13, 54, 5]

print(quickSort(a))
