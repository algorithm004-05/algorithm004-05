def shellSort(arr):
    _len = len(arr)
    grap = _len
    while grap > 1:
        grap = grap // 2  # 间隔距离
        for i in range(grap, _len):
            j, curr = i, arr[i]
            while j >= grap and curr < arr[j - grap]:
                arr[j] = arr[j - grap]  # 比 curr大  则把前面大的值往后存放
                j -= grap  # 前移比较
            arr[j] = curr  # 找到位置 存放

    return arr


a = [31, 42, 13, 54, 5]

print(shellSort(a))
