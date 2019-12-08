//
//  15-3Sum.swift
//  LeetCode
//
//  Created by 张银龙 on 2019/10/20.
//  Copyright © 2019 张银龙. All rights reserved.
//

import Cocoa

/*:
 
 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 
 注意：答案中不可以包含重复的三元组。
 
 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 
 
 满足要求的三元组集合为：
 
 [
 
 [-1, 0, 1],
 
 [-1, -1, 2]
 
 ]
 
 [15.三数之和](https://leetcode.com/problems/3sum)
 
 */
class ThreeSum: NSObject {

    func threeSum(_ nums: [Int]) -> [[Int]] {
        
        let count = nums.count
        if count < 3 { return [] }
        
        var allRes: [[Int]] = []
        
        // 先排序
        let sortedNum = nums.sorted()
        print(sortedNum)
        
        for index in 0 ..< count - 2 {
            
            
            let value = sortedNum[index]
            
            if index > 0, value == sortedNum[index - 1] {
                continue
            }
            
            var left = index + 1
            var right = count - 1
            
            while left < right {
                let sum = value + sortedNum[left] + sortedNum[right]
                
                
                if sum > 0 {
                    right -= 1
                } else if sum < 0 {
                    left += 1
                } else {
                    allRes.append([value, sortedNum[left], sortedNum[right]])
                
                    while left < right, sortedNum[left] == sortedNum[left + 1]   {
                        left += 1
                    }
                    
                    while left < right, sortedNum[right] == sortedNum[right - 1]   {
                        right -= 1
                    }
                    
                    right -= 1
                    left += 1
                }
            }
        }
        
        return allRes
    }

}
