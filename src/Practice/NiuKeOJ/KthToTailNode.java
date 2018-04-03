package Practice.NiuKeOJ;

/**
 * KthToTailNode
 *
 * @author Mia Feng
 * @date 2018/3/29
 *
 * 剑指offer
 *
 * 题目描述
输入一个链表，输出该链表中倒数第k个结点。

 也是看到了一个思路很巧的，如果我自己做的话肯定想不到

 用两个指针，一个指针先走k-1（注意不是k）步，然后两个指针一起走，这样第一个指针到达末尾时，第二个指针刚好到达第k个

 自己做的时候忘记处理头结点为空或者k<0的情况了，以及如果链表长度小于k的情况，参考了答案加上了。。要谨慎啊
 */
public class KthToTailNode {
    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public class Solution {
        public ListNode FindKthToTail(ListNode head,int k) {
            if(head==null || k<=0)  //需处理链表为空的情况
                return null;

            ListNode pre1 = head, pre2 = head;
            int i = 0;
            while(i++<k-1){ //注意不是走k步，是走k-2步，自己画图推一下就出来了，因为pre1节点要走到空节点，pre2肯定还得跟着走一个
                if(pre1.next!=null){    //要处理数组长度小于k的情况
                    pre1 = pre1.next;
                }
                else
                    return null;
            }

            while(pre1.next!=null){
                pre1 = pre1.next;
                pre2 = pre2.next;
            }
            return pre2;
        }
    }
}
