package Practice.NiuKeOJ;

/**
 * ReconstructBinaryTree
 *
 * @author Mia Feng
 * @date 2018/3/29
 *
 * ��ָoffer
 *
 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö�������
 * ���������ǰ���������������Ľ���ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
 *
 * ���ǶԵݹ�Ļ���
 *
 * û���������������������������ȷ�������ݹ�ѹջ��������
 *
 * ���������������ݹ飬������ʵ
 */
public class ReconstructBinaryTree {

      //Definition for binary tree
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public class Solution {

        public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
            TreeNode tree = reConstructBinaryTree(pre, 0, pre.length-1, in, 0, in.length-1);
            return tree;
        }

        private TreeNode reConstructBinaryTree(int[] pre, int nStartPre, int nEndPre, int[] in, int nStartIn, int nEndIn){
            if(nStartPre>nEndPre || nStartIn> nEndIn)
                return null;
            TreeNode root = new TreeNode(pre[nStartPre]);//ע�����ﲻ����0Ϊ�������ǵ�ʵ�ʵݹ飬��Ҫ��nStartPreΪ��

            for(int i = nStartIn; i <= nEndIn; i++ ){//ע������Ҳ����ȫ���ȼ�⣬ֻ��nEndIn��==nEndIn������Ϊ�Ѿ��ݹ���
                if(pre[nStartPre] == in[i]){
                    root.left = reConstructBinaryTree(pre, nStartPre+1, i-nStartIn+nStartPre, in, nStartIn, i-1);//ע�������Ǵ�nStartPre+1��ʼ
                    root.right = reConstructBinaryTree(pre, i-nStartIn+nStartPre+1, nEndPre, in, i+1, nEndIn);//ע������������û�нڵ�i������i+1��ʼ
                }
            }
            return root;
        }


    }
}