# 深度遍历&amp; 广度遍历

问题：提取页面dom节点

``` html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
</head>

<body>
    <div class="parent">
        <div class="children-1">
            <div class="children-1-1">
                <div class="children-1-2">
                    <div class="children-1-3"></div>
                </div>
            </div>
        </div>
        <div class="children-2">
            <div class="children-2-1">
                <div class="children-2-2">
                    <div class="children-2-3"></div>
                </div>
            </div>
        </div>
        <div class="children-3">
            <div class="children-3-1">
                <div class="children-3-2">
                    <div class="children-3 3"></div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>
```

<a name="xiNLG"></a>

#### 1. 深度遍历(DFS)

* 核心思想-递归

``` javascript
function deepTravel(node, nodeList = []) {
    if (node.children === null) return;
    nodeList.push(node)
    let children = node.children
    for (let i = 0; i < children.length; i++) {
        deepTravel(children[i], nodeList)
    }
    return nodeList;
}
```

<a name="UBh1K"></a>

#### 2. 广度遍历(BFS)

``` javascript
function boardTravel(node) {
    let nodeList = []; //result
    let stack = [];
    stack.push(node)
    while (stack.length) {
        item = stack.shift();
        nodeList.push(item);
        for (let i = 0; i < item.children.length; i++) {
            if (item.children[i]) stack.push(item.children[i])
        }
    }
    return nodeList;
}
```

<a name="SJfln"></a>

#### 3. 数组平铺flat

* 递归的应用

``` javascript
function getDataType(data) {
    return Object.prototype.toString.call(data).slice(8, -1)
}

function flat(arr, res = []) {
    for (let i = 0; i < arr.length; i++) {
        if (getDataType(arr[i]) === 'Array') {
            flat(arr[i], res)
        } else {
            res.push(arr[i])
        }
    }
    return res;
}
arr = [
    [1, 2, [3, [4, 5]]],
    [6, 7],
    [
        [8],
        [9, [10]]
    ]
];
flat(arr)
```

<a name="PujX0"></a>

#### 4. 单个对象深度遍历

* 递归和while循环之间转换

``` javascript
obj = {
    value: 1,
    children: {
        value: 1,
        children: {
            value: 2,
            children: {
                value: 3,
                children: null
            }
        }
    }
};
// 递归
function getValue(obj, res = []) {
    res.push(obj.value)
    if (obj.children) {
        getValue(obj.children)
    }
    return res;
}
//while
function getValue1(obj, res = []) {
    while (obj) {
        res.push(obj.value)
        obj = obj.children;
    }
}
```

<a name="MQTjz"></a>

#### 5. 深度克隆（深度优先）

``` javascript
function deepCopy(sourceObj, target = {}) {
    let keys = Object.keys(sourceObj)
    keys.forEach(key => {
        if (typeof sourceObj[key] !== 'object') {
            target[key] = sourceObj[key]
        } else {
            deepCopy(sourceObj[key], target[key] = {})
        }
    })
    return target;
}
```

<a name="mbztD"></a>

#### 6. 深度克隆（广度优先）

``` javascript
  //广度优先复制
  function widthDeepCopy(source, target = {}) {
      let keys = Object.keys(source);
      let stack = [];
      stack = [...keys];
      while (stack.length) {
          curKey = stack.shift();
          if (source[curKey] !== "object") {
              target[curKey] = source[curKey];
          } else {
              target = target[curKey] = {};
              stack.push(...Object.keys(source[curKey]));
          }
          console.log(curKey)
      }
      return target;
  }
```

  

