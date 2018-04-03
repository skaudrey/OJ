package Practice.NiuKeOJ;

/**
 * MergeList
 *
 * @author Mia Feng
 * @date 2018/4/1
 *
 *
 */
public class MergeList {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        public ListNode Merge(ListNode list1,ListNode list2) {

            ListNode head = new ListNode(-1);
            head.next = null;//注意在做的时候头指针要往后移啊，不然永远改的都是链表头；

            ListNode merged = head; //记录链表融合结果

            while(list1!=null && list2!= null){ //遍历至一个链表为空
                if(list1.val < list2.val){
                    head.next = list1;
                    head = list1;
                    list1 = list1.next;

                }
                else{
                    head.next = list2;
                    head = list2;
                    list2 = list2.next;
                }
            }


            if(list1!=null)//有没有遍历完的直接链过去就好了。。。不用再费心遍历了
                head.next = list1;


            if(list2!=null)
                head.next = list2;
            return merged.next;//记得头指针是空的，要返回头指针之后的元素；
        }
    }

    //也可以递归实现，好吧这种真的是学到精髓了：嗯，要会推状态转移方程，还有就是它真的会触底。

    public ListNode mergeRecusion(ListNode list1, ListNode list2){
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        if(list1.val < list2.val){
            list1.next = mergeRecusion(list1.next,list2);
            return list1;
        }
        else{
            list2.next = mergeRecusion(list1,list2.next);
            return list2;
        }
    }


}


