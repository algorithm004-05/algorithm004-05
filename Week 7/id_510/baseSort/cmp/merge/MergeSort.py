def mergeSort(arr):
    mergeSort1(arr, 0, len(arr) - 1)
    return arr


def mergeSort1(arr, left, right):
    if left < right:
        mid = left + ((right - left) >> 1)
        mergeSort1(arr, left, mid)
        mergeSort1(arr, mid + 1, right)
        merge(arr, left, mid, right)


def merge(arr, left, mid, right):
    temp = [0] * (right - left + 1)
    k, i, j = -1, left, mid + 1
    while i <= mid and j <= right:
        k += 1
        if arr[i] < arr[j]:
            temp[k] = arr[i]
            i += 1
        else:
            temp[k] = arr[j]
            j += 1
    while i <= mid:
        temp[k] = arr[i]
        k += 1
        i += 1
    while j <= right:
        temp[k] = arr[j]
        k += 1
        j += 1
    for i in range(len(temp)):
        arr[left + i] = temp[i]


a = [31, 42, 13, 54, 5]

print(mergeSort(a))
