def heapSort(arr):
    _len = len(arr)
    buildMaxHeap(arr, _len)
    for i in range(len(arr) - 1, 0, -1):
        arr[0], arr[i] = arr[i], arr[0] #将堆顶数据放到最后一个   类似与冒泡排序
        _len -= 1
        heapify(arr, 0, _len) #
    return arr

"""
构建大（小）顶堆  完全二叉树
"""
def buildMaxHeap(arr, _len): #类似选择排序
    for i in range(_len // 2, -1, -1): #倒叙 将最大（小）值 放到父节点 直到根节点 获取最大值
        heapify(arr, i, _len)  #左右子树都是大顶堆了

"""
堆调整
"""
def heapify(arr, i, _len):
    index = i
    left = 2 * index + 1
    right = 2 * index + 2
    if left < _len and arr[left] > arr[index]:
        index = left
    if right < _len and arr[right] > arr[index]:
        index = right
    if i != index:
        arr[i], arr[index] = arr[index], arr[i]
        heapify(arr, index, _len)


a = [31, 42, 13, 54, 5]

print(heapSort(a))
