package Practice.NiuKeOJ;

/**
 * ReverseList
 *
 * @author Mia Feng
 * @date 2018/4/1
 *
 * 剑指offer
 *
题目描述
输入一个链表，反转链表后，输出链表的所有元素。
 链表之间链的切换问题。。。好吧，刚开始做错了

 后来还是看了别人的才发现简单的链一下就可以了；
 */
public class ReverseList {

public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
    public class Solution {
        public ListNode ReverseList(ListNode head) {
            ListNode result = null, next = null;

            while(head!=null){
                next = head.next;
                head.next = result;
                result = head;
                head = next;
            }

            return result;

        }
    }


}


