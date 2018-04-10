package Practice.NiuKeOJ;

/**
 * FirstCommonNode
 *
 * @author: Mia Feng
 * @date: 2018/4/10
 *
 * ��ָoffer
 *
 * ��Ŀ����
�������������ҳ����ǵĵ�һ��������㡣

 �ţ���������ˡ��������������ˡ���
 ���ǱȽ����������ֵ��ͬ��ֱ�ӱȽϵ�ַ�Ϳ����ˣ����������������������ͬ�ĵ�ַ���ˡ�

 ���˵������Ǽ�����������ĳ��ȣ����ó��������������ȲȻ����һ����

 ��������˼·����
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
