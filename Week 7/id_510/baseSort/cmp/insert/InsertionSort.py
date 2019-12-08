def insertSort(arr):
    _len = len(arr)
    for j in range(1, _len):
        for i in range(j, 0, -1):
            if arr[i] < arr[i - 1]:
                arr[i], arr[i - 1] = arr[i - 1], arr[i]
            else:
                break
    return arr


a = [31, 42, 13, 54, 5]

print(insertSort(a))
