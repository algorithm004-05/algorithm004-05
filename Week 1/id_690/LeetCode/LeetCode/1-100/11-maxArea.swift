//
//  11-maxArea.swift
//  LeetCode
//
//  Created by 张银龙 on 2019/10/20.
//  Copyright © 2019 张银龙. All rights reserved.
//

import Cocoa
/*:
给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。

 > 输入: [1,8,6,2,5,4,8,3,7]
 >
 > 输出: 49
 
链接： [11. 盛最多水的容器](https://leetcode.com/problems/container-with-most-water)
 */
class MaxArea: NSObject {
    
    // 穷举法: 2292 ms , 在所有 swift 提交中击败了 5.26% 的用户 O(n^2)
    func maxArea(_ height: [Int]) -> Int {
        guard height.count > 2 else {
            return min(height[0], height[1])
        }
        
        var maxHeight: Int = 0
        // 记录上一次 容器高,
        var lastValue = 0
        
        for index in 0 ..< height.count {
            
            let value = height[index]
            if value <= lastValue { continue }
            
            lastValue = value
            
            for index_2 in index + 1 ..< height.count {
                let value_2 = height[index_2]
                
                let minH = min(value, value_2)
                maxHeight = max(maxHeight, minH * (index_2 - index))
                
            }
        }
        
        return maxHeight
        
    }

    // 两端收敛
    // 104 ms, 在所有 swift 提交中击败了 100.00% 的用户 O(n)
    func maxArea_2(_ height: [Int]) -> Int {
        
        var left = 0
        var right =  height.count - 1
        
        var maxHeight = 0
        
        while left < right {
            
            let box = min(height[left], height[right]) * (right - left)
            maxHeight = max(box, maxHeight)
            
            if height[left] > height[right] {
                right -= 1
            } else {
                left += 1
            }
        }
        
        return maxHeight
    }

}
