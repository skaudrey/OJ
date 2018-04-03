package Practice.NiuKeOJ;

/**
 * MirrorTree
 *
 * @author Mia Feng
 * @date 2018/4/3
 *
 * ��ָoffer
 * ���������Ķ�����������任ΪԴ�������ľ���
��������:
�������ľ����壺Դ������
8
/  \
6   10
/ \  / \
5  7 9 11
���������
8
/  \
10   6
/ \  / \
11 9 7  5

 �ݹ飬ֻҪ�ڵ㲻Ϊ�գ��ͽ��������������������ҵ�˳��
 */
public class MirrorTree {


     public class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
     this.val = val;

     }

     }

    public class Solution {
        public void Mirror(TreeNode root) {
            TreeNode tmp ;

            if(root!=null){
                tmp = root.left;
                root.left = root.right;
                root.right = tmp;

                if(root.left!=null)
                    Mirror(root.left);
                if(root.right!=null)
                    Mirror(root.right);

            }

        }
    }

}
