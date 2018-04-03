package Practice.NiuKeOJ;

import java.util.ArrayList;

/**
 * printListReverse
 *
 * @author Mia Feng
 * @date 2018/3/29
 *
 * 剑指offer
 * 题目描述
输入一个链表，从尾到头打印链表每个节点的值。

 好吧，真的是蠢
 是个递归的问题,只要不到尾节点就一直压栈
 *
 */
public class printListReverse {

         public class ListNode {
             int val;
             ListNode next = null;

             ListNode(int val) {
                 this.val = val;
             }
         }

    public class Solution {
        ArrayList<Integer> result = new ArrayList<>();
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//            ArrayList<Integer> result = new ArrayList<>();//不可以把List初始化放在这里，不然每次递归都会被初始化
            if(listNode!=null){ //注意这里判断当前节点，而不是后续子节点
                this.printListFromTailToHead(listNode.next);
                result.add(listNode.val);
            }
            return result;
        }
    }
}
