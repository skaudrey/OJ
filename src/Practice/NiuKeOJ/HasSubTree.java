package Practice.NiuKeOJ;

/**
 * HasSubTree
 *
 * @author Mia Feng
 * @date 2018/4/1
 *
 *��ָoffer
 *
 * ��Ŀ����
�������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ��

 �ţ��������ۣ�����ת������Ȼ���ǵݹ��
 */
public class HasSubTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }


    public class Solution {

        public boolean isSubTree(TreeNode root1, TreeNode root2) {

            if(root1==null && root2 != null)
                return false;
            if(root2==null)
                return true;    //��2�Ѿ��������ˣ��϶�����1��������
            if(root1.val != root2.val)  //�����κ�һ�����ȵ����Ͳ�����һ��������
                return true;

            return isSubTree(root1.left,root2.left)&&isSubTree(root1.right,root2.right);
        }

        public boolean HasSubtree(TreeNode root1,TreeNode root2) {
            boolean result = false;
            if(root1!=null && root2 != null){
                if(root1.val == root2.val)
                    result = isSubTree(root1,root2);
                if(!result)
                    result = HasSubtree(root1.left,root2);
                if (!result)
                    result = HasSubtree(root1.right,root2);
            }
            return result;
        }

    }


}