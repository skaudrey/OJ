package Practice.NiuKeOJ;

import java.util.ArrayList;

/**
 * PathOfBianryTree
 *
 * @author Mia Feng
 * @date 2018/4/5
 *
 * 剑指offer
 *
 * 题目描述：
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *
 * 深度优先，但是如果从当前结点查到了最后一个没有找到期望的路径的话，需要回退。
 */
public class PathOfBianryTree {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public class Solution {
        ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
            if(root==null)
                return listAll;
            list.add(root.val);
            target -= root.val;
            if(target==0 && root.left==null && root.right==null)
                listAll.add(new ArrayList<Integer>(list));
            FindPath(root.left,target);
            FindPath(root.right,target);
            list.remove(list.size()-1);//当前节点出发的深度遍历完成后要回退

            return listAll;
        }
    }
}