package Practice.NiuKeOJ;

/**
 * CloneOfComplexList
 *
 * @author Mia Feng
 * @date 2018/4/5
 * ��ָoffer
 *
 * ��Ŀ����
����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩��
���ؽ��Ϊ���ƺ��������head����ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
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
            RandomListNode copyHead = new RandomListNode(-1);
            copyHead.next = null;
            RandomListNode pTemp = copyHead;
            while(pHead!=null){
                int tmp = pHead.label;
                pTemp.next = new RandomListNode(tmp);
                pHead = pHead.next;
                pTemp = pTemp.next;
            }

            return copyHead.next;
        }
    }


}

