# NOTE
## 一、分析算法题：
### 1.了快慢双指针法，快指针先行，慢指针根据不同的条件向前走。
###### 移动零：判断两个指针指向的位置，如果快指针指向一个非零元素，将值赋值给慢指针指向的位置，之后更新慢指针的位置。其中还要判断快慢指针是否重叠，“否”的话将快指针指向的位置元素置为0。
###### 删除数组中的重复项：也是一个快慢指针，判断快慢指针指向的位置元素是否不同，如果相同慢指针不变，快指针继续往下走，否则先更新慢指针的位置，将慢指针指向的新位置赋值为快指针指向的位置的元素。
###### 三数之和：首先将数组进行一次排序。然后开始进行for循环，每个循环位置记为“i”，使用两个指针一个为left=i+1，另一个从头的位置，即为right=nums.length-1。然后在开启一个内层循环，两个指针从两侧往中间进行靠拢，每次计算nums[i]+nums[left]+nums[right]的值，为s。当s小于0的时候，说明left位置的元素过小，将left位置进行加一更新。如果大于0，说明right的位置元素过大，将right位置进行减一更新。如果相等则将一组nums[i],nums[left],nums[right]加入到结果中，并同时更新left和right的位置。这里需要注意，加入到结果中时，需要去除重复元素。
### 2.求模运算：
###### 旋转数组：所谓旋转k个元素，其实就是旋转k%n个元素，将原数组后面的k%n个元素放到前面，也就是n-k%n个前面元素之前。先将数组进行翻转，然后在翻转前k%n个，之后将剩余的n-k%n个元素进行翻转。这道题充分的利用了求模运算。
## 二、数据结构设计
### 1.设计一个双端队列：
###### 使用双向链表来实现一个双端队列，实现了从头，尾两端插入删除。这里面需要注意的是，插入和删除的时候，需要进行一个前后节点的指针的更新，容易出错。代码具体实现见 LeetCode_641_525.py。
### 2.分析优先级队列
###### 优先级队列，也就是堆，是一种二叉树数据结构。因为堆是一个完全二叉树，所以可以使用一个数组来进行实现。
### python源码分析：
###### 是用数组来实现的已index 0为起点。计算父亲节点的公式为：index-1/2 ，左孩子：index*2 + 1，右孩子：index*2+2。
#### 接口：
###### heappush：向堆中加入一个元素。在结尾添加，并进行父亲节点的下浮操作。
###### heappop：取出堆顶元素。首先将堆尾元素与堆顶元素进行交换，然后删除并返回新的堆尾元素。之后将进行siftup操作。siftup里面还包括了sitdown操作。将孩子节点进行上浮，将父亲节点进行下沉操作。
###### heapify：将从数组一半的位置开始，进行sifup操作。
###### heapreplace：删除并返回堆顶元素，并向堆中添加一个元素。这个操作类似于删除，只不过在删除的时候向其中在添加一个元素
###### 学习编程我认为最重要的是自己动手实现，所以我实现了一个堆，代码如下：
```python
import random


class MaxHeap(object):
    def __init__(self):
        self.array = []

    def __len__(self):
        return len(self.array)

    def __getitem__(self, index):
        return self.array[index]

    def is_empty(self):
        return len(self) == 0

    def left(self, index):
        return index * 2 + 1

    def right(self, index):
        return index * 2 + 2

    def parent(self, index):
        if index < 1:
            raise IndexError
        return (index - 1) // 2

    def add(self, e):
        self.array.append(e)
        self.sift_up(len(self)-1)

    def peek(self):
        return self.array[0]

    def sift_down(self, index):
        '''
        下沉
        :param index:
        :return:
        '''
        while self.left(index) < len(self):
            j = self.left(index)
            if j + 1 < len(self) and self.array[j+1] > self.array[j]:
                j += 1
            if self.array[index] > self.array[j]:
                break
            else:
                self.swap(index, j)
                index = j

    def sift_up(self, index):
        '''
        上浮
        :param index:
        :return:
        '''
        while index > 0 and self.array[self.parent(index)] < self.array[index]:
            parent = self.parent(index)
            self.swap(index, parent)
            index = parent

    def swap(self, a, b):
        if a < 0 or a >= len(self) or b < 0 or b >= len(self):
            raise IndexError
        self.array[a], self.array[b] = self.array[b], self.array[a]

    def extract_max(self):
        '''
        删除堆顶元素并返回
        为了保持完全二叉树的特性，删除时将堆顶元素与堆底元素进行交换。
        然后对新的堆顶元素进行下沉操作，删除堆底元素。
        :return:
        '''
        max_value = self.peek()
        self.swap(0, len(self)-1)
        self.array.pop()
        self.sift_down(0)
        return max_value

    def heapify(self, array):
        '''
        从第一个非叶子节点进行,依次往前遍历对每一个节点进行下沉操作。
        :param array:
        :return:
        '''
        if not array: return array
        self.array = array[:]
        index = self.parent(len(self)-1)
        while index >= 0:
            self.sift_down(index)
            index -= 1

    def replace(self, e):
        '''
        替换堆顶元素
        :param e:
        :return:
        '''
        max_value = self.array[0]
        self.array[0] = e
        self.sift_down(0)
        return max_value


if __name__ == '__main__':

    def test(n):

        heap = MaxHeap()
        a = []
        for i in range(n):
            heap.add(random.randint(0, n))
        for i in range(n):
            a.append(heap.extract_max())
        for i in range(1, len(a)):
            assert a[i - 1] >= a[i], '结果错误'
        print('test success')


    def test_heap(n):

        array = []
        for i in range(n):
            array.append(random.randint(0, n))
        heap = MaxHeap()
        heap.heapify(array)
        a = []
        for i in range(n):
            a.append(heap.extract_max())
        for i in range(1, len(a)):
            assert a[i - 1] >= a[i], '结果错误'
        print('test heapify success')

    test(100)
    test_heap(100)
```
## 三、作业点评
