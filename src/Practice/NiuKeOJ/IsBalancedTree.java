package Practice.NiuKeOJ;

/**
 * IsBalancedTree
 *
 * @author: Mia Feng
 * @date: 2018/4/10
 *
 *
 * 剑指offer
 *
 * 题目描述
输入一棵二叉树，判断该二叉树是否是平衡二叉树。

 嗯。。。
 平衡二叉树指的是任意两棵子树的树高之差不大于1
 */
public class IsBalancedTree {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private boolean isBalanced = true;

    public boolean IsBalanced_Solution(TreeNode root) {

        getDepth(root);

        return isBalanced;
    }

    public int getDepth(TreeNode root){
        if(root==null)
            return 0;

        int left = getDepth(root.left);
        int right = getDepth(root.right);

        if(Math.abs(right-left)>1)
            isBalanced = false;

        return right>left? right+1: left+1;
    }

}
