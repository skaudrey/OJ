package Practice.NiuKeOJ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * PrintBinaryTree
 *
 * @author Mia Feng
 * @date 2018/4/3
 *
 * 剑指offer
 * 题目描述
从上往下打印出二叉树的每个节点，同层节点从左至右打印。

 二叉树的层序遍历:用队列维持
 好吧一直就没有理解过这些东西，先照着别人的思路敲一下吧
 */
public class PrintBinaryTree {

    public static void main(String[] args){

    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public class Solution {

        ArrayList<Integer> result = new ArrayList<>();
        public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

            if(root==null)
                return result;

            Queue<TreeNode> queue = new LinkedList<>();

            queue.offer(root);

            while(!queue.isEmpty()){
                TreeNode tmp = queue.poll();

                if(tmp.left!=null)
                    queue.offer(tmp.left);
                if(tmp.right!=null)
                    queue.offer(tmp.right);

                result.add(tmp.val);
            }
            return result;
        }
    }
}