package Practice.NiuKeOJ;

/**
 * HasSubTree
 *
 * @author Mia Feng
 * @date 2018/4/1
 *
 *剑指offer
 *
 * 题目描述
输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）

 嗯，碰到数哇，链表反转啊，果然都是递归大法
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
                return true;    //树2已经遍历完了，肯定是树1的子树了
            if(root1.val != root2.val)  //出现任何一个不等的数就不是树一的子树了
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