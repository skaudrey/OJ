package Practice.NiuKeOJ;

/**
 * ReverseList
 *
 * @author Mia Feng
 * @date 2018/4/1
 *
 * ��ָoffer
 *
��Ŀ����
����һ��������ת�����������������Ԫ�ء�
 ����֮�������л����⡣�����ðɣ��տ�ʼ������

 �������ǿ��˱��˵Ĳŷ��ּ򵥵���һ�¾Ϳ����ˣ�
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


