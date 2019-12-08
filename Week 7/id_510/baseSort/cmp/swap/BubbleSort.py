def bubbleSort(arr):
    _len = len(arr)
    for i in range(_len):
        for j in range(1, _len - i):
            if arr[j] < arr[j - 1]:
                arr[j], arr[j - 1] = arr[j - 1], arr[j]
    return arr


a = [31, 42, 13, 54, 5]

print(bubbleSort(a))
