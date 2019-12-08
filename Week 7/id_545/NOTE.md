``` python
# 六种排序算法

## 排序
class SortSet:

    # 选择排序1
    def selectionSort(self, arr):
        '''选择排序：每次找最小值，然后放到待排序数组的起始位置'''
        for i in range(len(arr)):
            _minIndex = i
            for j in range(i, len(arr)):
                if arr[_minIndex] > arr[j]:
                    _minIndex = j
            arr[i], arr[_minIndex] = arr[_minIndex], arr[i]
        return arr

    # 选择排序2
    def selectionSort2(self, arr):
        for i in range(len(arr)):
            for j in range(i, len(arr)):
                if arr[i] > arr[j]:
                    arr[i], arr[j] = arr[j], arr[i]
        return arr

    # 插入排序
    def insertionSort(self, arr):
        '''插入排序：从前到后逐步构建有序序列；对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入'''
        for i in range(1, len(arr)):
            preIndex, current = i - 1, arr[i]
            while preIndex >= 0 and arr[preIndex] > current:
                arr[preIndex + 1] = arr[preIndex]
                preIndex -= 1

            arr[preIndex + 1] = current
        return arr

    # 冒泡排序
    def bubbleSort(self, arr):
        '''嵌套循环，每次查看相邻的元素如果逆序，则交换'''
        for i in range(len(arr)):
            for j in range(len(arr) - 1 - i):
                if arr[j] > arr[j+1]:
                    arr[j], arr[j+1] = arr[j+1], arr[j]
        return arr

    # 快速排序
    def quickSort(self, arr, begin, end):
        '''数组取标杆pivot，将小元素放pivot左边，大元素放右边，然后依次对右边和右边的子数组继续快排，以达到整个序列有序'''
        def partition(arr, begin, end):
            pivot, counter = end, begin
            for i in range(begin, end):
                if arr[i] < arr[pivot]:
                    arr[counter], arr[i] = arr[i], arr[counter]
                    counter += 1
            arr[pivot], arr[counter] = arr[counter], arr[pivot]
            return counter

        if end <= begin: return
        pivot = partition(arr, begin, end)
        self.quickSort(arr, begin, pivot - 1)
        self.quickSort(arr, pivot + 1, end)
        return arr

    # 归并排序
    def mergeSort(self, arr, left, right):
        '''
        1.把长度为n的输入序列分成两个长度为n/2的子序列
        2.对这两个子序列分别采用归并排序
        3.将两个排序好的子序列合并成一个最终的排序序列
        '''
        def merge(arr, left, mid, right):
            temp, i, j = [], left, mid + 1
            while i<= mid and j <= right:
                if arr[i] <= arr[j]:
                    temp.append(arr[i])
                    i += 1
                else:
                    temp.append(arr[j])
                    j += 1
            while i<= mid:
                temp.append(arr[i])
                i += 1
            while j<= right:
                temp.append(arr[j])
                j += 1
            
            for p in range(len(temp)):
                arr[left+p] = temp[p]
            
            return arr

        if right <= left: return
        mid = (left + right) >> 1
        self.mergeSort(arr, left, mid)
        self.mergeSort(arr, mid + 1, right)
        return merge(arr, left, mid, right)

    # 堆排序
    def heapSort(self, arr):
        '''
        1.数组元素依次建立小顶堆
        2.依次取堆顶元素，并删除
        '''
        from queue import PriorityQueue

        q = PriorityQueue()

        for i in range(len(arr)):
            q.put(arr[i])
        
        for j in range(q.qsize()):
            arr[j] = q.get()
        return arr


if __name__ == "__main__":
    s = SortSet()
    arr = [4,7,1,20,5,45,3,20,8,9,10,16]
    print('选择排序1:', s.selectionSort(arr))
    print('选择排序2:', s.selectionSort2(arr))
    print(' 插入排序:', s.insertionSort(arr))
    print(' 冒泡排序:', s.bubbleSort(arr))
    print(' 快速排序:', s.quickSort(arr, 0, len(arr) - 1))
    print(' 归并排序:', s.mergeSort(arr, 0, len(arr) - 1))
    print('   堆排序:', s.heapSort(arr))
```