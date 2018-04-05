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
 * ��ָoffer
 * ��Ŀ����
�������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��

 �������Ĳ������:�ö���ά��
 �ð�һֱ��û��������Щ�����������ű��˵�˼·��һ�°�
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