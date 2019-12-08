package main

import ( 
	"math"
)
 
// 快速排序
func quickSort(array []int, begin int, end int) []int {
	if end <= begin {
		return array
	}
	array, pivot := partition(array, begin, end)

	array = quickSort(array, begin, pivot - 1) // 标杆左边
	array = quickSort(array, pivot + 1, end)   // 标杆右边

	return array
}
func partition(a []int, begin int, end int) ([]int, int) {
	// pivot: 标杆位置，counter: 小于pivot的元素的个数
	pivot, counter := end, begin
	for i := begin; i < end; i++ {
		if a[i] < a[pivot] {
			a[counter], a[i] = a[i], a[counter]
			counter++
		}
	}

	a[pivot],a[counter] = a[counter], a[pivot]

	return a, pivot
}

// 归并排序 。。。bug 。。。
func mergeSort2(array []int, left int, right int) []int {
	if right <= left {
		return array
	}

	mid := (left + right) >> 1 // (left + right) / 2  位运算

	array = mergeSort2(array, left, mid)      // 左排序
	array = mergeSort2(array, mid + 1, right) // 右排序

	array = merge2(array, left, mid, right)

	return array
}
func merge2(arr []int, left int, mid int, right int) []int {
	length := right - left + 1
	temp := make([]int, length, length) // new int[right - left + 1]; // 中间数组
	i, j, k := left, mid + 1, 0

	for i <= mid && j <= right {
		k++
		if  arr[i] <= arr[j] {
			i++
			temp[k] = i
		} else {
			j++
			temp[k] = j
		}
	}

	for i <= mid{
		k++
		i++
		temp[k] = arr[i]
	}
	for j <= right {
		k++
		j++
		temp[k] = arr[j]
	}

	for p := 0; p < len(temp); p++ {
		arr[left + p] = temp[p]
	}
	return arr
}
// 归并排序 
func mergeSort(arr []int) []int {
	length := len(arr)
	if length < 2 {
		return arr
	}

	middle := int(math.Floor(float64(length / 2)))

	left, right :=arr[0: middle],arr[middle:]

	return merge(mergeSort(left), mergeSort(right))
}
func merge(left []int, right []int) []int {
	var result []int

	for len(left) > 0 && len(right) > 0 {
		if left[0] <= right[0] {
			result = append(result, left[0])
			left = left[1:]
		} else {
			result = append(result, right[0])
			right = right[1:]
		}
	}

	for len(left) > 0 {
		result = append(result, left[0])
		left = left[1:]
	}

	for len(right) > 0 {
		result = append(result, right[0])
		right = right[1:]
	}

	return result
}

// 堆排序 ？
func heapSort(array []int) []int {
	length := len(array)

	if len(array) == 0 { return array }

	for i := length / 2 - 1; i >= 0; i-- {
		array = heapify(array, length, i)
	}

	for i := length - 1; i >= 0; i-- {
		array[0], array[i] = array[0], array[i]

		array = heapify(array, i, 0)
	}

	return array
}
func heapify(array []int, length int, i int) []int {
	left, right, largest := 2 * i + 1, 2 * i + 2, i

	if left < length && array[left] > array[largest] {
		largest = left
	}
	if right < length && array[right] > array[largest] {
		largest = right
	}

	if largest != i {
		array[i], array[largest] = array[largest], array[i]
		array = heapify(array, length, largest)
	}

	return array
}

