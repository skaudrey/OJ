package Practice.NiuKeOJ;

import java.util.ArrayList;

/**
 * printListReverse
 *
 * @author Mia Feng
 * @date 2018/3/29
 *
 * ��ָoffer
 * ��Ŀ����
����һ��������β��ͷ��ӡ����ÿ���ڵ��ֵ��

 �ðɣ�����Ǵ�
 �Ǹ��ݹ������,ֻҪ����β�ڵ��һֱѹջ
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
//            ArrayList<Integer> result = new ArrayList<>();//�����԰�List��ʼ�����������Ȼÿ�εݹ鶼�ᱻ��ʼ��
            if(listNode!=null){ //ע�������жϵ�ǰ�ڵ㣬�����Ǻ����ӽڵ�
                this.printListFromTailToHead(listNode.next);
                result.add(listNode.val);
            }
            return result;
        }
    }
}
