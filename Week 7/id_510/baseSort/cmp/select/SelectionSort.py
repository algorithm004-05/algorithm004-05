def selectSort(arr):
    _len = len(arr)
    for i in range(_len):
        index = i  # 最小值索引
        for j in range(i, _len):
            if arr[index] > arr[j]:
                index = j
        arr[index], arr[i] = arr[i], arr[index]
    return arr


a = [31, 42, 13, 54, 5]

print(selectSort(a))
