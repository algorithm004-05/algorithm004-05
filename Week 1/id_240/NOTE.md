## 1.移动数组内某个元素到最后

```javascript
//1.遍历数组
//2.数值 === target删除该项，并添加到最后。游标不变
//3.数值 !== target 游标++
function moveToEnd(arr, target) {
  let temp = 0;
  for (let i = 0; i < arr.length; i++) {
    if (arr[temp] === target) {
      arr.splice(temp, 1);
      arr[arr.length] = target;
    } else {
      temp++;
    }
  }
}
```

## 2.链表转数组

```javascript
function listToArray(list) {
  let arr = [];
  while (list !== null) {
    arr.push(list.val);
    list = list.next;
  }
  return arr;
}
```

## 3.数组转链表

```javascript
function arrayToList(array) {
  if (!array.length) {
    return null;
  }
  let head = { val: array[0], next: null };
  let pnode = head;
  for (let i = 1; i < array.length; i++) {
    let node = { val: array[i], next: null };
    pnode.next = node;
    pnode = pnode.next;
  }
  return head;
}
```

## 关于链表操作的思考

- 自身对链表的操作不熟
- 结合自身理解
  1. list -> array
  2. handle array
  3. array -> list
