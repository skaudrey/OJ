package Practice.NiuKeOJ;

/**
 * CloneOfComplexList
 *
 * @author Mia Feng
 * @date 2018/4/5
 * 剑指offer
 *
 * 题目描述
输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）

 查了之后发现思路是这样的：
 1. 拷贝链表（插入拷贝值至原值的后面）：此时只处理next指针
 2. 拷贝random指针
 3. 拆分链表
 */
public class CloneOfComplexList {

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public class Solution {
        public RandomListNode Clone(RandomListNode pHead)
        {
            if(pHead==null)
                return null;
            RandomListNode current = pHead; //phead,不是pHead.next;

            //拷贝链表（与原链表组合起来）,只处理next指针
            //即，如果之前的链表为A-->B-->C……,拷贝后的结果为：A-->A'-->B-->B'-->C……
            while(current!=null){
                RandomListNode coloneNode = new RandomListNode(current.label);
                RandomListNode next = current.next;
                current.next = coloneNode;
                coloneNode.next =  next;
                current = next;    //jump the same one
            }

            //拷贝链表，只处理random指针
            current = pHead;
            while(current!=null){
                current.next.random = current.random==null?null:current.random.next;    //注意是current.next.random
                current = current.next.next;
            }

            //拆分链表
            current = pHead;
            RandomListNode pColoneHead = pHead.next;
            while(current!=null){
                RandomListNode coloned = current.next;
                current.next = coloned.next;
                coloned.next = coloned.next==null?null:coloned.next.next;   //注意next.next
                current = current.next;
            }
            return pColoneHead;
        }
    }


}

