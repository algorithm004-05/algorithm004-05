1. 重要：***重复项，重复项，重复项***
2. 暴力解法
3. 左右指针碰撞
4. 递归
> 找最近重复项
> 归纳法
1. 降维处理
2. 空间换时间
3. 最近相关性
4. 互补数据
 > 可以利用hash保存互补值
1. 数组和链表注意==边界问题==
2. 2个栈实现队列


#### 链表：
####   删除节点 指针交换2步操作
    this.before.next = this.after; //前继节点后继指针指向后继节点
    this.after.pre = this.before;  //后继节点前继指针指向前继节点
#####   新增节点 指针交换4步操作
    添加到位置节点a前面
    ---处理旧的前后节点指向
    this.before = a.pre;  // 当前节点前继指针指向a的前继节点
    this.next = a;  // 当前节点的后继指针指向a
    ---处理当前节点指向
    this.before.next = this;// a的前继指针指向当前节点
    a.pre = this;   //a的前继指针指向当前节点
    

java.util.ArrayList
*    数组

java.util.LinkedList
*    链表
   
java.util.HashMap

*    数组
*    hash冲突
>        链表
>        红黑树（大于8）

java.util.LinkedHashMap 
*   继承java.util.HashMap
*   有序性通过==链表==维护


redis数据结构待了解？？？

mysql数据结构待了解？？？
  

    


