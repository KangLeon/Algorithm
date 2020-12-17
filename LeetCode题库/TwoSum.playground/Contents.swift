import UIKit

class Solution{
    func twoSum(_ nums:[Int],_ target: Int) -> [Int] {
        var dict = [Int:Int]()
        
        for i in 0..<nums.count {
            let a = nums[i]
            if let bIndex = dict[target-a] {
                return [bIndex,i]
            }else{
                dict[a]=i
            }
        }
        
        return []
    }
}

Solution().twoSum([2,3,4,6,7,8,9], 9)
