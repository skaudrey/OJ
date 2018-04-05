package Practice.NiuKeOJ;

/**
 * isAfterOrderOfBinarySearchTree
 *
 * @author Mia Feng
 * @date 2018/4/3
 *
 * ��Ŀ����
����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
����������Yes,�������No���������������������������ֶ�������ͬ��

��ŷ��ֶ������������Ƕ������������Ƕ��������

���ӣ�https://www.nowcoder.com/questionTerminal/a861533d45854474ac791d90e447bafd
��Դ��ţ����

BST�ĺ������еĺϷ������ǣ�����һ������S�����һ��Ԫ����x ��Ҳ���Ǹ�����
���ȥ�����һ��Ԫ�ص�����ΪT����ôT���㣺T���Էֳ����Σ�ǰһ�Σ���������С��x��
��һ�Σ�������������x���������Σ����������ǺϷ��ĺ������С������ĵݹ鶨�� : ) ��

���ڶ��������������ʣ����ڵ������������ֵС�ڸ��ڵ��ֵ�����������ڸ��ڵ㣬��ô��
����ֻ��Ҫ�����з�Ϊ������(leftTree)��������(rightTree)��
Ȼ��������(leftTree)�ٷ�Ϊ������(left_leftTree)��������(left_rightTree)��
������(rightTree)��Ϊ������(left_rightTree)��������(right_rightTree)�����θ��ݶ��������������ʣ�
�����жϣ�ֱ��û�нڵ���߲�����������ֹͣ��
 */
public class isAfterOrderOfBinarySearchTree {

    public class Solution {
        public boolean VerifySquenceOfBST(int [] sequence) {
            int nLen = sequence.length;
            if(nLen==0)
                return false;
            if(nLen == 1)
                return true;
            return judge(sequence, 0 , nLen-1);
        }

        public boolean judge(int[] A, int nLeft, int nRight){
            if(nLeft>=nRight)
                return true;

            int i = nRight-1;
            int nRoot = A[nRight];

            while(i>nLeft && A[i]>nRoot)    //Ҫ��д>=�ᱨ��
                --i;
            for(int j = i-1; j>=nLeft; j--){    //������j=i-1,��Ȼ�ᱨ��
                if(A[j]>nRoot)
                    return false;
            }

            return judge(A,nLeft,i-1) && judge(A, i+1, nRight-1);//���˵�AC�õ�judge(A, i, nRight-1)���Ҿ���i+1�ȽϺ���

        }
    }

}
