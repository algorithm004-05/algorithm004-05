# 第七周总结

## 比较类排序

常写的两种

### 1. 冒泡排序

```go
func bubbleSort(arr []int) []int {
    for i := 0; i < len(arr)-1; i++ {
        for j := 1; j < len(arr)-i; j++ {
            if arr[i] > arr[j] {
                arr[j], arr[i] = arr[i], arr[j]
            }
        }
    }
    return arr
}
```

### 2. 选择排序

```javascript
function selectionSort(arr) {
    var len = arr.length;
    var minIndex, temp;
    for (var i = 0; i < len - 1; i++) {
        minIndex = i;
        for (var j = i + 1; j < len; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }
        temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }
    return arr;
}
```

## 位运算

* 判断奇偶
`x%2 == 1 --> (x&1) == 1`
`x%2 == 0 --> (x&1) == 0`

* `x >> 1 --> x/2`

* `X=X&(X-1)`清零最低位的1

* `X&-X` 得到最低位的1

* `X&~X` 0

## 布隆过滤器

应用

1. 比特币网络
2. 分布式系统
3. Redis缓存
4. 垃圾邮件、评论等的过滤
