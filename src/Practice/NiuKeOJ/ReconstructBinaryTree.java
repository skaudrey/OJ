package Practice.NiuKeOJ;

/**
 * ReconstructBinaryTree
 *
 * @author Mia Feng
 * @date 2018/3/29
 *
 * 剑指offer
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * 又是对递归的活用
 *
 * 没想出来。。但是树的左右子树的确是这样递归压栈做出来的
 *
 * 对整个树序列做递归，但是其实
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
            TreeNode root = new TreeNode(pre[nStartPre]);//注意这里不是以0为根，考虑到实际递归，需要以nStartPre为根

            for(int i = nStartIn; i <= nEndIn; i++ ){//注意这里也不是全长度检测，只到nEndIn（==nEndIn），因为已经递归了
                if(pre[nStartPre] == in[i]){
                    root.left = reConstructBinaryTree(pre, nStartPre+1, i-nStartIn+nStartPre, in, nStartIn, i-1);//注意子树是从nStartPre+1开始
                    root.right = reConstructBinaryTree(pre, i-nStartIn+nStartPre+1, nEndPre, in, i+1, nEndIn);//注意是子树啊，没有节点i所以是i+1开始
                }
            }
            return root;
        }


    }
}