
排序算法 | 是否基于比较 | 平均时间复杂度 | 最好时间复杂度 | 最坏时间复杂度 | 空间复杂度 | 是否原地排序 | 是否稳定
---|---|---|---|---|---|---|---
冒泡排序 | 是 | O(n^2) | O(n) | O(n^2) | O(1) | 是 | 是
插入排序 | 是 | O(n^2) | O(n) | O(n^2) | O(1) | 是 | 是 
选择排序 | 是 | O(n^2) | O(n^2) | O(n^2) | O(1) | 是 | 否
归并排序 | 是 | O(nlogn) | O(nlogn) | O(nlogn) | O(n) | 否 | 是
快速排序 | 是 | O(nlogn) | O(nlogn  ) | O(n^2) | O(1) | 是 | 否
计数排序 | 否 | O(n + k) | O(n + k) | O(n + k) | O(n + k) | 否 | 是
基数排序 | 否 | O(n*k) | O(n*k) | O(n*k) | O(n + k)  | 否 | 是
桶排序 | 否 | O(n + k) | O(n) | O(nlogn) | O(n + k)  | 否 | 是


为了故事的顺利发展，先定义一个 sqap 函数。

```java
public static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}
    
```

### 1. 冒泡排序

双层循环嵌套，每次对比相邻的两个元素，将大的元素交换到后面。

```java
public static void bubbleSort(int[] array) {
    int len = array.length;
    for (int i = 0; i < len - 1; i++) {
        for (int j = 0; j < len - i - 1; j++) {
            if (array[j] > array[j + 1]) { // swap array[j] and array[j+1]
                swap(array, j, j + 1);
            }
        }
    }
}
```
**算法分析：**

不需要额外额空间，所以属于原地排序。不会改变数据的先后顺序，所以是稳定的。


### 2. 插入排序

对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入即可。

```java
public static void insertionSort(int[] array) {
    int len = array.length;
    for (int i = 1; i < len; i++) {
        int preIndex = i - 1;
        int current = array[i];
        while (preIndex >= 0 && current < array[preIndex]) {
            array[preIndex + 1] = array[preIndex];
            preIndex--;
        }
        array[preIndex + 1] = current;
    }
}
```

**算法分析：**

不需要额外额空间，所以属于原地排序。不会改变数据的先后顺序，所以是稳定的。


### 3. 选择排序

从未排序序列中找到最小的元素，存放到排序序列的末尾位置，重复此步骤，直到所有元素均排序完毕。 

```java
public static void selectionSort(int[] array) {
    int len = array.length;
    for (int i = 0; i < len - 1; i++) {
        int minIndex = i;

        for (int j = i + 1; j < len; j++) {
            minIndex = array[minIndex] < array[j] ? minIndex : j;
        }

        swap(array, minIndex, i);
    }
}
```

**算法分析：**

不需要额外额空间，所以属于原地排序。但是在每次寻找最小数据时会交换数据的位置，所以会改变两个相等的数据的先后顺序，因此不属于稳定排序。


### 4. 归并排序

由下至上 + 分治思想，将大的未排序的数组划分为两个数组，分别将他们排序，然后合并两个有序子数组即可。

```java
public static void mergeSort(int[] array, int left, int right) {

    if (right <= left) return;
    int mid = (left + right) >> 1; // (left + right) / 2

    mergeSort(array, left, mid);
    mergeSort(array, mid + 1, right);
    merge(array, left, mid, right);

}

public static void merge(int[] arr, int left, int mid, int right) {

    int[] temp = new int[right - left + 1]; // 中间数组
    int i = left, j = mid + 1, k = 0;

    while (i <= mid && j <= right) {
        temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
    }

    while (i <= mid) temp[k++] = arr[i++];
    while (j <= right) temp[k++] = arr[j++];

    System.arraycopy(temp, 0, arr, left, right - left + 1);
}
```

**算法分析：**

合并子数组时需要额外额空间，所以不属于原地排序。不会改变数据的先后顺序，所以是稳定的。


### 5. 快速排序

由上至下思想，选取一个分区点 P，将小于 P 的数据异动到左边，大于 P 的数据移动到右边。然后在对左右子数组继续划分，直至数组有序。

```java
public static void quickSort(int[] array, int left, int right) {
    int partition = partition(array, left, right);
    quickSort(array, 0, partition);
    quickSort(array, partition + 1, right);
}

private static int partition(int[] array, int left, int right) {
    int pivot = right, counter = left;

    for (int i = left; i < right; i++) {
        if(array[i] < array[pivot]){
            swap(array, i, counter);
            counter++;
        }
    }

    swap(array, pivot, counter);

    return counter;
}
```

**算法分析：**

不需要额外额空间，所以属于原地排序。partition 操作时会交换数据的位置，所以会改变数据的先后顺序，不属于稳定排序。

最坏情况下，数组是有序的，每次 partition 选择的都是最大的元素，复杂度会上升到 O(n^2)。

### 6. 计数排序

非比较排序。寻找出给定数组 array 的最大值 max，然后生声明一个大小为 max + 1 的新的数组 bucket。bucket 中下标为 x 处存放了 x 在 array 中出现的次数。

将所有数据的次数统计出来之后，从小打到遍历 bucket 填充 array 即可。

```
public static void countingSort(int[] array) {
    int maxVal = array[0];
    for (int num : array) {
        maxVal = Math.max(maxVal, num);
    }

    int[] bucket = new int[maxVal + 1];
    
    for (int num : array) {
        bucket[num]++;
    }

    int sortedIndex = 0;
    for (int i = 0; i < bucket.length; i++) {
        while(bucket[i] > 0){
            array[sortedIndex++] = i; 
            bucket[i]--;
        }
    }
}
```

### 7. 基数排序

比如对给定的电话号码排序，则先对第十一位排序，然后在对第十位排序...对第一位排序。注意，需要采用稳定排序算法。

### 8. 桶排序

将要排序的数据分到几个有序的桶里，每个桶里的数据再单独进行排序。桶内排完序之后，再把每个桶里的数据按照顺序依次取出，组成的序列就是有序的了。
