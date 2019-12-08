//
//  70-climbStairs.swift
//  LeetCode
//
//  Created by 张银龙 on 2019/10/20.
//  Copyright © 2019 张银龙. All rights reserved.
//

import Cocoa
/*:
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

>示例 1：
>
>输入： 2
>
>输出： 2
>
>解释： 有两种方法可以爬到楼顶。
>1.  1 阶 + 1 阶
>2.  2 阶


>示例 2：
>
>输入： 3
>
>输出： 3
>
>解释： 有三种方法可以爬到楼顶。
>1.  1 阶 + 1 阶 + 1 阶
>2.  1 阶 + 2 阶
>3.  2 阶 + 1 阶

[70. 爬楼梯](https://leetcode.com/problems/climbing-stairs)
*/
class ClimbStairs: NSObject {
    // 菲波拉契数 f(n) = f(n-1) + f(n-2)
    func climbStairs(_ n: Int) -> Int {
        guard n > 2 else { return n }
        
        var n1 = 1
        var n2 = 2
        var n3 = 3
        
        for _ in 3 ... n {
            n3 = n1 + n2
            n1 = n2
            n2 = n3
        }
        
        return n3
    }

}
