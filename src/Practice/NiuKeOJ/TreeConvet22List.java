package Practice.NiuKeOJ;

/**
 * TreeConvet22List
 *
 * @author: Mia Feng
 * @date: 2018/4/8
 *
 * 剑指offer
 *
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * 中序遍历？？
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

            //注意这里讲pRootOfTree指向下一个
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
