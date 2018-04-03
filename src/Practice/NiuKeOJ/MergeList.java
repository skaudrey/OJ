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
            head.next = null;//ע��������ʱ��ͷָ��Ҫ�����ư�����Ȼ��Զ�ĵĶ�������ͷ��

            ListNode merged = head; //��¼�����ںϽ��

            while(list1!=null && list2!= null){ //������һ������Ϊ��
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


            if(list1!=null)//��û�б������ֱ������ȥ�ͺ��ˡ����������ٷ��ı�����
                head.next = list1;


            if(list2!=null)
                head.next = list2;
            return merged.next;//�ǵ�ͷָ���ǿյģ�Ҫ����ͷָ��֮���Ԫ�أ�
        }
    }

    //Ҳ���Եݹ�ʵ�֣��ð����������ѧ�������ˣ��ţ�Ҫ����״̬ת�Ʒ��̣����о�������Ļᴥ�ס�

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


