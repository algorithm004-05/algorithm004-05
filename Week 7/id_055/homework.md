### 排序算法

https://www.cnblogs.com/onepixel/p/7674659.html

冒泡

- 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
- 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
- 针对所有的元素重复以上的步骤，除了最后一个；
- 重复步骤 1~3，直到排序完成。

```js
function bubbleSort(arr) {
  let len = arr.length;
  for (let i = 0; i < len - 1; i++) {
    for (let j = 0; j < len - 1 - i; j++) {
      if (arr[j] > arr[j + 1]) {
        [arr[j], arr[j + 1]] = [arr[j + 1], arr[j]];
      }
    }
  }

  return arr;
}

bubbleSort([5, 4, 8, 9, 1]);
```

选择排序

- 初始状态：无序区为 R[1..n]，有序区为空；
- 第 i 趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为 R[1..i-1]和 R(i..n）。该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第 1 个记录 R 交换，使 R[1..i]和 R[i+1..n)分别变为记录个数增加 1 个的新有序区和记录个数减少 1 个的新无序区；
- n-1 趟结束，数组有序化了。

```js
function selectionSort(arr) {
  let len = arr.length,
    minIndex;

  for (let i = 0; i < len - 1; i++) {
    minIndex = i;
    for (let j = i + 1; j < len; j++) {
      if (arr[j] < arr[minIndex]) {
        minIndex = j;
      }
    }
    [arr[i], arr[minIndex]] = [arr[minIndex], arr[i]];
  }

  return arr;
}

selectionSort([5, 4, 8, 9, 1]);
```

插入排序

- 从第一个元素开始，该元素可以认为已经被排序；
- 取出下一个元素，在已经排序的元素序列中从后向前扫描；
- 如果该元素（已排序）大于新元素，将该元素移到下一位置；
- 重复步骤 3，直到找到已排序的元素小于或者等于新元素的位置；
- 将新元素插入到该位置后；
- 重复步骤 2~5。

```js
function insertionSort(arr) {
  let len = arr.length;
  let preIndex, current;
  for (let i = 1; i < len; i++) {
    preIndex = i - 1;
    current = arr[i];

    while (preIndex >= 0 && arr[preIndex] > current) {
      arr[preIndex + 1] = arr[preIndex];
      preIndex--;
    }

    arr[preIndex + 1] = current;
  }

  return arr;
}

console.log(insertionSort([5, 4, 8, 9, 1]));
```

希尔排序

```js
// 修改于 2019-03-06
function shellSort(arr) {
  let len = arr.length;
  for (let gap = Math.floor(len / 2); gap > 0; gap = Math.floor(gap / 2)) {
    // 注意：这里和动图演示的不一样，动图是分组执行，实际操作是多个分组交替执行
    for (let i = gap; i < len; i++) {
      let j = i;
      let current = arr[i];
      while (j - gap >= 0 && current < arr[j - gap]) {
        arr[j] = arr[j - gap];
        j = j - gap;
      }
      arr[j] = current;
    }
  }
  return arr;
}
```

归并排序

```js
function mergeSort(arr) {
  let len = arr.length;
  if (len < 2) {
    return arr;
  }
  let middle = Math.floor(len / 2),
    left = arr.slice(0, middle),
    right = arr.slice(middle);
  return merge(mergeSort(left), mergeSort(right));
}

function merge(left, right) {
  var result = [];

  while (left.length > 0 && right.length > 0) {
    if (left[0] <= right[0]) {
      result.push(left.shift());
    } else {
      result.push(right.shift());
    }
  }

  while (left.length) result.push(left.shift());

  while (right.length) result.push(right.shift());

  return result;
}
```

快速排序

```js
function quickSort(arr, left, right) {
  let len = arr.length,
    partitionIndex,
    left = typeof left != 'number' ? 0 : left,
    right = typeof right != 'number' ? len - 1 : right;

  if (left < right) {
    partitionIndex = partition(arr, left, right);
    quickSort(arr, left, partitionIndex - 1);
    quickSort(arr, partitionIndex + 1, right);
  }
  return arr;
}

function partition(arr, left, right) {
  // 分区操作
  let pivot = left, // 设定基准值（pivot）
    index = pivot + 1;
  for (let i = index; i <= right; i++) {
    if (arr[i] < arr[pivot]) {
      swap(arr, i, index);
      index++;
    }
  }
  swap(arr, pivot, index - 1);
  return index - 1;
}

function swap(arr, i, j) {
  [arr[i], arr[j]] = [arr[j], arr[i]];
}
```

<<<<<<< HEAD

9 种经典排序算法可视化动画 https://www.bilibili.com/video/av25136272

https://leetcode-cn.com/problems/relative-sort-array/

```js
/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number[]}
 */
var relativeSortArray = function(arr1, arr2) {
  // 需要一个计数的 Map
  let m = new Map(),
    rest = [];

  for (let i = 0; i < arr2.length; i++) {
    m.set(arr2[i], 0);
  }

  for (let i = 0; i < arr1.length; i++) {
    if (m.has(arr1[i])) {
      m.set(arr1[i], m.get(arr1[i]) + 1);
    } else {
      rest.push(arr1[i]);
    }
  }

  let res = [];
  for (let [key, value] of m) {
    res.push(...new Array(value).fill(key));
  }

  return [...res, ...rest.sort((a, b) => a - b)];
};
```

解法 2

```js
/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number[]}
 */
var relativeSortArray = function(arr1, arr2) {
  return arr1.sort((a, b) => {
    // 以 arr2 的索引为顺序
    let ia = arr2.indexOf(a);
    let ib = arr2.indexOf(b);

    if (ia === -1 && ib === -1) {
      // 都不在 arr2 里，比较值
      return a - b;
    } else if (ia === -1) {
      return 1;
    } else if (ib === -1) {
      return -1;
    } else {
      // 都在 arr2 里，比较索引
      return ia - ib;
    }
  });
};
```

https://leetcode-cn.com/problems/valid-anagram/

```js
// 解法1 排序 解法2 HashTable 计数
var isAnagram = function(s, t) {
  let ss = s
    .split('')
    .sort()
    .join('');
  let st = t
    .split('')
    .sort()
    .join('');

  return ss === st;
};
```

解法 2

```js
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
// 解法1 排序
// 解法2 HashTable 计数
var isAnagram = function(s, t) {
  if (s.length !== t.length) return false;

  let map = new Map();

  for (let c of s) {
    if (map.has(c)) {
      map.set(c, map.get(c) + 1);
    } else {
      map.set(c, 1);
    }
  }

  for (let c of t) {
    if (map.has(c)) {
      map.set(c, map.get(c) - 1);
    } else {
      return false;
    }
  }

  for (let [key, value] of map) {
    if (value !== 0) {
      return false;
    }
  }

  return true;
};
```

https://leetcode-cn.com/problems/design-a-leaderboard/

```js
var Leaderboard = function() {
  this.map = new Map();
};

/**
 * @param {number} playerId
 * @param {number} score
 * @return {void}
 */
Leaderboard.prototype.addScore = function(playerId, score) {
  if (this.map.has(playerId)) {
    this.map.set(playerId, score + this.map.get(playerId));
  }
  this.map.set(playerId, score);
};

/**
 * @param {number} K
 * @return {number}
 */
Leaderboard.prototype.top = function(K) {
  let arr = [...this.map.values()];
  console.log(arr);
  let tmp = arr.sort((a, b) => b - a),
    sum = 0;
  for (let i = 0; i < Math.min(K, arr.length); i++) {
    sum += tmp[i];
  }
  return sum;
};

/**
 * @param {number} playerId
 * @return {void}
 */
Leaderboard.prototype.reset = function(playerId) {
  if (this.map.has(playerId)) {
    this.map.set(playerId, 0);
  }
};

/**
 * Your Leaderboard object will be instantiated and called as such:
 * var obj = new Leaderboard()
 * obj.addScore(playerId,score)
 * var param_2 = obj.top(K)
 * obj.reset(playerId)
 */
```

https://leetcode-cn.com/problems/merge-intervals/

```js
/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function(intervals) {
  let result = [];
  let len = intervals.length;
  if (len == 0) {
    return [];
  }
  intervals.sort((a, b) => a[0] - b[0]);
  let i = 0;
  while (i < len) {
    let currLeft = intervals[i][0];
    let currRight = intervals[i][1];

    while (i < len - 1 && intervals[i + 1][0] <= currRight) {
      i++;
      currRight = Math.max(intervals[i][1], currRight);
    }

    result.push([currLeft, currRight]);

    i++;
  }
  return result;
};
```

https://leetcode-cn.com/problems/reverse-pairs/
