package Practice.NiuKeOJ;

/**
 * KthToTailNode
 *
 * @author Mia Feng
 * @date 2018/3/29
 *
 * ��ָoffer
 *
 * ��Ŀ����
����һ����������������е�����k����㡣

 Ҳ�ǿ�����һ��˼·���ɵģ�������Լ����Ļ��϶��벻��

 ������ָ�룬һ��ָ������k-1��ע�ⲻ��k������Ȼ������ָ��һ���ߣ�������һ��ָ�뵽��ĩβʱ���ڶ���ָ��պõ����k��

 �Լ�����ʱ�����Ǵ���ͷ���Ϊ�ջ���k<0������ˣ��Լ����������С��k��������ο��˴𰸼����ˡ���Ҫ������
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
            if(head==null || k<=0)  //�账������Ϊ�յ����
                return null;

            ListNode pre1 = head, pre2 = head;
            int i = 0;
            while(i++<k-1){ //ע�ⲻ����k��������k-2�����Լ���ͼ��һ�¾ͳ����ˣ���Ϊpre1�ڵ�Ҫ�ߵ��սڵ㣬pre2�϶����ø�����һ��
                if(pre1.next!=null){    //Ҫ�������鳤��С��k�����
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
