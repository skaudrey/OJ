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

 ����֮����˼·�������ģ�
 1. �����������뿽��ֵ��ԭֵ�ĺ��棩����ʱֻ����nextָ��
 2. ����randomָ��
 3. �������
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
            RandomListNode current = pHead; //phead,����pHead.next;

            //����������ԭ�������������,ֻ����nextָ��
            //�������֮ǰ������ΪA-->B-->C����,������Ľ��Ϊ��A-->A'-->B-->B'-->C����
            while(current!=null){
                RandomListNode coloneNode = new RandomListNode(current.label);
                RandomListNode next = current.next;
                current.next = coloneNode;
                coloneNode.next =  next;
                current = next;    //jump the same one
            }

            //��������ֻ����randomָ��
            current = pHead;
            while(current!=null){
                current.next.random = current.random==null?null:current.random.next;    //ע����current.next.random
                current = current.next.next;
            }

            //�������
            current = pHead;
            RandomListNode pColoneHead = pHead.next;
            while(current!=null){
                RandomListNode coloned = current.next;
                current.next = coloned.next;
                coloned.next = coloned.next==null?null:coloned.next.next;   //ע��next.next
                current = current.next;
            }
            return pColoneHead;
        }
    }


}

