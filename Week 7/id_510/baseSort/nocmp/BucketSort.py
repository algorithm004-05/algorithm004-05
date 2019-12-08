from week7.baseSort.cmp.insert.InsertionSort import insertSort

"""
桶排序
通过最大值最小值以及桶默认大小 计算需要的桶个数
遍历每个桶  对每个桶进行插入排序
遍历桶将数据按顺序保存到原始数组
"""
def bucketSort(arr):
    _max = max(arr)
    _min = min(arr)
    _len = len(arr)
    _pox = 2
    _size = ((_max - _min) >> _pox) + 1  # 默认每个桶存放2**_pox个数据  则计算需要的桶个数
    buckets = [[] for _ in range(_size)]
    for v in arr:
        index = (v - _min)>>_pox
        buckets[index].append(v)

    arr = []
    for i in range(_size):
        insertSort(buckets[i])
        for j in range(len(buckets[i])):
            arr.append(buckets[i][j])
    return arr



a = [2,3,9,4,1,2,3,4,5,6,7,6,6,5,4,8,4,1,4,2,3,3,9]
print(a)
print(bucketSort(a))