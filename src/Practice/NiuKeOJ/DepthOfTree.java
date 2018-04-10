package Practice.NiuKeOJ;

/**
 * DepthOfTree
 *
 * @author: Mia Feng
 * @date: 2018/4/10
 *
 * 剑指offer
 *
 * 题目描述
输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。

 DFS
 递归，人家的方法还是很巧妙的。。但是这个depth的整数一定在递归时是传进去的

 */
public class DepthOfTree {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public int TreeDepth(TreeNode root) {
        return depth(root,0);
    }

    public int depth(TreeNode root, int nD){
        if(root == null)
            return nD;
        nD++;

        return Math.max(depth(root.left,nD),depth(root.right,nD));
    }

}
