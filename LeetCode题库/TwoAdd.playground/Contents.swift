import UIKit


public class ListNode {
  public var val: Int
  public var next: ListNode?
  public init() { self.val = 0; self.next = nil; }
  public init(_ val: Int) { self.val = val; self.next = nil; }
  public init(_ val: Int, _ next: ListNode?) { self.val = val; self.next = next; }
}

class Solution {
    func addTwoNumbers(_ l1: ListNode?, _ l2: ListNode?) -> ListNode? {
        //未遍历的链表，初始值为传参
        var listNode1 = l1
        var listNode2 = l2
        //进位制（两个数相加大于等于10时，将十位数上的值赋给进位制，并参与下一节点的求和）
        var carry: Int = 0
        //返回结果表链（初始new一个ListNode即可，val为任意值）
        let result:ListNode = ListNode(0);
        //当前节点
        var currentNode: ListNode = result
        
        //存在未遍历的表链或者进位值carry大于0的场合，继续遍历
        while listNode1 != nil || listNode2 !=  nil || carry > 0 {
            
            //求和
            let sum:Int = (listNode1?.val ?? 0) + (listNode2?.val ?? 0) + carry
            //更新未遍历的链表
            listNode1 = listNode1?.next
            listNode2 = listNode2?.next
            
            //更新进位值
            carry = sum/10
            //保存本次遍历的节点
            currentNode.next=ListNode(sum%10)
            //更新当前节点
            currentNode = currentNode.next!
        }
        return result.next
    }
}
