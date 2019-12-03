import UIKit

/*
 
 两数之和
 
 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/two-sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 
 */


//1236ms

var nums:[Int] = [2,7,11,15]
let target = 9

class Solution_1236 {
    func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
        var result = [Int]()
        var leftNum:Int
        var rightNum: Int
        
        for index in nums.indices {
            leftNum=nums[index]
            for index_internal in nums.indices {
                if !(index==index_internal) {
                    rightNum=nums[index_internal]
                    if leftNum+rightNum==target {
                        if !result.contains(index) {
                            result.append(index)
                        }
                        if !result.contains(index_internal) {
                            result.append(index_internal)
                        }
                    }
                }
            }
        }
        
        return result
    }
}

//40ms

class Solution_40 {
    func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
        var hashTable: Dictionary<Int, Int> = [:]
        for (index, value) in nums.enumerated() {
            let targetNum = target - value;
            if hashTable.keys.contains(targetNum) {
                return [hashTable[targetNum]!, index]
            }
            hashTable.updateValue(index, forKey:value)
        }
        return []
    }
}


var solution = Solution_40()
var result = solution.twoSum(nums, target)
print("\(result)")


