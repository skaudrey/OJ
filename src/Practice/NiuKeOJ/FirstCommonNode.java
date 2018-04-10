package Practice.NiuKeOJ;

/**
 * FirstCommonNode
 *
 * @author: Mia Feng
 * @date: 2018/4/10
 *
 * 剑指offer
 *
 * 题目描述
输入两个链表，找出它们的第一个公共结点。

 嗯，我又想错了。。。是真的想错了。。
 不是比较两个链表的值相同，直接比较地址就可以了，。。两个链表最后链到相同的地址上了。

 有人的做法是记下两个链表的长度，先让长的走两个链表长度差，然后再一起走

 下面的这个思路更巧
 */
public class FirstCommonNode {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        FirstCommonNode.ListNode p1 = pHead1;
        FirstCommonNode.ListNode p2 = pHead2;

        while(p1!=p2){
            p1 = (p1==null?pHead2:p1.next);
            p2 = (p2==null?pHead1:p2.next);
        }
        return p1;

    }

}
