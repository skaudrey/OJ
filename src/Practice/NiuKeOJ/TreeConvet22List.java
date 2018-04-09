package Practice.NiuKeOJ;

/**
 * TreeConvet22List
 *
 * @author: Mia Feng
 * @date: 2018/4/8
 *
 * ��ָoffer
 *
 * ����һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
 *
 * �����������
 */
public class TreeConvet22List {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) { this.val = val; }
     }
    public class Solution {
        TreeNode leftHead = null;
        TreeNode rightHead = null;

        public TreeNode Convert(TreeNode pRootOfTree) {

            if(pRootOfTree==null)
                return null;

            Convert(pRootOfTree.left);

            if(rightHead==null)
                leftHead = rightHead = pRootOfTree;

            //ע�����ｲpRootOfTreeָ����һ��
            else{
                rightHead.right = pRootOfTree;
                pRootOfTree.left = rightHead;
                rightHead = pRootOfTree;
            }

            Convert(pRootOfTree.right);

            return pRootOfTree;

        }
    }

}
